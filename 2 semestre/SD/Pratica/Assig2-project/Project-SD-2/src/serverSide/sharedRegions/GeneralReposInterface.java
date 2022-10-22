package serverSide.sharedRegions;

import clientSide.entities.ChefStates;
import clientSide.entities.StudentStates;
import clientSide.entities.WaiterStates;
import commInfra.Message;
import commInfra.MessageException;
import commInfra.MessageType;
import genclass.GenericIO;
import serverSide.main.SimulPar;

/**
 * Interface to the General Repository of Information.
 *
 * It is responsible to validate and process the incoming message, execute the
 * corresponding method on the General Repository and generate the outgoing
 * message. Implementation of a client-server model of type 2 (server
 * replication). Communication is based on a communication channel under the TCP
 * protocol.
 */

public class GeneralReposInterface {
	/**
	 * Reference to the general repository.
	 */

	private final GeneralRepos repos;

	/**
	 * Instantiation of an interface to the general repository.
	 *
	 * @param repos reference to the general repository
	 */

	public GeneralReposInterface(GeneralRepos repos) {
		this.repos = repos;
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
		Message outMessage = null; // mensagem de resposta

		/* validation of the incoming message */
		switch (inMessage.getMsgType()) {
		case MessageType.SETNFIC:
			if (inMessage.getLogFName() == null)
				throw new MessageException("Name of the logging file is not present!", inMessage);
			break;
		case MessageType.STSST: // estudante
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getStudentState() < StudentStates.GGTRT)
					|| (inMessage.getStudentState() > StudentStates.GGHOM))
				throw new MessageException("Invalid student state!", inMessage);
			break;
		case MessageType.STWST: // waiter
			if ((inMessage.getWaiterState() < WaiterStates.APPST) || (inMessage.getWaiterState() > WaiterStates.RECPM))
				throw new MessageException("Invalid waiter state!", inMessage);
			break;
		case MessageType.STCST: // chef
			if ((inMessage.getChefState() < ChefStates.WAFOR) || (inMessage.getChefState() > ChefStates.CLSSV))
				throw new MessageException("Invalid chef state!", inMessage);
			break;
		case MessageType.STSSEAT: // estudante
			if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S))
				throw new MessageException("Invalid student id!", inMessage);
			else if ((inMessage.getSeat() < 0)
					|| (inMessage.getSeat() >= SimulPar.S))
				throw new MessageException("Invalid student seat!", inMessage);
			break;
		case MessageType.STSPD: // estudante
			if ((inMessage.getPortionsDelivered() < 0) || (inMessage.getPortionsDelivered() > SimulPar.N))
				throw new MessageException("Invalid number of portions delivered!", inMessage);
			break;
		case MessageType.STSCD: // estudante
			if ((inMessage.getCoursesDelivered() < 0) || (inMessage.getCoursesDelivered() > SimulPar.M))
				throw new MessageException("Invalid number of courses delivered!", inMessage);
			break;
		case MessageType.SHUT: // check nothing
			break;
		default:
			throw new MessageException("Invalid message type!", inMessage);
		}

		/* processing */

		switch (inMessage.getMsgType())

		{
		case MessageType.SETNFIC:
			repos.initSimul(inMessage.getLogFName());
			outMessage = new Message(MessageType.NFICDONE);
			break;
		case MessageType.STSST:
			repos.setStudentState(inMessage.getStudentId(), inMessage.getStudentState());
			outMessage = new Message(MessageType.SACK);
			break;
		case MessageType.STWST:
			repos.setWaiterState(inMessage.getWaiterState());
			outMessage = new Message(MessageType.SACK);
			break;
		case MessageType.STCST:
			repos.setChefState(inMessage.getChefState());
			outMessage = new Message(MessageType.SACK);
			break;
		case MessageType.STSSEAT: // student
			repos.setStudentSeat(inMessage.getStudentId(), inMessage.getSeat());
			outMessage = new Message(MessageType.SACK);
			break;
		case MessageType.STSPD: // estudante
			repos.setPortionsDelivered(inMessage.getPortionsDelivered());
			outMessage = new Message(MessageType.SACK);
			break;
		case MessageType.STSCD: // estudante
			repos.setCoursesDelivered(inMessage.getCoursesDelivered());
			outMessage = new Message(MessageType.SACK);
			break;
		case MessageType.SHUT:
			repos.shutdown();
			outMessage = new Message(MessageType.SHUTDONE);
			break;
		}

		return (outMessage);
	}
}
