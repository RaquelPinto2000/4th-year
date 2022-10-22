package clientSide.stubs;

import clientSide.entities.Chef;

import clientSide.entities.ChefStates;
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
 *  Stub to the bar stub
 *
 *    It instantiates a remote reference to the bar stub.
 *    Implementation of a client-server model of type 2 (server replication).
 *    Communication is based on a communication channel under the TCP protocol.
 */
public class BarStub {
	/**
	 * Name of the platform where is located the bar server.
	 */

	private String serverHostName;

	/**
	 * Port number for listening to service requests.
	 */

	private int serverPortNumb;

	/**
	 * Instantiation of a stub to the bar.
	 *
	 * @param serverHostName name of the platform where is located the bar server
	 * @param serverPortNumb port number for listening to service requests
	 */
	public BarStub(String serverHostName, int serverPortNumb) {
		this.serverHostName = serverHostName;
		this.serverPortNumb = serverPortNumb;
	}

	/**
	 * Operation look around
	 *
	 * It is called by a waiter to look around
	 * 
	 * @return oper operation to be performed
	 */
	public char lookAround() {
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
		outMessage = new Message(MessageType.REQLOOKAROUND, ((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.LOOKAROUNDDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		return inMessage.getOp();
	}

	
	/**
	 * Operation return to the bar after salute
	 *
	 * It is called by a waiter to return to the bar after saluting the student
	 * 
	 */
	public void returnToTheBarAfterSalute() {
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
		outMessage = new Message(MessageType.REQRETURNBARSALUTE, ((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RETURNBARSALUTEDONE)) {
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
	 * Operation return to the bar after taking the order
	 *
	 * It is called by a waiter to return to the bar after taking the order
	 * 
	 */
	public void returnToTheBarAfterTakingTheOrder() {
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
		outMessage = new Message(MessageType.REQRETURNBARTAKINGORDER, ((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RETURNBARTAKINGORDERDONE)) {
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
	 * Operation return to the bar after portions delivered
	 *
	 * It is called by a waiter to the bar after all portions of a course have been
	 * delivered
	 * 
	 */
	public void returnToTheBarAfterPortionsDelivered() {
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
		outMessage = new Message(MessageType.REQRETURNBARPORTIONSDELIVERED,
				((Waiter) Thread.currentThread()).getWaiterID(), ((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RETURNBARPORTIONSDELIVEREDDONE)) {
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
	 * Operation prepare the bill
	 *
	 * It is called by a waiter to prepare the bill
	 * 
	 */
	public void prepareBill() {
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
		outMessage = new Message(MessageType.REQPREPAREBILL, ((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.PREPAREBILLDONE)) {
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
	 * Operation received payment
	 *
	 * It is called by a waiter after the payment has been received
	 * 
	 */
	public void receivedPayment() {
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
		outMessage = new Message(MessageType.REQRECEIVEDPAYMENT, ((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RECEIVEDPAYMENTDONE)) {
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
	 * Operation return to the bar
	 *
	 * It is called by a waiter to return to the bar
	 * 
	 */
	public void returnToTheBar() {
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
		outMessage = new Message(MessageType.REQRETURNBAR, ((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RETURNBARDONE)) {
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
	 * Operation say goodbye
	 *
	 * It is called by a waiter to say goodbye to the student
	 * 
	 */
	public void sayGoodbye() {
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
		outMessage = new Message(MessageType.REQSAYGOODBYE, ((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.SAYGOODBYEDONE)) {
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
	 * Operation alert waiter
	 *
	 * It is called by a chef to warn the waiter that a portions is ready to be
	 * delivered
	 * 
	 */
	public void alertWaiter() {
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
		outMessage = new Message(MessageType.REQALWAITER, ((Chef) Thread.currentThread()).getChefID(),
				((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.ALWAITERDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < ChefStates.WAFOR) || (inMessage.getChefState() > ChefStates.CLSSV)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid chef state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid chef id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Chef) Thread.currentThread()).setChefState(inMessage.getChefState());
	}

	/**
	 * Operation enter
	 *
	 * It is called by a student to enter the restaurant
	 * 
	 */
	public void enter() {
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
		outMessage = new Message(MessageType.REQENTER, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.ENTERDONE)) {
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
	 * Operation call the waiter
	 *
	 * It is called by a student to call the waiter to describe the order
	 * 
	 */
	public void callTheWaiter() {
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
		outMessage = new Message(MessageType.REQCALLWAITER, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.CALLWAITERDONE)) {
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
	 * Operation signal waiter
	 *
	 * It is called by a student to warn the waiter that it can start delivering the
	 * portions of the next course
	 * 
	 */
	public void signalWaiter() {
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
		outMessage = new Message(MessageType.REQSIGNALWAITER, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.SIGNALWAITERDONE)) {
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
	 * Operation should have arrived earlier
	 *
	 * It is called by a student to warn the waiter that it is ready to pay the bill
	 * 
	 */
	public void shouldHaveArrivedEarlier() {
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
		outMessage = new Message(MessageType.REQARREARLIER, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.ARREARLIERDONE)) {
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
	 * Operation go home
	 *
	 * It is called by a student to warn the waiter that its going home
	 * 
	 */
	public void goHome() {
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
		outMessage = new Message(MessageType.REQGOHOME, ((Student) Thread.currentThread()).getStudentID(),
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.GOHOMEDONE)) {
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
	 * @param waiterId waiter id
	 */

	public void endOperation(int waiterId) {
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
		outMessage = new Message(MessageType.ENDOPWAITER, waiterId);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.ENDOPDONEWAITER) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if (inMessage.getWaiterId() != waiterId) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter here id!");
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
