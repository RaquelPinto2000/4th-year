package serverSide.sharedRegions;

import clientSide.entities.ChefStates;
import clientSide.entities.StudentStates;
import clientSide.entities.WaiterStates;
import commInfra.Message;
import commInfra.MessageException;
import commInfra.MessageType;
import genclass.GenericIO;
import serverSide.entities.BarClientProxy;
import serverSide.main.SimulPar;

/**
 *  Interface to the Bar.
 *
 *    It is responsible to validate and process the incoming message, execute the corresponding method on the
 *    bar and generate the outgoing message.
 *    Implementation of a client-server model of type 2 (server replication).
 *    Communication is based on a communication channel under the TCP protocol.
 */
public class BarInterface {

	/**
	 * Reference to the bar.
	 */

	private final Bar bar;

	/**
	 * Instantiation of an interface to the bar.
	 *
	 * @param bar reference to the bar
	 */

	public BarInterface(Bar bar) {
		this.bar = bar;
	}

	/**
	 * Processing of the incoming messages.
	 *
	 * Validation, execution of the corresponding method and generation of the
	 * outgoing message.
	 *
	 * @param inMessage service request
	 * @return outMessage service reply
	 * @throws MessageException if the incoming message is not valid
	 */

	public Message processAndReply(Message inMessage) throws MessageException {
		Message outMessage = null; // outgoing message

		/* validation of the incoming message */

		switch (inMessage.getMsgType()) {
		case MessageType.REQLOOKAROUND:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W))
				throw new MessageException("Invalid waiter id!", inMessage);
			else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM))
				throw new MessageException("Invalid waiter state!", inMessage);
			break;
		case MessageType.REQRETURNBARSALUTE:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W))
				throw new MessageException("Invalid waiter id!", inMessage);
			else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM))
				throw new MessageException("Invalid waiter state!", inMessage);
			break;

		case MessageType.REQRETURNBARTAKINGORDER:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W))
				throw new MessageException("Invalid waiter id!", inMessage);
			else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM))
				throw new MessageException("Invalid waiter state!", inMessage);
			break;
		case MessageType.REQRETURNBARPORTIONSDELIVERED:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W))
				throw new MessageException("Invalid waiter id!", inMessage);
			else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM))
				throw new MessageException("Invalid waiter state!", inMessage);
			break;
		case MessageType.REQPREPAREBILL:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W))
				throw new MessageException("Invalid waiter id!", inMessage);
			else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM))
				throw new MessageException("Invalid waiter state!", inMessage);
			break;
		case MessageType.REQRECEIVEDPAYMENT:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W))
				throw new MessageException("Invalid waiter id!", inMessage);
			else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM))
				throw new MessageException("Invalid waiter state!", inMessage);
			break;			
		case MessageType.REQRETURNBAR:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W))
				throw new MessageException("Invalid waiter id!", inMessage);
			else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM))
				throw new MessageException("Invalid waiter state!", inMessage);
			break;
			
		case MessageType.REQSAYGOODBYE:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W))
				throw new MessageException("Invalid waiter id!", inMessage);
			else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM))
				throw new MessageException("Invalid waiter state!", inMessage);
			break;
		case MessageType.REQALWAITER:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C))
				throw new MessageException("Invalid chef id!", inMessage);
			else if ((inMessage.getChefState() < ChefStates.WAFOR) || (inMessage.getChefState() > ChefStates.CLSSV))
				throw new MessageException("Invalid chef state!", inMessage);
			break;
		case MessageType.REQENTER:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;
		case MessageType.REQCALLWAITER:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;
		case MessageType.REQSIGNALWAITER:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;
		case MessageType.RETURNBARSALUTEDONE:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W))
				throw new MessageException("Invalid waiter id!", inMessage);
			else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM))
				throw new MessageException("Invalid waiter state!", inMessage);
			break;
		case MessageType.REQARREARLIER: 
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;
		case MessageType.REQGOHOME:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;
		case MessageType.ENDOPWAITER:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W))
				throw new MessageException("Invalid waiter id!", inMessage);
			break;
		case MessageType.SHUT: // check nothing
			break;
		default:
			throw new MessageException("Invalid message type!", inMessage);
		}

		/* processing */

		switch (inMessage.getMsgType()) {
		case MessageType.REQLOOKAROUND:
			((BarClientProxy) Thread.currentThread()).setWaiterID(inMessage.getWaiterId());
			((BarClientProxy) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
			char op = bar.lookAround();
			// form 6 (type, id , state, op)
			outMessage = new Message(MessageType.LOOKAROUNDDONE,
					((BarClientProxy) Thread.currentThread()).getWaiterID(),
					((BarClientProxy) Thread.currentThread()).getWaiterState(), op);
			break;
		case MessageType.REQRETURNBARSALUTE:
			((BarClientProxy) Thread.currentThread()).setWaiterID(inMessage.getWaiterId());
			((BarClientProxy) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
			bar.returnToTheBarAfterSalute();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.RETURNBARSALUTEDONE,
					((BarClientProxy) Thread.currentThread()).getWaiterID(),
					((BarClientProxy) Thread.currentThread()).getWaiterState());
			break;
		case MessageType.REQRETURNBARTAKINGORDER:
			((BarClientProxy) Thread.currentThread()).setWaiterID(inMessage.getWaiterId());
			((BarClientProxy) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
			bar.returnToTheBarAfterTakingTheOrder();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.RETURNBARTAKINGORDERDONE,
					((BarClientProxy) Thread.currentThread()).getWaiterID(),
					((BarClientProxy) Thread.currentThread()).getWaiterState());
			break;
		case MessageType.REQRETURNBARPORTIONSDELIVERED:
			((BarClientProxy) Thread.currentThread()).setWaiterID(inMessage.getWaiterId());
			((BarClientProxy) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
			bar.returnToTheBarAfterPortionsDelivered();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.RETURNBARPORTIONSDELIVEREDDONE,
					((BarClientProxy) Thread.currentThread()).getWaiterID(),
					((BarClientProxy) Thread.currentThread()).getWaiterState());
			break;	
		case MessageType.REQPREPAREBILL:
			((BarClientProxy) Thread.currentThread()).setWaiterID(inMessage.getWaiterId());
			((BarClientProxy) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
			bar.prepareBill();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.PREPAREBILLDONE,
					((BarClientProxy) Thread.currentThread()).getWaiterID(),
					((BarClientProxy) Thread.currentThread()).getWaiterState());
			break;
			
		case MessageType.REQRECEIVEDPAYMENT:
			((BarClientProxy) Thread.currentThread()).setWaiterID(inMessage.getWaiterId());
			((BarClientProxy) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
			bar.receivedPayment();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.RECEIVEDPAYMENTDONE,
					((BarClientProxy) Thread.currentThread()).getWaiterID(),
					((BarClientProxy) Thread.currentThread()).getWaiterState());
			break;
			
		case MessageType.REQRETURNBAR:
			((BarClientProxy) Thread.currentThread()).setWaiterID(inMessage.getWaiterId());
			((BarClientProxy) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
			bar.returnToTheBar();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.RETURNBARDONE, ((BarClientProxy) Thread.currentThread()).getWaiterID(),
					((BarClientProxy) Thread.currentThread()).getWaiterState());
			break;

		case MessageType.REQSAYGOODBYE:
			((BarClientProxy) Thread.currentThread()).setWaiterID(inMessage.getWaiterId());
			((BarClientProxy) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
			bar.sayGoodbye();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.SAYGOODBYEDONE,
					((BarClientProxy) Thread.currentThread()).getWaiterID(),
					((BarClientProxy) Thread.currentThread()).getWaiterState());
			break;
		case MessageType.REQALWAITER:
			((BarClientProxy) Thread.currentThread()).setChefID(inMessage.getChefId());
			((BarClientProxy) Thread.currentThread()).setChefState(inMessage.getChefState());
			bar.alertWaiter();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.ALWAITERDONE, ((BarClientProxy) Thread.currentThread()).getChefID(),
					((BarClientProxy) Thread.currentThread()).getChefState());
			break;

		case MessageType.REQENTER:
			((BarClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((BarClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			bar.enter();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.ENTERDONE, ((BarClientProxy) Thread.currentThread()).getStudentID(),
					((BarClientProxy) Thread.currentThread()).getStudentState());
			break;
		case MessageType.REQCALLWAITER:
			((BarClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((BarClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			bar.callTheWaiter();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.CALLWAITERDONE,
					((BarClientProxy) Thread.currentThread()).getStudentID(),
					((BarClientProxy) Thread.currentThread()).getStudentState());
			break;
		case MessageType.REQSIGNALWAITER:
			((BarClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((BarClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			bar.signalWaiter();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.SIGNALWAITERDONE,
					((BarClientProxy) Thread.currentThread()).getStudentID(),
					((BarClientProxy) Thread.currentThread()).getStudentState());
			break;
		case MessageType.REQARREARLIER:
			((BarClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((BarClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			bar.shouldHaveArrivedEarlier();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.ARREARLIERDONE,
					((BarClientProxy) Thread.currentThread()).getStudentID(),
					((BarClientProxy) Thread.currentThread()).getWaiterState());
			break;
		case MessageType.REQGOHOME:
			((BarClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((BarClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			bar.goHome();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.GOHOMEDONE, ((BarClientProxy) Thread.currentThread()).getStudentID(),
					((BarClientProxy) Thread.currentThread()).getWaiterState());
			break;
		case MessageType.ENDOPWAITER:
			bar.endOperation(inMessage.getWaiterId());
			outMessage = new Message(MessageType.ENDOPDONEWAITER, inMessage.getWaiterId());
			break;
		case MessageType.SHUT:
			bar.shutdown();
			outMessage = new Message(MessageType.SHUTDONE);
			break;
		}

		return (outMessage);
	}

}
