package serverSide.sharedRegions;

import clientSide.entities.Chef;
import clientSide.entities.ChefStates;
import clientSide.entities.Waiter;
import clientSide.entities.WaiterStates;
import clientSide.stubs.GeneralReposStub;
import genclass.GenericIO;
import serverSide.entities.KitchenClientProxy;
import serverSide.main.ServerKitchen;
import serverSide.main.SimulPar;

public class Kitchen {

	/**
	 * Kitchen.
	 *
	 * It is responsible for the the synchronization of the chef and waiter during
	 * the order processing and is implemented as an implicit monitor.
	 * 
	 * There is three internal synchronization points: two blocking points for the
	 * chef, where he waits for an order to arrive and to wait for the waiter to
	 * collect a portion; And a single blocking point for the waiter, where he waits
	 * for a portion to be collected
	 */

	/**
	 * Reference to the General Information Repository.
	 */
	private final GeneralReposStub reposStub;
	/**
	 * Reference to chef threads.
	 */

	private final KitchenClientProxy[] chef;
	/**
	 * Boolean flag that indicates if the order has arrived
	 */
	private boolean orderArrived;
	/**
	 * Boolean flag that indicates if the portion was collected
	 */
	private boolean portionCollected;
	/**
	 * Boolean flag that indicates if the portion is ready
	 */
	private boolean portionReady;
	/**
	 * number of the delivered courses
	 */
	private int deliveredCourses;
	/**
	 * number of the delivered portions
	 */
	private int deliveredPortions;
	/**
	 * Number of entity groups requesting the shutdown.
	 */

	private int nEntities;

	/**
	 * Kitchen instantiation
	 * 
	 * @param reposStub reference to the General Information Repository
	 */
	public Kitchen(GeneralReposStub reposStub) {
		this.reposStub = reposStub;
		nEntities = 0;
		chef = new KitchenClientProxy[SimulPar.C];
		for (int i = 0; i < SimulPar.C; i++)
			chef[i] = null;

	}

	/**
	 * Set Portion Collected Flag.
	 *
	 * @param collected portion collected
	 */

	public synchronized void setPortionCollected(boolean collected) {
		portionCollected = collected;
	}

	/**
	 * Set Portion Ready Flag.
	 *
	 * @param ready collected portion ready
	 */

	public synchronized void setPortionReady(boolean ready) {
		portionReady = ready;
	}

	/**
	 * Set Order Arrived Flag.
	 *
	 * @param arrived order has arrived
	 */

	public synchronized void setOrderArrived(boolean arrived) {
		orderArrived = arrived;
	}

	/**
	 * Operation hand the note to the Chef.
	 *
	 * It is called by a waiter to deliver the order to the chef
	 * 
	 */

	public synchronized void handTheNoteToTheChef() {
		// set state of waiter
		((KitchenClientProxy) Thread.currentThread()).setWaiterState(WaiterStates.PCODR);
		reposStub.setWaiterState(((KitchenClientProxy) Thread.currentThread()).getWaiterID(), WaiterStates.PCODR);
		// set orderArrived flag and wake chef
		setOrderArrived(true);
		notifyAll();
	}

	/**
	 * Operation watch the news.
	 *
	 * It is called by a chef while waiting for and order to be delivered by the
	 * waiter.
	 *
	 */

	public synchronized void watchTheNews() {
		// set state of chef
		((KitchenClientProxy) Thread.currentThread()).setChefState(ChefStates.WAFOR);
		reposStub.setChefState(((KitchenClientProxy) Thread.currentThread()).getChefID(), ChefStates.WAFOR);
		// Sleep while waiting for order to arrive
		while (!orderArrived) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		// order has arrived reseting flag
		setOrderArrived(false);
	}

	/**
	 * Operation start preparations.
	 *
	 * It is called by a chef after receiving and order
	 *
	 */

	public synchronized void startPreparations() {
		// set state of chef
		((KitchenClientProxy) Thread.currentThread()).setChefState(ChefStates.PRPCS);
		reposStub.setChefState(((KitchenClientProxy) Thread.currentThread()).getChefID(), ChefStates.PRPCS);
	}

	/**
	 * Operation continue preparations.
	 *
	 * It is called by a chef after the chef delivered a portion
	 *
	 */

