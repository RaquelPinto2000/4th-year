package commInfra;

import java.io.Serializable;
import java.util.Arrays;

import genclass.GenericIO;


/**
 *   Internal structure of the exchanged messages.
 *
 *   Implementation of a client-server model of type 2 (server replication).
 *   Communication is based on a communication channel under the TCP protocol.
 */
public class Message implements Serializable {
	/**
	 * Serialization key.
	 */

	private static final long serialVersionUID = 2021L;

	/**
	 * Student state.
	 */
	private int studentState = -1;

	/**
	 * student identification.
	 */
	private int studentId = -1;
	/**
	 * Chef state.
	 */
	private int chefState = -1;

	/**
	 * chef identification.
	 */
	private int chefId = -1;
	/**
	 * Waiter state.
	 */
	private int waiterState = -1;
	/**
	 * waiter identification.
	 */
	private int waiterId = -1;
	/**
	 * waiter operation.
	 */
	private char op = ' ';

	/**
	 * Message type.
	 */
	private int msgType = -1;
	/**
	 * Name of the logging file.
	 */
	private String fName = null;
	/**
	 * End of operations (chef).
	 */

	private boolean endOpchef = false;
	
	/**
	 * All portions been served flag.
	 */

	private boolean allServed = false;
	
	/**
	 * First to enter flag.
	 */

	private boolean firstEnter = false;
	
	/**
	 * Last to eat flag.
	 */

	private boolean lastEat = false;
	
	/**
	 * Last to enter flag.
	 */

	private boolean lastEnter = false;
	
	/**
	 * Portion delivered flag.
	 */

	private boolean allPortionDelivered = false;
	
	/**
	 * Order completed flag.
	 */

	private boolean orderCompleted = false;
	
	/**
	 * Student seat at the table.
	 */

	private int seat = -1;
	
	/**
	 * Number of portions delivered.
	 */

	private int portionsDelivered = -1;
	
	/**
	 * Number of courses delivered.
	 */

	private int coursesDelivered = -1;


	/**
	 * Message instantiation (form 1).
	 *
	 * @param type message type
	 */
	public Message(int type) {
		msgType = type;
	}

	/**
	 * Message instantiation (form 2).
	 *
	 * @param type message type
	 * @param name name of the logging file
	 */
	public Message(int type, String name) {
		msgType = type;
		fName = name;
	}

