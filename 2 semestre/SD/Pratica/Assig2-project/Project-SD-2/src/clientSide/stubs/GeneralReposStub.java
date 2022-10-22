package clientSide.stubs;

import commInfra.ClientCom;
import commInfra.Message;
import commInfra.MessageType;
import genclass.GenericIO;
/**
 *  Stub to the general repository.
 *
 *    It instantiates a remote reference to the general repository.
 *    Implementation of a client-server model of type 2 (server replication).
 *    Communication is based on a communication channel under the TCP protocol.
 */
public class GeneralReposStub {

	/**
	 * Name of the platform where is located the general repository server.
	 */

	private String serverHostName;

	/**
	 * Port number for listening to service requests.
	 */

	private int serverPortNumb;

	/**
	 * Instantiation of a stub to the general repository.
	 *
	 * @param serverHostName name of the platform where is located the bar, kitchen and table
	 *                       servers
	 * @param serverPortNumb port number for listening to service requests
	 */

	public GeneralReposStub(String serverHostName, int serverPortNumb) {
		this.serverHostName = serverHostName;
		this.serverPortNumb = serverPortNumb;
	}

	/**
	 * Operation initialization of the simulation.
	 *
	 * @param fileName logging file name
	 */

	public void initSimul(String fileName) {
		ClientCom com; // communication channel
		Message outMessage; // outgoing message
		Message inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) {
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.SETNFIC, fileName);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.NFICDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
	}

	/**
	 * Operation server shutdown.
	 *
	 */

	public void shutdown() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) {
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
		}
		// form 1 (type)
		outMessage = new Message(MessageType.SHUT);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.SHUTDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
	}

	/*
	 * Set chef state.
	 *
	 * @param id chef id
	 * @param state chef state
	 */
	public void setChefState(int id, int state) {
		ClientCom com; // communication channel
		Message outMessage; // outgoing message
		Message inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) {
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.STCST, id , state);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.SACK) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
	}

	/*
	 * Set waiter state.
	 *
	 * @param id waiter id
	 * @param state waiter state
	 */
	public void setWaiterState(int id, int state) {
		ClientCom com; // communication channel
		Message outMessage; // outgoing message
		Message inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) {
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.STWST, id , state);
		com.writeObject(outMessage);
		// form 3 (type, id, state)
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.SACK) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
	}

	/*
	 * Set student state.
	 *
	 * @param id student id
	 * @param state student state
	 */
	public void setStudentState(int id, int state) {
		ClientCom com; // communication channel
		Message outMessage; // outgoing message
		Message inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) {
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.STSST, id, state);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.SACK) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
	}

	/*
	 * Set student seat.
	 *
	 * @param studentID student id
	 * @param n student seat at the table
	 */
	public synchronized void setStudentSeat(int studentID, int n) {
		ClientCom com; // communication channel
		Message outMessage; // outgoing message
		Message inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) {
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.STSSEAT, studentID, n);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.SACK) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
	}

	/*
	 * Set number of portions delivered.
	 *
	 * @param n number of portions delivered
	 */
	public void setPortionsDelivered(int n) {
		ClientCom com; // communication channel
		Message outMessage; // outgoing message
		Message inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) {
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.STSPD, n);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.SACK) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
	}

	/*
	 * Set number of courses delivered.
	 *
	 * @param n number of courses delivered
	 */
	public void setCoursesDelivered(int n) {
		ClientCom com; // communication channel
		Message outMessage; // outgoing message
		Message inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) {
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.STSCD, n);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.SACK) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
	}

}
