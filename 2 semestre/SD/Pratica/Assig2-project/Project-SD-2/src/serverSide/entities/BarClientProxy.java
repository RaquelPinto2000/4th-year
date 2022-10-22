package serverSide.entities;

import clientSide.entities.ChefCloning;
import clientSide.entities.StudentCloning;
import clientSide.entities.WaiterCloning;
import commInfra.Message;
import commInfra.MessageException;
import commInfra.ServerCom;
import genclass.GenericIO;
import serverSide.sharedRegions.BarInterface;

/**
 * Service provider agent for access to the Bar.
 *
 * Implementation of a client-server model of type 2 (server replication).
 * Communication is based on a communication channel under the TCP protocol.
 */
public class BarClientProxy extends Thread implements WaiterCloning, StudentCloning, ChefCloning {
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
	 * Student identification
	 */
	private int studentID;

	/**
	 * Student state
	 */
	private int studentState;

	/*
	 * Number of the seat at the table
	 */
	private int seat;
	/**
	 * Number of instantiayed threads.
	 */

	private static int nProxy = 0;
	/**
	 * Communication channel.
	 */

	private ServerCom sconi;

	/**
	 * Interface to the Barber Shop.
	 */

	private BarInterface barInter;

	/**
	 * Instantiation of a client proxy.
	 *
	 * @param sconi      communication channel
	 * @param barInter interface to the bar
	 */

	public BarClientProxy(ServerCom sconi, BarInterface barInter) {
		super("BarProxy" + BarClientProxy.getProxyId());
		this.sconi = sconi;
		this.barInter = barInter;
	}

	/**
	 * Generation of the instantiation identifier.
	 *
	 * @return proxyId instantiation identifier
	 */

	private static int getProxyId() {
		Class<?> cl = null; // representation of the BarberShopClientProxy object in JVM
		int proxyId; // instantiation identifier

		try {
			cl = Class.forName("serverSide.entities.BarClientProxy");
		} catch (ClassNotFoundException e) {
			GenericIO.writelnString("Data type BarClientProxy was not found!");
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
	 * Get Student ID
	 * 
	 * @return studentID student identifier
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * Set Student ID
	 * 
	 * @param studentID student identifier
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	/**
	 * Get number of the seat at the table
	 * 
	 * @return seat number of the seat at the table
	 */
	public int getSeat() {
		return seat;
	}

	/**
	 * Set number of the seat at the table
	 * 
	 * @param seat number of the seat at the table
	 */
	public void setSeat(int seat) {
		this.seat = seat;
	}

	/**
	 * Get Student state
	 * 
	 * @return studentState student state
	 */
	public int getStudentState() {
		return studentState;
	}

	/**
	 * Set Student state
	 * 
	 * @param studentState student state
	 */
	public void setStudentState(int studentState) {
		this.studentState = studentState;
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
			outMessage = barInter.processAndReply(inMessage); // process it
		} catch (MessageException e) {
			GenericIO.writelnString("Thread " + getName() + ": " + e.getMessage() + "!");
			GenericIO.writelnString(e.getMessageVal().toString());
			System.exit(1);
		}
		sconi.writeObject(outMessage); // send service reply
		sconi.close(); // close the communication channel
	}
}