	/**
	 * Message instantiation (form 3).
	 *
	 * @param type  message type
	 * @param id    entity identification
	 * @param state entity state
	 */
	public Message(int type, int id, int state) {
		msgType = type;
		// Waiter
		if ((msgType == MessageType.RETURNBARSALUTEDONE) || (msgType == MessageType.RETURNBARPORTIONSDELIVEREDDONE)
				|| (msgType == MessageType.PREPAREBILLDONE) || (msgType == MessageType.RETURNBARDONE)
				|| (msgType == MessageType.SAYGOODBYEDONE) || (msgType == MessageType.NOTECHEFDONE)
				|| (msgType == MessageType.COLLECTPORTIONDONE) || (msgType == MessageType.SALUTECLIENTDONE)
				|| (msgType == MessageType.GETPADDONE) || (msgType == MessageType.APORTSERVEDDONE)
				|| (msgType == MessageType.DELIVERPORTIONDONE) || (msgType == MessageType.STWST)
				|| (msgType == MessageType.REQRETURNBARSALUTE) || (msgType == MessageType.REQRETURNBARTAKINGORDER)
				|| (msgType == MessageType.REQRETURNBARPORTIONSDELIVERED) || (msgType == MessageType.REQPREPAREBILL)
				|| (msgType == MessageType.REQRECEIVEDPAYMENT) || (msgType == MessageType.REQRETURNBAR)
				|| (msgType == MessageType.REQSAYGOODBYE) || (msgType == MessageType.REQNOTECHEF)
				|| (msgType == MessageType.REQCOLLECTPORTION) || (msgType == MessageType.REQSALUTECLIENT)
				|| (msgType == MessageType.REQGETPAD) || (msgType == MessageType.REQDELIVERPORTION)
				|| (msgType == MessageType.REQPRESENTBILL) || (msgType == MessageType.PRESENTBILLDONE)
				|| (msgType == MessageType.REQLOOKAROUND) || (msgType == MessageType.RETURNBARTAKINGORDERDONE)
				|| (msgType == MessageType.REQAPORTSERVED) || (msgType == MessageType.RECEIVEDPAYMENTDONE)) {
			waiterState = state;
			waiterId = id;
		}
		// student 
		else if ((msgType == MessageType.STSST) || (msgType == MessageType.ENTERDONE)
				|| (msgType == MessageType.CALLWAITERDONE) || (msgType == MessageType.ARREARLIERDONE)
				|| (msgType == MessageType.SIGNALWAITERDONE) || (msgType == MessageType.GOHOMEDONE)
				|| (msgType == MessageType.TAKESEATDONE) || (msgType == MessageType.SELCOURSEDONE)
				|| (msgType == MessageType.FIRSTENTERDONE) || (msgType == MessageType.INFORMCOMPANIONSDONE)
				|| (msgType == MessageType.ORGORDERDONE) || (msgType == MessageType.DESCORDERDONE)
				|| (msgType == MessageType.CHATDONE) || (msgType == MessageType.ENJOYMEALDONE)
				|| (msgType == MessageType.LASTEATDONE) || (msgType == MessageType.CHATAGAINDONE)
				|| (msgType == MessageType.EVERYONEFINISHDONE) || (msgType == MessageType.LASTENTERRESTAURANTDONE)
				|| (msgType == MessageType.REQENTER) || (msgType == MessageType.REQSELCOURSE)
				|| (msgType == MessageType.REQCALLWAITER) || (msgType == MessageType.REQSIGNALWAITER)
				|| (msgType == MessageType.REQGOHOME) || (msgType == MessageType.REQTAKESEAT) 
				|| (msgType == MessageType.REQINFORMCOMPANIONS) || (msgType == MessageType.REQORGORDER)
				|| (msgType == MessageType.REQDESCORDER) || (msgType == MessageType.REQCHAT)
				|| (msgType == MessageType.REQENJOYMEAL) || (msgType == MessageType.REQCHATAGAIN)
				|| (msgType == MessageType.REQEVERYONEFINISH) || (msgType == MessageType.REQHONORBILL)
				|| (msgType == MessageType.HONORBILLDONE) || (msgType == MessageType.REQFIRSTENTER)
				|| (msgType == MessageType.REQLASTEAT) || (msgType == MessageType.REQLASTENTERRESTAURANT)
				|| (msgType == MessageType.REQARREARLIER)) {
			studentState = state;
			studentId = id;
		} // chef
		else if ((msgType == MessageType.ALWAITERDONE) || (msgType == MessageType.WAFORDONE)
				|| (msgType == MessageType.PRPCSDONE) || (msgType == MessageType.CONTPREDONE)
				|| (msgType == MessageType.PROPREDONE) || (msgType == MessageType.DEPORTDONE)
				|| (msgType == MessageType.APORTDELIVEDDONE) || (msgType == MessageType.HNPORTREADYDONE)
				|| (msgType == MessageType.ALERTWAITERDONE) || (msgType == MessageType.STCST)
				|| (msgType == MessageType.REQALWAITER) || (msgType == MessageType.REQWAFOR)
				|| (msgType == MessageType.REQPRPCS) || (msgType == MessageType.REQCONTPRE)
				|| (msgType == MessageType.REQPROPRE) || (msgType == MessageType.REQDEPORT)
				|| (msgType == MessageType.REQHNPORTREADY) || (msgType == MessageType.REQALERTWAITER)
				|| (msgType == MessageType.REQCLEANUP) || (msgType == MessageType.CLEANUPDONE) 
				|| (msgType == MessageType.REQWAFOR) || (msgType == MessageType.REQAPORTDELIVED)
				|| (msgType == MessageType.REQORDERCOMPLET) || (msgType == MessageType.ORDERCOMPLETDONE)) {
			chefState = state;
			chefId = id;
		} else if (msgType == MessageType.STSSEAT) {
			studentId = id;
			seat = state;
		}
		else {
			GenericIO.writelnString("Message type = " + msgType + ": non-implemented instantiation!");
			System.exit(1);
		}
	}

	/**
	 * Message instantiation (form 4).
	 *
	 * @param type message type
	 * @param id   entity identification
	 */
	public Message(int type, int id) {
		msgType = type;
		// waiter
		if ((msgType == MessageType.ENDOPDONEWAITER) || (msgType == MessageType.ENDOPWAITER)) {
			waiterId = id;
		}
		// student
		else if ((msgType == MessageType.ENDOPDONESTUDENT) || (msgType == MessageType.ENDOPSTUDENT)) {
			studentId = id;
		}
		// chef
		else if ((msgType == MessageType.ENDOPDONECHEF) || (msgType == MessageType.ENDOPCHEF)) {
			chefId = id;
		} // student
		else if ((msgType == MessageType.STSPD)) {
			portionsDelivered = id;
		}else if ((msgType == MessageType.STSCD)) {
			coursesDelivered = id;
		}
		else {
			GenericIO.writelnString("Message type = " + msgType + ": non-implemented instantiation!");
			System.exit(1);
		}
	}

	/**
	 * Message instantiation (form 5).
	 *
	 * @param type  message type
	 * @param endOp end of operations flag
	 */

	public Message(int type, boolean endOp) {
		msgType = type;
		this.endOpchef = endOp;
	}

	/**
	 * Message instantiation (form 6).
	 *
	 * @param type  message type
	 * @param id    waiter identification
	 * @param state waiter state
	 * @param op    operation char
	 */

	public Message(int type, int id, int state, char op) {
		msgType = type;
		if ((msgType == MessageType.LOOKAROUNDDONE)) {
			waiterState = state;
			waiterId = id;
			this.op = op;
		} else {
			GenericIO.writelnString("Message type = " + msgType + ": non-implemented instantiation!");
			System.exit(1);
		}
	}
	
