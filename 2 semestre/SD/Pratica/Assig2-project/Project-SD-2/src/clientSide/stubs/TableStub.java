package clientSide.stubs;

import clientSide.entities.Student;
import clientSide.entities.StudentStates;
import clientSide.entities.Waiter;
import clientSide.entities.WaiterStates;
import commInfra.ClientCom;
import commInfra.Message;
import commInfra.MessageType;
import genclass.GenericIO;
import serverSide.main.SimulPar;

/**
 *  Stub to the table stub
 *
 *    It instantiates a remote reference to the table stub.
 *    Implementation of a client-server model of type 2 (server replication).
 *    Communication is based on a communication channel under the TCP protocol.
 */
public class TableStub {

	/**
	 * Name of the platform where is located the table server.
	 */

	private String serverHostName;

	/**
	 * Port number for listening to service requests.
	 */

	private int serverPortNumb;

	/**
	 * Instantiation of a stub to the table.
	 *
	 * @param serverHostName name of the platform where is located the table
	 *                       server
	 * @param serverPortNumb port number for listening to service requests
	 */

	public TableStub(String serverHostName, int serverPortNumb) {
		this.serverHostName = serverHostName;
		this.serverPortNumb = serverPortNumb;
	}


	/**
	 * Operation salute the client.
	 *
	 * It is called by a waiter to salute the client
	 * 
	 */
	public void saluteTheClient() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQSALUTECLIENT, ((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		
		if ((inMessage.getMsgType() != MessageType.SALUTECLIENTDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.APPST) || (inMessage.getWaiterState() > WaiterStates.RECPM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Waiter) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
	}

	/**
	 * Operation get the pad
	 *
	 * It is called by a waiter to get the pad
	 * 
	 */
	public void getThePad() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQGETPAD, ((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.GETPADDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.APPST) || (inMessage.getWaiterState() > WaiterStates.RECPM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Waiter) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
	}

	/**
	 * Operation have all portions been served
	 *
	 * It is called by a waiter to know if all the portions have been served
	 * 
	 * @return  true if have all portions been served - 
	 * 		   false, otherwise 
	 */
	public boolean haveAllPortionsBeenServed() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQAPORTSERVED, ((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.APORTSERVEDDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		return inMessage.getHaveAllPortionsBeenServed();
	}

	/**
	 * Operation deliver portion.
	 *
	 * It is called by a waiter to deliver a portion to a student
	 * 
	 */
	public void deliverPortion() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQDELIVERPORTION, ((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.DELIVERPORTIONDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.APPST) || (inMessage.getWaiterState() > WaiterStates.RECPM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Waiter) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
	}

	/**
	 * Operation present the bill.
	 *
	 * It is called by a waiter to present the bill to the student
	 * 
	 */
	public void presentBill() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQPRESENTBILL, ((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.PRESENTBILLDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.APPST) || (inMessage.getWaiterState() > WaiterStates.RECPM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Waiter) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
	}

	/**
	 * Operation take a seat
	 *
	 * It is called by a student when it wants to take a seat at the table
	 * 
	 */
	public void takeASeat() {

		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQTAKESEAT, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();

		if ((inMessage.getMsgType() != MessageType.TAKESEATDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());
	}

	/**
	 * Operation selecting the course
	 *
	 * It is called by a student to know if all the portions have been served
	 * 
	 */
	public void selectingCourse() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQSELCOURSE, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.SELCOURSEDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());

	}

	/**
	 * Operation first to enter
	 *
	 * It is called by a student to know if it was the first to enter in the
	 * restaurant
	 * 
	 * @return  true if the student was the first to enter - 
	 * 		   false, otherwise 
	 */
	public boolean firstToEnter() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQFIRSTENTER, ((Student) Thread.currentThread()).getStudentID(),
					((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.FIRSTENTERDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		return inMessage.getFirstToEnter();
	}

	/**
	 * Operation inform companions
	 *
	 * It is called by a student to inform the companion about its order
	 */
	public void informCompanions() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQINFORMCOMPANIONS, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.INFORMCOMPANIONSDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());

	}

	/**
	 * Operation organize order
	 *
	 * It is called by a student to start organizing the order
	 * 
	 */
	public void organizeOrder() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQORGORDER, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.ORGORDERDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());

	}

	/**
	 * Operation describe order
	 *
	 * It is called by a student to describe the order to the waiter
	 * 
	 */
	public void describeOrder() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQDESCORDER, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.DESCORDERDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());

	}
	
	/**
	 * Operation chat
	 *
	 * It is called by a student to start chatting with the companions
	 * 
	 */
	public void chat() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQCHAT, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.CHATDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());

	}


	/**
	 * Operation enjoy the meal
	 *
	 * It is called by a student to start eating the portion
	 * 
	 */
	public void enjoyMeal() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQENJOYMEAL, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.ENJOYMEALDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());

	}

	/**
	 * Operation last to eat
	 *
	 * It is called by a student to know if it was the last to eat the portion
	 * 
	 * @return true if the student was the last to eat - 
	 * 		   false, otherwise 
	 */
	public boolean lastToEat() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQLASTEAT, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.LASTEATDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		return inMessage.getLastToEat();
	}

	/**
	 * Operation chatAgain
	 *
	 * It is called by the last student to eat to wake up the other students
	 * 
	 */
	public void chatAgain() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQCHATAGAIN, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.CHATAGAINDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());
	}

	/**
	 * Operation wait for everyone to finish
	 *
	 * It is called by a student to wait of everyone to finish eating the current
	 * course
	 * 
	 */
	public void waitForEveryoneToFinish() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQEVERYONEFINISH, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.EVERYONEFINISHDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());
	}

	/**
	 * Operation last to enter restaurant
	 *
	 * It is called by a student to know if it was the last to enter in the
	 * restaurant
	 * 
	 * @return true if the student was the last to enter in the restaurant - 
	 * 		   false, otherwise 
	 */
	public boolean lastToEnterRestaurant() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQLASTENTERRESTAURANT, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());	
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.LASTENTERRESTAURANTDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		return inMessage.getlastToEnter();
	}

	/**
	 * Operation honor the bill
	 *
	 * It is called by a student to honor the bill
	 * 
	 */
	public void honorTheBill() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQHONORBILL, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.HONORBILLDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());
	}

	/**
	 * Operation end of work.
	 *
	 * New operation.
	 * 
	 * @param studentId student id
	 */

	public void endOperation(int studentId) {
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
		// form 4 (type, id)
		outMessage = new Message(MessageType.ENDOPSTUDENT, studentId);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.ENDOPDONESTUDENT) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if (inMessage.getStudentId() != studentId) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
	}

	/**
	 * Operation server shutdown.
	 *
	 * New operation.
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
}
