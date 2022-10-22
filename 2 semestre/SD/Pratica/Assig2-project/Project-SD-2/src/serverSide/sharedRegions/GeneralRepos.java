package serverSide.sharedRegions;

import java.util.Objects;

import clientSide.entities.ChefStates;
import clientSide.entities.StudentStates;
import clientSide.entities.WaiterStates;
import genclass.GenericIO;
import genclass.TextFile;
import serverSide.main.ServerGeneralRepos;
import serverSide.main.SimulPar;

/**
 * General Repository.
 *
 * It is responsible to keep the visible internal state of the problem and to
 * provide means for it to be printed in the logging file. It is implemented as
 * an implicit monitor. All public methods are executed in mutual exclusion.
 * There are no internal synchronization points.
 */

public class GeneralRepos {

	/**
	 * Name of the logging file.
	 */

	private String logFileName;

	/**
	 * State of the chef
	 */

	private int chefState;

	/**
	 * State of the waiter
	 */

	private int waiterState;

	/**
	 * State of the students
	 */

	private int studentsState[];

	/**
	 * ids of the students in each seat
	 */

	private int seat[];

	/**
	 * Number of portions delivered
	 */

	private int portionsDelivered;

	/**
	 * Number of courses delivered
	 */

	private int coursesDelivered;

	/**
	 * Number of entity groups requesting the shutdown.
	 */

	private int nEntities;

	/**
	 * Instantiation of a general repository object.
	 */

	public GeneralRepos() {
		this.logFileName = "logger";
		chefState = ChefStates.WAFOR;
		waiterState = WaiterStates.APPST;
		studentsState = new int[SimulPar.S];
		seat = new int[SimulPar.S];
		for (int i = 0; i < SimulPar.S; i++) {
			studentsState[i] = StudentStates.GGTRT;
			seat[i] = -1;
		}
		reportInitialStatus();
	}

	/**
	 * Operation initialization of simulation.
	 *
	 * @param logFileName name of the logging file
	 */

	public synchronized void initSimul(String logFileName) {
		if (!Objects.equals(logFileName, ""))
			this.logFileName = logFileName;
		reportInitialStatus();
	}

	/**
	 * Operation server shutdown.
	 *
	 */

	public synchronized void shutdown() {
		nEntities += 1;
		if (nEntities >= SimulPar.EG)
			ServerGeneralRepos.waitConnection = false;
	}

	/**
	 * Set the chef state
	 * 
	 * @param state chef state
	 */
	public synchronized void setChefState(int state) {
		chefState = state;
		reportStatus();
	}

	/**
	 * Set the waiter State
	 * 
	 * @param state waiter state
	 */
	public synchronized void setWaiterState(int state) {
		waiterState = state;
		reportStatus();
	}

	/**
	 * Set the student state
	 * 
	 * @param id    id of the student
	 * @param state student state
	 */
	public synchronized void setStudentState(int id, int state) {
		studentsState[id] = state;
		reportStatus();

	}

	/**
	 * Set the student seat
	 * 
	 * @param studentID student id
	 * @param n
	 */
	public synchronized void setStudentSeat(int studentID, int n) {
		seat[n] = studentID;
	}

	/**
	 * Set the number of portions delivered
	 * 
	 * @param n  number of portions delivered
	 */
	public synchronized void setPortionsDelivered(int n) {
		portionsDelivered = n;
	}

	/**
	 * Set the number courses delivered
	 * 
	 * @param n number courses delivered
	 */
	public synchronized void setCoursesDelivered(int n) {
		coursesDelivered = n;
	}

	/**
	 * Write the header and the initial states to the logging file.
	 *
	 */
	private void reportInitialStatus() {
		TextFile log = new TextFile(); // instantiation of a text file handler
		if (!log.openForWriting(".", logFileName)) {
			GenericIO.writelnString("The operation of creating the file " + logFileName + " failed!");
			System.exit(1);
		}
		log.writelnString(" \t\t\t\t\t\t  The Restaurant - Description of the internal state\n");
		String s = "  Chef  Waiter   Stu0   Stu1   Stu2   Stu3   Stu4   Stu5   Stu6   NCourse  NPortion\t\t\tTable\n State  State   State  State  State  State  State  State  State\t\t\t      \t\tSeat0 Seat1 Seat2 Seat3 Seat4 Seat5 Seat6";
		log.writelnString(s);

		if (!log.close()) {
			GenericIO.writelnString("The operation of closing the file " + logFileName + " failed!");
			System.exit(1);
		}
		reportStatus();
	}

	/**
	 * Write a state line at the end of the logging file.
	 *
	 * The current state of entities is organized in a line to be printed.
	 * 
	 */
	private void reportStatus() {
		TextFile log = new TextFile(); // instantiation of a text file handler
		String lineStatus = ""; // state line to be printed
		if (!log.openForAppending(".", logFileName)) {
			GenericIO.writelnString("The operation of opening for appending the file " + logFileName + " failed!");
			System.exit(1);
		}
		switch (chefState) {
		case ChefStates.WAFOR:
			lineStatus += " WAFOR ";
			break;
		case ChefStates.PRPCS:
			lineStatus += " PRPCS ";
			break;
		case ChefStates.DSHPT:
			lineStatus += " DSHPT ";
			break;
		case ChefStates.DLVPT:
			lineStatus += " DLVPT ";
			break;
		case ChefStates.CLSSV:
			lineStatus += " CLSSV ";
			break;
		}
		switch (waiterState) {
		case WaiterStates.APPST:
			lineStatus += " APPST  ";
			break;
		case WaiterStates.PRSMN:
			lineStatus += " PRSMN  ";
			break;
		case WaiterStates.TKODR:
			lineStatus += " TKODR  ";
			break;
		case WaiterStates.PCODR:
			lineStatus += " PCODR  ";
			break;
		case WaiterStates.WTFPT:
			lineStatus += " WTFPT  ";
			break;
		case WaiterStates.PRCBL:
			lineStatus += " PRCBL  ";
			break;
		case WaiterStates.RECPM:
			lineStatus += " RECPM  ";
			break;
		}
		for (int i = 0; i < SimulPar.S; i++) {
			switch (studentsState[i]) {
			case StudentStates.GGTRT:
				lineStatus += " GGTRT ";
				break;
			case StudentStates.TKSTT:
				lineStatus += " TKSTT ";
				break;
			case StudentStates.SELCS:
				lineStatus += " SELCS ";
				break;
			case StudentStates.OGODR:
				lineStatus += " OGODR ";
				break;
			case StudentStates.CHTWC:
				lineStatus += " CHTWC ";
				break;
			case StudentStates.EJYML:
				lineStatus += " EJYML ";
				break;
			case StudentStates.PYTBL:
				lineStatus += " PYTBL ";
				break;
			case StudentStates.GGHOM:
				lineStatus += " GGHOM ";
				break;
			}
		}
		lineStatus += "     " + coursesDelivered + " \t      " + portionsDelivered + "        ";
		for (int i = 0; i < SimulPar.S; i++) {
			if (seat[i] == -1) {
				lineStatus += " #    ";
			} else {
				lineStatus += " " + seat[i] + "    ";
			}
		}
		log.writelnString(lineStatus);
		if (!log.close()) {
			GenericIO.writelnString("The operation of closing the file " + logFileName + " failed!");
			System.exit(1);
		}
	}
}