	public synchronized void continuePreparation() {
		// set state of chef
		((KitchenClientProxy) Thread.currentThread()).setChefState(ChefStates.PRPCS);
		reposStub.setChefState(((KitchenClientProxy) Thread.currentThread()).getChefID(), ChefStates.PRPCS);
		// reset delivered portions
		deliveredPortions = 0;
	}

	/**
	 * Operation proceed to presentation.
	 *
	 * It is called by a chef after preparing a portion
	 *
	 */

	public synchronized void proceedToPresentation() {
		// set state of chef
		((KitchenClientProxy) Thread.currentThread()).setChefState(ChefStates.DSHPT);
		reposStub.setChefState(((KitchenClientProxy) Thread.currentThread()).getChefID(), ChefStates.DSHPT);
		// set portionReady flag
		setPortionReady(true);
	}

	/**
	 * Operation all portions delivered.
	 *
	 * It is called by a chef to know if all portion have been delivered
	 *
	 * @return true, if all portion have been delivered -
     *            false, otherwise
	 */

	public synchronized boolean allPortionsDelived() {
		return SimulPar.N == deliveredPortions;
	}

	/**
	 * Operation deliver portion.
	 *
	 * It is called by a chef to deliver a portion to the waiter
	 *
	 */

	public synchronized void deliverPortion() {
		// set state of chef
		((KitchenClientProxy) Thread.currentThread()).setChefState(ChefStates.DLVPT);
		reposStub.setChefState(((KitchenClientProxy) Thread.currentThread()).getChefID(), ChefStates.DLVPT);
		// set portionReady flag
		//setPortionReady(true);
		//notifyAll();
		// Sleep while waiting for the portion to be collected
		while (!portionCollected) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		// increment delivered portions
		deliveredPortions++;
		// reseting portionCollected flag
		setPortionCollected(false);
	}

	/**
	 * Operation collect portion.
	 *
	 * It is called by a waiter to collect a portion
	 *
	 */

	public synchronized void collectPortion() {
		// set state of waiter
		((KitchenClientProxy) Thread.currentThread()).setWaiterState(WaiterStates.WTFPT);
		reposStub.setWaiterState(((KitchenClientProxy) Thread.currentThread()).getWaiterID(), WaiterStates.WTFPT);
		// Sleep while waiting for a portion to be ready
		while (!portionReady) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		// reset portionReady flag
		setPortionReady(false);
		// Set portionCollected flag and wake the chef
		setPortionCollected(true);
		notifyAll();
	}

	/**
	 * Operation have next portion ready.
	 *
	 * It is called by a chef in order to start dishing another portion
	 *
	 */

	public synchronized void haveNextPortionReady() {
		// set state of chef
		((KitchenClientProxy) Thread.currentThread()).setChefState(ChefStates.DSHPT);
		reposStub.setChefState(((KitchenClientProxy) Thread.currentThread()).getChefID(), ChefStates.DSHPT);
	}

	/**
	 * Operation order been completed.
	 *
	 * It is called by a chef in order to know if the order has been completed
	 *
	 * @return @return true, if the order has been completed -
     *            false, otherwise
	 */
	

	public synchronized boolean orderBeenCompleted() {
		// increment delivered courses
		deliveredCourses++;
		return SimulPar.M == deliveredCourses;
	}

	/**
	 * Operation clean up.
	 *
	 * It is called by a chef to finish its service
	 *
	 */

	public synchronized void cleanUp() {
		// set state of chef
		((KitchenClientProxy) Thread.currentThread()).setChefState(ChefStates.CLSSV);
		reposStub.setChefState(((KitchenClientProxy) Thread.currentThread()).getChefID(), ChefStates.CLSSV);
	}

	/**
	 * Operation alert waiter
	 *
	 * It is called by a chef to warn the waiter that a portion is ready to be
	 * collected
	 *
	 */
	public synchronized void alertWaiter() {
		// set portionReady flag and waking up the waiter
		setPortionReady(true);
		notifyAll();
	}

	/**
	 * Operation end of work.
	 *
	 * New operation.
	 * 
	 * @param chefID chef identification
	 */

	public synchronized void endOperation(int chefID) {
		while (nEntities == 0) { /* the barber waits for the termination of the customers */
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		if (chef[chefID] != null)
			chef[chefID].interrupt();
	}

	/**
	 * Operation server shutdown.
	 *
	 * New operation.
	 */

	public synchronized void shutdown() {
		nEntities += 1;
		if (nEntities >= SimulPar.EK)
			ServerKitchen.waitConnection = false;
		notifyAll(); // the chef may now terminate
	}

}
