package serverSide.sharedRegions;

import clientSide.entities.ChefStates;
import clientSide.entities.WaiterStates;
import commInfra.Message;
import commInfra.MessageException;
import commInfra.MessageType;
import genclass.GenericIO;
import serverSide.entities.KitchenClientProxy;
import serverSide.main.SimulPar;

/**
 *  Interface to the Kitchen.
 *
 *    It is responsible to validate and process the incoming message, execute the corresponding method on the
 *    kitchen and generate the outgoing message.
 *    Implementation of a client-server model of type 2 (server replication).
 *    Communication is based on a communication channel under the TCP protocol.
 */
public class KitchenInterface {
	/**
	 * Reference to the kitchen.
	 */

	private final Kitchen kitchen;

	/**
	 * Instantiation of an interface to the kitchen.
	 *
	 * @param kitchen reference to the kitchen
	 */

	public KitchenInterface(Kitchen kitchen) {
		this.kitchen = kitchen;
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
		case MessageType.REQWAFOR:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			} else if ((inMessage.getChefState() < ChefStates.WAFOR) || (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQPRPCS:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			} else if ((inMessage.getChefState() < ChefStates.WAFOR) || (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQCONTPRE:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			} else if ((inMessage.getChefState() < ChefStates.WAFOR) || (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQPROPRE:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			} else if ((inMessage.getChefState() < ChefStates.WAFOR) || (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQDEPORT:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			} else if ((inMessage.getChefState() < ChefStates.WAFOR) || (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQAPORTDELIVED:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			} else if ((inMessage.getChefState() < ChefStates.WAFOR) || (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQHNPORTREADY:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			} else if ((inMessage.getChefState() < ChefStates.WAFOR) || (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQALERTWAITER:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			} else if ((inMessage.getChefState() < ChefStates.WAFOR) || (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQCLEANUP:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			} else if ((inMessage.getChefState() < ChefStates.WAFOR) || (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQNOTECHEF:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.C)) {
				throw new MessageException("Invalid waiter id!", inMessage);
			} else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM)) {
				throw new MessageException("Invalid waiter state!", inMessage);
			}
			break;
		case MessageType.REQCOLLECTPORTION:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.C)) {
				throw new MessageException("Invalid waiter id!", inMessage);
			} else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM)) {
				throw new MessageException("Invalid waiter state!", inMessage);
			}
			break;
		case MessageType.REQORDERCOMPLET:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			} else if ((inMessage.getChefState() < ChefStates.WAFOR)
					|| (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.ENDOPCHEF:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			}
			break;
		case MessageType.SHUT: // check nothing
			break;
		default:
			throw new MessageException("Invalid message type!", inMessage);
		}

		/* processing */

		switch (inMessage.getMsgType())

		{
		case MessageType.REQWAFOR:
			((KitchenClientProxy) Thread.currentThread()).setChefID(inMessage.getChefId());
			((KitchenClientProxy) Thread.currentThread()).setChefState(inMessage.getChefState());
			kitchen.watchTheNews();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.WAFORDONE, 
					((KitchenClientProxy) Thread.currentThread()).getChefID(),
					((KitchenClientProxy) Thread.currentThread()).getChefState());
			break;
		case MessageType.REQPRPCS:
			((KitchenClientProxy) Thread.currentThread()).setChefID(inMessage.getChefId());
			((KitchenClientProxy) Thread.currentThread()).setChefState(inMessage.getChefState());
			kitchen.startPreparations();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.PRPCSDONE, 
					((KitchenClientProxy) Thread.currentThread()).getChefID(),
					((KitchenClientProxy) Thread.currentThread()).getChefState());
			break;
		case MessageType.REQCONTPRE:
			((KitchenClientProxy) Thread.currentThread()).setChefID(inMessage.getChefId());
			((KitchenClientProxy) Thread.currentThread()).setChefState(inMessage.getChefState());
			kitchen.continuePreparation();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.CONTPREDONE, 
					((KitchenClientProxy) Thread.currentThread()).getChefID(),
					((KitchenClientProxy) Thread.currentThread()).getChefState());
			break;
		case MessageType.REQPROPRE:
			((KitchenClientProxy) Thread.currentThread()).setChefID(inMessage.getChefId());
			((KitchenClientProxy) Thread.currentThread()).setChefState(inMessage.getChefState());
			kitchen.proceedToPresentation();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.PROPREDONE, 
					((KitchenClientProxy) Thread.currentThread()).getChefID(),
					((KitchenClientProxy) Thread.currentThread()).getChefState());
			break;

		case MessageType.REQDEPORT:
			((KitchenClientProxy) Thread.currentThread()).setChefID(inMessage.getChefId());
			((KitchenClientProxy) Thread.currentThread()).setChefState(inMessage.getChefState());
			kitchen.deliverPortion();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.DEPORTDONE, 
					((KitchenClientProxy) Thread.currentThread()).getChefID(),
					((KitchenClientProxy) Thread.currentThread()).getChefState());
			break;
		case MessageType.REQAPORTDELIVED:
			((KitchenClientProxy) Thread.currentThread()).setChefID(inMessage.getChefId());
			((KitchenClientProxy) Thread.currentThread()).setChefState(inMessage.getChefState());
			if (kitchen.allPortionsDelived()) {
				// form 7 (type, id , f)
				outMessage = new Message(MessageType.APORTDELIVEDDONE,
						((KitchenClientProxy) Thread.currentThread()).getChefID(), true);
			} else {
				// form 7 (type, id , f)
				outMessage = new Message(MessageType.APORTDELIVEDDONE,
						((KitchenClientProxy) Thread.currentThread()).getChefID(), false);
			}
			break;
		case MessageType.REQORDERCOMPLET:
			((KitchenClientProxy) Thread.currentThread()).setChefID(inMessage.getChefId());
			((KitchenClientProxy) Thread.currentThread()).setChefState(inMessage.getChefState());
			if (kitchen.orderBeenCompleted()) {
				// form 7 (type, id , f)
				outMessage = new Message(MessageType.ORDERCOMPLETDONE,
						((KitchenClientProxy) Thread.currentThread()).getChefID(), true);
			} else {
				// form 7 (type, id , f)
				outMessage = new Message(MessageType.ORDERCOMPLETDONE,
						((KitchenClientProxy) Thread.currentThread()).getChefID(), false);
			}
			break;

		case MessageType.REQHNPORTREADY:
			((KitchenClientProxy) Thread.currentThread()).setChefID(inMessage.getChefId());
			((KitchenClientProxy) Thread.currentThread()).setChefState(inMessage.getChefState());
			kitchen.haveNextPortionReady();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.HNPORTREADYDONE,
					((KitchenClientProxy) Thread.currentThread()).getChefID(),
					((KitchenClientProxy) Thread.currentThread()).getChefState());
			break;
		case MessageType.REQALERTWAITER:
			((KitchenClientProxy) Thread.currentThread()).setChefID(inMessage.getChefId());
			((KitchenClientProxy) Thread.currentThread()).setChefState(inMessage.getChefState());
			kitchen.alertWaiter();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.ALERTWAITERDONE,
					((KitchenClientProxy) Thread.currentThread()).getChefID(),
					((KitchenClientProxy) Thread.currentThread()).getChefState());
			break;
		case MessageType.REQCLEANUP:
			((KitchenClientProxy) Thread.currentThread()).setChefID(inMessage.getChefId());
			((KitchenClientProxy) Thread.currentThread()).setChefState(inMessage.getChefState());
			kitchen.cleanUp();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.CLEANUPDONE, 
					((KitchenClientProxy) Thread.currentThread()).getChefID(),
					((KitchenClientProxy) Thread.currentThread()).getChefState());
			break;
		case MessageType.REQNOTECHEF:
			((KitchenClientProxy) Thread.currentThread()).setWaiterID(inMessage.getWaiterId());
			((KitchenClientProxy) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
			kitchen.handTheNoteToTheChef();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.NOTECHEFDONE,
					((KitchenClientProxy) Thread.currentThread()).getWaiterID(),
					((KitchenClientProxy) Thread.currentThread()).getWaiterState());
			break;
		case MessageType.REQCOLLECTPORTION:
			((KitchenClientProxy) Thread.currentThread()).setWaiterID(inMessage.getWaiterId());
			((KitchenClientProxy) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
			kitchen.collectPortion();
			// form 3 (type, id , state)
			outMessage = new Message(MessageType.COLLECTPORTIONDONE,
					((KitchenClientProxy) Thread.currentThread()).getWaiterID(),
					((KitchenClientProxy) Thread.currentThread()).getWaiterState());
			break;
		case MessageType.ENDOPCHEF:
			kitchen.endOperation(inMessage.getChefId());
			outMessage = new Message(MessageType.ENDOPDONECHEF, inMessage.getChefId());
			break;
		case MessageType.SHUT:
			kitchen.shutdown();
			outMessage = new Message(MessageType.SHUTDONE);
			break;
		}

		return (outMessage);
	}

}