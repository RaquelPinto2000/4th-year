package clientSide.entities;

import clientSide.stubs.BarStub;
import clientSide.stubs.KitchenStub;
import genclass.GenericIO;

/**
 * Chef thread.
 *
 * Used to simulate the Chef life cycle.
 * Implementation of a client-server model of type 2 (server replication).
 * Communication is based on a communication channel under the TCP protocol.
 */
public class Chef extends Thread {
	/**
	 * Chef identification
	 */
	private int chefID;
	/**
	 * Chef state
	 */
	private int chefState;
	/**
	 * Reference to the Bar
	 */
	private final BarStub barStub;
	/**
	 * Reference to the Kitchen
	 */
	private final KitchenStub kitStub;

	/**
	 * Instantiation of a Chef Thread
	 * 
	 * @param name      thread name
	 * @param chefID    ID of the chef
	 * @param chefState state of the chef
	 * @param barStub       reference of the BarStub
	 * @param kitStub       reference of the KitchenStub
	 */
	public Chef(String name, int chefID, int chefState, BarStub barStub, KitchenStub kitStub) {
		super(name);
		this.chefID = chefID;
		this.chefState = ChefStates.WAFOR;
		this.barStub = barStub;
		this.kitStub = kitStub;
	}

	/**
	 * Get Chef ID
	 * 
	 * @return chefID
	 */
	public int getChefID() {
		return chefID;
	}

	/**
	 * Set Chef ID
	 * 
	 * @param chefID
	 */
	public void setChefID(int chefID) {
		this.chefID = chefID;
	}

	/**
	 * Get Chef state
	 * 
	 * @return chefState
	 */
	public int getChefState() {
		return chefState;
	}

	/**
	 * Set Chef state
	 * 
	 * @param chefState
	 */
	public void setChefState(int chefState) {
		this.chefState = chefState;
	}

	/**
	 * Regulates the life cycle of the Chef
	 */

	@Override
	public void run() {
		boolean firstCourse = true;
		// Transition to 'WAFOR'
		kitStub.watchTheNews();
		// Transition to 'PRPCS'
		kitStub.startPreparations();
		do {
			if (!firstCourse) {
				// Transition to 'PRPCS'
				kitStub.continuePreparation();
			} else {
				firstCourse = false;
			}
			// Transition to 'DSHPT'
			kitStub.proceedToPresentation();
			barStub.alertWaiter();
			// Transition to 'DLVPT'
			kitStub.deliverPortion();
			while (!kitStub.allPortionsDelived()) {
				// Transition to 'DSHPT'
				kitStub.haveNextPortionReady();
				kitStub.alertWaiter();
				// Transition to 'DLVPT'
				kitStub.deliverPortion();
			}
		} while (!kitStub.orderBeenCompleted());
		// Transition to 'CLSSV'
		kitStub.cleanUp();
	}

}
