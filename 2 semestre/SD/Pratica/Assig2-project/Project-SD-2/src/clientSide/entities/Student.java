package clientSide.entities;

import clientSide.stubs.BarStub;
import clientSide.stubs.TableStub;
import genclass.GenericIO;
import serverSide.main.SimulPar;

/**
 * Student thread.
 *
 * Used to simulate the Student life cycle.
 * Implementation of a client-server model of type 2 (server replication).
 * Communication is based on a communication channel under the TCP protocol.
 */
public class Student extends Thread {

	/**
	 * Student identification
	 */
	private int studentID;
	
	/**
	 * Student state
	 */
	private int studentState;

	/*
	 * Number of the seat at the table
	 */
	private int seat;

	/**
	 * Reference to the Bar
	 */
	private final BarStub barStub;

	/**
	 * Reference to the Table
	 */
	private final TableStub tblStub;

	/**
	 * Instantiation of a Student Thread
	 * 
	 * @param name      thread main
	 * @param studentID ID of the student
	 * @param barStub       reference to the BarStub
	 * @param tblStub       reference to the TableStub
	 */
	public Student(String name, int studentID, BarStub barStub, TableStub tblStub) {
		super(name);
		this.studentID = studentID;
		this.studentState = StudentStates.GGTRT;
		this.barStub = barStub;
		this.tblStub = tblStub;
		this.seat = -1;
	}

	/**
	 * Get Student ID
	 * 
	 * @return studentID
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * Set Student ID
	 * 
	 * @param studentID
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	/**
	 * Set number of the seat at the table
	 * 
	 * @param seat
	 */
	public void setSeat(int seat) {
		this.seat = seat;
	}

	/**
	 * Get Student state
	 * 
	 * @return studentState
	 */
	public int getStudentState() {
		return studentState;
	}

	/**
	 * Get number of the seat at the table
	 * 
	 * @return seat
	 */
	public int getSeat() {
		return seat;
	}

	/**
	 * Set Student state
	 * 
	 * @param studentState
	 */
	public void setStudentState(int studentState) {
		this.studentState = studentState;
	}

	/**
	 * Regulates the life cycle of the Student
	 */
	@Override
	public void run() {
		// Transition to 'GGTRT'
		walk();
		barStub.enter();
		// Transition to 'TKSTT'
		tblStub.takeASeat();
		// Transition to 'SELCS'
		tblStub.selectingCourse();
		if (!tblStub.firstToEnter()) {
			tblStub.informCompanions();
		} else {
			// Transition to 'OGODR'
			tblStub.organizeOrder();
			barStub.callTheWaiter();
			tblStub.describeOrder();
		}

		//GenericIO.writelnString("Going chat");
		for (int i = 0; i < SimulPar.M; i++) {
			// Transition to 'CHTWC'
			tblStub.chat();
			//GenericIO.writelnString("Going to eat");
			// Transition to 'EJYML'
			tblStub.enjoyMeal();
			if (tblStub.lastToEat()) {
				if (i != 2) {
					barStub.signalWaiter();
				}
				//tblStub.chatAgain();
			} else {
				// Transition to 'CHTWC'
				tblStub.waitForEveryoneToFinish();
			}
		}
		if (tblStub.lastToEnterRestaurant()) {
			barStub.shouldHaveArrivedEarlier();
			// Transition to 'PYTBL'
			tblStub.honorTheBill();
		}
		// Transition to 'GGHOM'
		barStub.goHome();
	}

	/**
	 * Operation walk
	 *
	 * It is called by a student to wander before entering the restaurant
	 * 
	 * Internal operation.
	 */

	public void walk() {
		long v = (long) (1 + 40 * Math.random());
		try {
			Thread.sleep(v);
		} catch (InterruptedException e) {
		}
	}
}