	/**
	 * Message instantiation (form 7).
	 *
	 * @param type  message type
	 * @param id    waiter identification
	 * @param f boolean flag
	 */

	public Message(int type, int id, boolean f) {
		msgType = type;
		if ((msgType == MessageType.APORTSERVEDDONE)) {
			waiterId = id;
			allServed = f;
		} else if ((msgType == MessageType.FIRSTENTERDONE)) {
			studentId = id;
			firstEnter = f;
		}else if ((msgType == MessageType.LASTEATDONE)) {
			studentId = id;
			lastEat = f;
		}else if ((msgType == MessageType.LASTENTERRESTAURANTDONE)) {
			studentId = id;
			lastEnter = f;
		}else if ((msgType == MessageType.APORTDELIVEDDONE)) {
			chefId = id;
			allPortionDelivered = f;
		}else if ((msgType == MessageType.ORDERCOMPLETDONE)) {
			chefId = id;
			orderCompleted = f;
		}
		else {
			GenericIO.writelnString("Message type = " + msgType + ": non-implemented instantiation!");
			System.exit(1);
		}
	}

	/**
	 * Getting message type.
	 *
	 * @return message type
	 */
	public int getMsgType() {
		return (msgType);
	}

	/**
	 * Getting name of logging file.
	 *
	 * @return name of the logging file
	 */

	public String getLogFName() {
		return (fName);
	}

	/**
	 * Getting student identification.
	 *
	 * @return student identification
	 */

	public int getStudentId() {
		return (studentId);
	}

	/**
	 * Getting student state.
	 *
	 * @return student state
	 */

	public int getStudentState() {
		return (studentState);
	}

	/**
	 * Getting chef identification.
	 *
	 * @return chef identification
	 */

	public int getChefId() {
		return (chefId);
	}

	/**
	 * Getting chef state.
	 *
	 * @return chef state
	 */

	public int getChefState() {
		return (chefState);
	}

	/**
	 * Getting waiter identification.
	 *
	 * @return waiter identification
	 */

	public int getWaiterId() {
		return (waiterId);
	}

	/**
	 * Getting waiter state.
	 *
	 * @return waiter state
	 */

	public int getWaiterState() {
		return (waiterState);
	}

	/**
	 * Getting end of operations flag (chef).
	 *
	 * @return end of operations flag
	 */

	public boolean getEndOpChef() {
		return (endOpchef);
	}
	
	/**
	 * Getting all portions delivered flag.
	 *
	 * @return all portions delivered flag
	 */
	
	public boolean getHaveAllPortionsBeenServed() {
		return (allServed);
	}
	
	/**
	 * Getting first to enter flag.
	 *
	 * @return first to enter flag
	 */
	
	public boolean getFirstToEnter() {
		return (firstEnter);
	}
	
	/**
	 * Getting eat to eat flag.
	 *
	 * @return eat to eat flag
	 */
	
	public boolean getLastToEat() {
		return (lastEat);
	}
	
	/**
	 * Getting last to enter the restaurant flag.
	 *
	 * @return last to enter the restaurant flag
	 */
	
	public boolean getlastToEnter() {
		return (lastEnter);
	}
	
	/**
	 * Getting all portions delivered flag.
	 *
	 * @return all portion delivered  flag
	 */
	
	public boolean getAllPortionDelivered() {
		return (allPortionDelivered);
	}
	
	/**
	 * Getting order completed flag.
	 *
	 * @return order completed flag
	 */
	
	public boolean getOrderCompleted() {
		return (orderCompleted);
	}

	/**
	 * Getting next operation of waiter (waiter).
	 *
	 * @return op operation to be performed
	 */

	public char getOp() {
		return (op);
	}
	
	/**
	 * Getting student seat at the table (student).
	 *
	 * @return seat seat number
	 */

	public int getSeat() {
		return (seat);
	}

	/**
	 * Getting the number of portions delivered (student).
	 *
	 * @return portionsDelivered number of portions delivered
	 */

	public int getPortionsDelivered() {
		return (portionsDelivered);
	}
	
	/**
	 * Getting the number of courses delivered (student).
	 *
	 * @return coursesDelivered number of courses delivered
	 */

	public int getCoursesDelivered() {
		return (coursesDelivered);
	}

	@Override
	public String toString() {
		return "Message [studentState=" + studentState + ", studentId=" + studentId + ", chefState=" + chefState
				+ ", chefId=" + chefId + ", waiterState=" + waiterState + ", waiterId=" + waiterId + ", op=" + op
				+ ", seat=" + seat + ", msgType=" + msgType + ", fName=" + fName + ", endOpchef="
				+ endOpchef + ", allServed=" + allServed + ", firstEnter=" + firstEnter + ", lastEat=" + lastEat
				+ ", lastEnter=" + lastEnter + ", allPortionDelivered=" + allPortionDelivered + ", orderCompleted="
				+ orderCompleted + "]";
	}
}
