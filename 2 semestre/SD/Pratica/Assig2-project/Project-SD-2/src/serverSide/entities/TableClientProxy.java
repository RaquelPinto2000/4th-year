package serverSide.entities;

import clientSide.entities.StudentCloning;
import clientSide.entities.WaiterCloning;
import commInfra.Message;
import commInfra.MessageException;
import commInfra.ServerCom;
import genclass.GenericIO;
import serverSide.sharedRegions.TableInterface;

/**
 * Service provider agent for access to the Table.
 *
 * Implementation of a client-server model of type 2 (server replication).
 * Communication is based on a communication channel under the TCP protocol.
 */
public class TableClientProxy extends Thread implements StudentCloning, WaiterCloning {
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
	 * Interface to the Table
	 */

	private TableInterface TableInter;

	/**
	 * Instantiation of a client proxy.
	 *
	 * @param sconi        communication channel
	 * @param TableInter interface to the table
	 */

	public TableClientProxy(ServerCom sconi, TableInterface TableInter) {
		super("TableProxy" + TableClientProxy.getProxyId());
		this.sconi = sconi;
		this.TableInter = TableInter;
	}

	/**
	 * Generation of the instantiation identifier.
	 *
	 * @return instantiation identifier
	 */

	private static int getProxyId() {
		Class<?> cl = null; // representation of the TableClientProxy object in JVM
		int proxyId; // instantiation identifier

		try {
			cl = Class.forName("serverSide.entities.TableClientProxy");
		} catch (ClassNotFoundException e) {
			GenericIO.writelnString("Data type TableClientProxy was not found!");
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
	 * Life cycle of the service provider agent.
	 */

	@Override
	public void run() {
		Message inMessage = null, // service request
				outMessage = null; // service reply

		/* service providing */

		inMessage = (Message) sconi.readObject(); // get service request
		try {
			outMessage = TableInter.processAndReply(inMessage); // process it
		} catch (MessageException e) {
			GenericIO.writelnString("Thread " + getName() + ": " + e.getMessage() + "!");
			GenericIO.writelnString(e.getMessageVal().toString());
			System.exit(1);
		}
		sconi.writeObject(outMessage); // send service reply
		sconi.close(); // close the communication channel
	}
}
