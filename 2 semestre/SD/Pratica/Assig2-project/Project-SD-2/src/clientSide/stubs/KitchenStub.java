package clientSide.stubs;

import clientSide.entities.Chef;
import clientSide.entities.ChefStates;
import clientSide.entities.Waiter;
import clientSide.entities.WaiterStates;
import commInfra.ClientCom;
import commInfra.Message;
import commInfra.MessageType;
import genclass.GenericIO;
import serverSide.main.SimulPar;

/**
 *  Stub to the kitchen stub
 *
 *    It instantiates a remote reference to the kitchen stub.
 *    Implementation of a client-server model of type 2 (server replication).
 *    Communication is based on a communication channel under the TCP protocol.
 */
public class KitchenStub {

	/**
	 * Name of the platform where is located the kitchen server.
	 */

	private String serverHostName;

	/**
	 * Port number for listening to service requests.
	 */

	private int serverPortNumb;

	/**
	 * Instantiation of a stub to the kitchen.
	 *
	 * @param serverHostName name of the platform where is located the kitchen
	 *                       server
	 * @param serverPortNumb port number for listening to service requests
	 */

	public KitchenStub(String serverHostName, int serverPortNumb) {
		this.serverHostName = serverHostName;
		this.serverPortNumb = serverPortNumb;
	}

	/**
	 * Operation watch the news.
	 *
	 * It is called by a chef while waiting for and order to be delivered by the
	 * waiter.
	 *
	 */
	public void watchTheNews() {

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
		outMessage = new Message(MessageType.REQWAFOR, ((Chef) Thread.currentThread()).getChefID(),
				((Chef) Thread.currentThread()).getChefState());

		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.WAFORDONE)) {
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
	 * Operation start preparations.
	 *
	 * It is called by a chef after receiving and order
	 *
	 */
	public void startPreparations() {
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
		outMessage = new Message(MessageType.REQPRPCS, ((Chef) Thread.currentThread()).getChefID(),
				((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.PRPCSDONE)) {
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
	 * Operation continue preparations.
	 *
	 * It is called by a chef after the chef delivered a portion
	 *
	 */

	public void continuePreparation() {
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
		outMessage = new Message(MessageType.REQCONTPRE, ((Chef) Thread.currentThread()).getChefID(),
				((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.CONTPREDONE)) {
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
	 * Operation proceed to presentation.
	 *
	 * It is called by a chef after preparing a portion
	 *
	 */
	public void proceedToPresentation() {
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
		outMessage = new Message(MessageType.REQPROPRE, ((Chef) Thread.currentThread()).getChefID(),
				((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.PROPREDONE)) {
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
	 * Operation deliver portion.
	 *
	 * It is called by a chef to deliver a portion to the waiter
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
		outMessage = new Message(MessageType.REQDEPORT, ((Chef) Thread.currentThread()).getChefID(),
				((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.DEPORTDONE)) {
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
	 * Operation all portions delivered.
	 *
	 * It is called by a chef to know if all portion have been delivered
	 *
	 * @return true if have all portions delivered - 
	 * 		   false, otherwise 
	 */
	public boolean allPortionsDelived() {
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
		outMessage = new Message(MessageType.REQAPORTDELIVED, ((Chef) Thread.currentThread()).getChefID(),
				((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.APORTDELIVEDDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		return inMessage.getAllPortionDelivered();
	}

	/**
	 * Operation have next portion ready.
	 *
	 * It is called by a chef in order to start dishing another portion
	 *
	 */

	public void haveNextPortionReady() {
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
		outMessage = new Message(MessageType.REQHNPORTREADY, ((Chef) Thread.currentThread()).getChefID(),
				((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.HNPORTREADYDONE)) {
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
	 * Operation order been completed.
	 *
	 * It is called by a chef in order to know if the order has been completed
	 *
	 * @return true if  order has been completed - 
	 * 		   false, otherwise  
	 */
	public boolean orderBeenCompleted() {
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
		outMessage = new Message(MessageType.REQORDERCOMPLET, ((Chef) Thread.currentThread()).getChefID(),
				((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.ORDERCOMPLETDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		return inMessage.getOrderCompleted();
	}

	/**
	 * Operation alert waiter
	 *
	 * It is called by a chef to warn the waiter that a portion is ready to be
	 * collected
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
		outMessage = new Message(MessageType.REQALERTWAITER, ((Chef) Thread.currentThread()).getChefID(),
				((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.ALERTWAITERDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < ChefStates.WAFOR) || (inMessage.getChefState() > ChefStates.CLSSV)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid chef state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Chef) Thread.currentThread()).setChefState(inMessage.getChefState());
	}

	/**
	 * Operation clean up.
	 *
	 * It is called by a chef to finish its service
	 *
	 */
	public void cleanUp() {
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
		outMessage = new Message(MessageType.REQCLEANUP, ((Chef) Thread.currentThread()).getChefID(),
				((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.CLEANUPDONE)) {
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
	 * Operation hand the note to the Chef.
	 *
	 * It is called by a waiter to deliver the order to the chef
	 * 
	 */
	public void handTheNoteToTheChef() {
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
		outMessage = new Message(MessageType.REQNOTECHEF, ((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.NOTECHEFDONE)) {
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
	 * Operation collect portion.
	 *
	 * It is called by a waiter to collect a portion
	 *
	 */
	public void collectPortion() {
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
		outMessage = new Message(MessageType.REQCOLLECTPORTION, ((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.COLLECTPORTIONDONE)) {
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
	 * Operation end of work.
	 *
	 * New operation.
	 * 
	 * @param chefId chef id
	 */

	public void endOperation(int chefId) {
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
		outMessage = new Message(MessageType.ENDOPCHEF, chefId);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.ENDOPDONECHEF) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if (inMessage.getChefId() != chefId) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid chef id!");
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
