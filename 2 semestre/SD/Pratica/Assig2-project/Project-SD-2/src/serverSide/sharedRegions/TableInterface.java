package serverSide.sharedRegions;

import clientSide.entities.StudentStates;
import clientSide.entities.WaiterStates;
import commInfra.Message;
import commInfra.MessageException;
import commInfra.MessageType;
import genclass.GenericIO;
import serverSide.entities.TableClientProxy;
import serverSide.main.SimulPar;

/**
 *  Interface to the Table.
 *
 *    It is responsible to validate and process the incoming message, execute the corresponding method on the
 *    table and generate the outgoing message.
 *    Implementation of a client-server model of type 2 (server replication).
 *    Communication is based on a communication channel under the TCP protocol.
 */
public class TableInterface {
	/**
	 * Reference to the table.
	 */

	private final Table table;

	/**
	 * Instantiation of an interface to the table.
	 *
	 * @param table reference to the table
	 */

	public TableInterface(Table table) {
		this.table = table;
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

		//GenericIO.writelnString("Process and reply table");
		switch (inMessage.getMsgType()) {
		case MessageType.REQSALUTECLIENT:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W))
				throw new MessageException("Invalid waiter id!", inMessage);
			else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM))
				throw new MessageException("Invalid waiter state!", inMessage);
			break;

		case MessageType.REQGETPAD:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W))
				throw new MessageException("Invalid waiter id!", inMessage);
			else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM))
				throw new MessageException("Invalid waiter state!", inMessage);
			break;

		case MessageType.REQAPORTSERVED:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W))
				throw new MessageException("Invalid waiter id!", inMessage);
			else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM))
				throw new MessageException("Invalid waiter state!", inMessage);
			break;

		case MessageType.REQDELIVERPORTION:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W))
				throw new MessageException("Invalid waiter id!", inMessage);
			else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM))
				throw new MessageException("Invalid waiter state!", inMessage);
			break;
		case MessageType.REQPRESENTBILL:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W))
				throw new MessageException("Invalid waiter id!", inMessage);
			else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM))
				throw new MessageException("Invalid waiter state!", inMessage);
			break;

		case MessageType.REQTAKESEAT:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;

		case MessageType.REQSELCOURSE:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;
		case MessageType.REQFIRSTENTER:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);

		case MessageType.REQINFORMCOMPANIONS:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;
		case MessageType.REQORGORDER:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;
		case MessageType.REQDESCORDER:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;
		case MessageType.REQCHAT:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;

		case MessageType.REQENJOYMEAL:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;
		case MessageType.REQLASTEAT:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;
		case MessageType.REQCHATAGAIN:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;
		case MessageType.REQEVERYONEFINISH:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;
		case MessageType.REQLASTENTERRESTAURANT:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;
		case MessageType.REQHONORBILL:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;

		case MessageType.ENDOPSTUDENT:
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			break;
		case MessageType.SHUT: // check nothing
			break;
		default:
			throw new MessageException("Invalid message type!", inMessage);
		}

		/* processing */

		switch (inMessage.getMsgType()) {
		case MessageType.REQSALUTECLIENT:
			((TableClientProxy) Thread.currentThread()).setWaiterID(inMessage.getWaiterId());
			((TableClientProxy) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
			table.saluteTheClient();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.SALUTECLIENTDONE,
					((TableClientProxy) Thread.currentThread()).getWaiterID(),
					((TableClientProxy) Thread.currentThread()).getWaiterState());
			break;
		case MessageType.REQGETPAD:
			((TableClientProxy) Thread.currentThread()).setWaiterID(inMessage.getWaiterId());
			((TableClientProxy) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
			table.getThePad();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.GETPADDONE, 
					((TableClientProxy) Thread.currentThread()).getWaiterID(),
					((TableClientProxy) Thread.currentThread()).getWaiterState());
			break;
		case MessageType.REQAPORTSERVED:
			((TableClientProxy) Thread.currentThread()).setWaiterID(inMessage.getWaiterId());
			((TableClientProxy) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
			if (table.haveAllPortionsBeenServed()) {
				// form 7 (type, id , flag)
				outMessage = new Message(MessageType.APORTSERVEDDONE,
						((TableClientProxy) Thread.currentThread()).getWaiterID(), true);
			}else {
				outMessage = new Message(MessageType.APORTSERVEDDONE,
						((TableClientProxy) Thread.currentThread()).getWaiterID(), false);
			}
			
			break;
		case MessageType.REQDELIVERPORTION:
			((TableClientProxy) Thread.currentThread()).setWaiterID(inMessage.getWaiterId());
			((TableClientProxy) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
			table.deliverPortion();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.DELIVERPORTIONDONE,
					((TableClientProxy) Thread.currentThread()).getWaiterID(),
					((TableClientProxy) Thread.currentThread()).getWaiterState());
			break;
		case MessageType.REQPRESENTBILL:
			((TableClientProxy) Thread.currentThread()).setWaiterID(inMessage.getWaiterId());
			((TableClientProxy) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
			table.presentBill();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.PRESENTBILLDONE,
					((TableClientProxy) Thread.currentThread()).getWaiterID(),
					((TableClientProxy) Thread.currentThread()).getWaiterState());
			break;
		case MessageType.REQTAKESEAT:
			((TableClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((TableClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			table.takeASeat();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.TAKESEATDONE,
					((TableClientProxy) Thread.currentThread()).getStudentID(),
					((TableClientProxy) Thread.currentThread()).getStudentState());
			break;
		case MessageType.REQSELCOURSE:
			((TableClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((TableClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			table.selectingCourse();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.SELCOURSEDONE,
					((TableClientProxy) Thread.currentThread()).getStudentID(),
					((TableClientProxy) Thread.currentThread()).getStudentState());
			break;
		case MessageType.REQFIRSTENTER:
			((TableClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((TableClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			if (table.firstToEnter()) {
				// form 7 (type, id , f)
				outMessage = new Message(MessageType.FIRSTENTERDONE,
						((TableClientProxy) Thread.currentThread()).getStudentID(), true);
			} else {
				// form 7 (type, id , f)
				outMessage = new Message(MessageType.FIRSTENTERDONE,
						((TableClientProxy) Thread.currentThread()).getStudentID(), false);
			}
			
			break;
		case MessageType.REQINFORMCOMPANIONS:
			((TableClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((TableClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			table.informCompanions();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.INFORMCOMPANIONSDONE,
					((TableClientProxy) Thread.currentThread()).getStudentID(),
					((TableClientProxy) Thread.currentThread()).getStudentState());
			break;
		case MessageType.REQORGORDER:
			((TableClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((TableClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			table.organizeOrder();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.ORGORDERDONE,
					((TableClientProxy) Thread.currentThread()).getStudentID(),
					((TableClientProxy) Thread.currentThread()).getStudentState());
			break;
		case MessageType.REQDESCORDER:
			((TableClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((TableClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			table.describeOrder();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.DESCORDERDONE,
					((TableClientProxy) Thread.currentThread()).getStudentID(),
					((TableClientProxy) Thread.currentThread()).getStudentState());
			break;
		case MessageType.REQCHAT:
			((TableClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((TableClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			table.chat();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.CHATDONE, 
					((TableClientProxy) Thread.currentThread()).getStudentID(),
					((TableClientProxy) Thread.currentThread()).getStudentState());
			break;

		case MessageType.REQENJOYMEAL:
			((TableClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((TableClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			table.enjoyMeal();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.ENJOYMEALDONE,
					((TableClientProxy) Thread.currentThread()).getStudentID(),
					((TableClientProxy) Thread.currentThread()).getStudentState());
			break;
		case MessageType.REQLASTEAT:
			((TableClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((TableClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			if (table.lastToEat()) {
				// form 7 (type, id , f)
				outMessage = new Message(MessageType.LASTEATDONE,
						((TableClientProxy) Thread.currentThread()).getStudentID(), true);
			} else {
				// form 7 (type, id , f)
				outMessage = new Message(MessageType.LASTEATDONE,
						((TableClientProxy) Thread.currentThread()).getStudentID(), false);
			}			
			break;
		case MessageType.REQCHATAGAIN:
			((TableClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((TableClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			table.chatAgain();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.CHATAGAINDONE,
					((TableClientProxy) Thread.currentThread()).getStudentID(),
					((TableClientProxy) Thread.currentThread()).getStudentState());
			break;
		case MessageType.REQEVERYONEFINISH:
			((TableClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((TableClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			table.waitForEveryoneToFinish();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.EVERYONEFINISHDONE,
					((TableClientProxy) Thread.currentThread()).getStudentID(),
					((TableClientProxy) Thread.currentThread()).getStudentState());
			break;
		case MessageType.REQLASTENTERRESTAURANT:
			((TableClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((TableClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			if (table.lastToEnterRestaurant()) {
				// form 7 (type, id , f)
				outMessage = new Message(MessageType.LASTENTERRESTAURANTDONE,
						((TableClientProxy) Thread.currentThread()).getStudentID(), true);
			} else {
				// form 7 (type, id , f)
				outMessage = new Message(MessageType.LASTENTERRESTAURANTDONE,
						((TableClientProxy) Thread.currentThread()).getStudentID(), false);
			}
			break;
		case MessageType.REQHONORBILL:
			((TableClientProxy) Thread.currentThread()).setStudentID(inMessage.getStudentId());
			((TableClientProxy) Thread.currentThread()).setStudentState(inMessage.getStudentState());
			table.honorTheBill();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.HONORBILLDONE,
					((TableClientProxy) Thread.currentThread()).getStudentID(),
					((TableClientProxy) Thread.currentThread()).getStudentState());
			break;

		case MessageType.ENDOPSTUDENT:
			table.endOperation(inMessage.getStudentId());
			outMessage = new Message(MessageType.ENDOPDONESTUDENT, inMessage.getStudentId());
			break;
		case MessageType.SHUT:
			table.shutdown();
			outMessage = new Message(MessageType.SHUTDONE);
			break;
		}

		return (outMessage);
	}
}
