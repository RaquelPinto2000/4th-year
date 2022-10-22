package serverSide.entities;

import clientSide.entities.ChefCloning;
import clientSide.entities.WaiterCloning;
import commInfra.Message;
import commInfra.MessageException;
import commInfra.ServerCom;
import genclass.GenericIO;
import serverSide.sharedRegions.KitchenInterface;

/**
 * Service provider agent for access to the Kitchen.
 *
 * Implementation of a client-server model of type 2 (server replication).
 * Communication is based on a communication channel under the TCP protocol.
 */
public class KitchenClientProxy extends Thread implements ChefCloning, WaiterCloning {
	/**
	 * Chef identification.
	 */

	private int chefID;

	/**
	 * Chef state.
	 */

	private int chefState;
	/**
	 * Waiter identification.
	 */

	private int waiterID;

	/**
	 * Waiter state.
	 */

	private int waiterState;

	/**
	 * Number of instantiayed threads.
	 */

	private static int nProxy = 0;
	/**
	 * Communication channel.
	 */

	private ServerCom sconi;

	/**
	 * Interface to the Kitchen
	 */

	private KitchenInterface KitchenInter;

	/**
	 * Instantiation of a client proxy.
	 *
	 * @param sconi        communication channel
	 * @param KitchenInter interface to the kitchen
	 */

	public KitchenClientProxy(ServerCom sconi, KitchenInterface KitchenInter) {
		super("KitchenProxy" + KitchenClientProxy.getProxyId());
		this.sconi = sconi;
		this.KitchenInter = KitchenInter;
	}

	/**
	 * Generation of the instantiation identifier.
	 *
	 * @return instantiation identifier
	 */

	private static int getProxyId() {
		Class<?> cl = null; // representation of the KitchenClientProxy object in JVM
		int proxyId; // instantiation identifier

		try {
			cl = Class.forName("serverSide.entities.KitchenClientProxy");
		} catch (ClassNotFoundException e) {
			GenericIO.writelnString("Data type KitchenClientProxy was not found!");
			e.printStackTrace();
			System.exit(1);
		}
		synchronized (cl) {
			proxyId = nProxy;
			nProxy += 1;
		}
		return proxyId;
	}

	/**
	 * Get waiter id
	 * 
	 * @return waiterID waiter identifier
	 */
	public int getWaiterID() {
		return waiterID;
	}

	/**
	 * Set waiter id
	 * 
	 * @param waiterID waiter identifier
	 */

	public void setWaiterID(int waiterID) {
		this.waiterID = waiterID;
	}

	/**
	 * Get waiter state
	 * 
	 * @return waiterState waiter state
	 */

	public int getWaiterState() {
		return waiterState;
	}

	/**
	 * Set waiter state
	 * 
	 * @param waiterState waiter state
	 */

	public void setWaiterState(int waiterState) {
		this.waiterState = waiterState;
	}

	/**
	 * Get Chef ID
	 * 
	 * @return chefID chef identifier
	 */
	public int getChefID() {
		return chefID;
	}

	/**
	 * Set Chef ID
	 * 
	 * @param chefID chef identifier
	 */
	public void setChefID(int chefID) {
		this.chefID = chefID;
	}

	/**
	 * Get Chef state
	 * 
	 * @return chefState chef state
	 */
	public int getChefState() {
		return chefState;
	}

	/**
	 * Set Chef state
	 * 
	 * @param chefState chef state
	 */
	public void setChefState(int chefState) {
		this.chefState = chefState;
	}

	/**
	 * Life cycle of the service provider agent.
	 */

	@Override
	public void run() {
		Message inMessage = null, // service request
				outMessage = null; // service reply

		/* service providing */

		inMessage = (Message) sconi.readObject(); // get service request
		try {
			outMessage = KitchenInter.processAndReply(inMessage); // process it
		} catch (MessageException e) {
			GenericIO.writelnString("Thread " + getName() + ": " + e.getMessage() + "!");
			GenericIO.writelnString(e.getMessageVal().toString());
			System.exit(1);
		}
		sconi.writeObject(outMessage); // send service reply
		sconi.close(); // close the communication channel
	}
}
