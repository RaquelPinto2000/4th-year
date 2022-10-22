package serverSide.sharedRegions;

import clientSide.entities.Student;
import clientSide.entities.StudentStates;
import clientSide.entities.Waiter;
import clientSide.entities.WaiterStates;
import clientSide.stubs.GeneralReposStub;
import commInfra.MemException;
import commInfra.MemFIFO;
import genclass.GenericIO;
import serverSide.entities.TableClientProxy;
import serverSide.main.ServerBar;
import serverSide.main.ServerTable;
import serverSide.main.SimulPar;

/**
 * Table.
 *
 * It is responsible for the the synchronization of the Students and Waiter
 * during the dinner process and is implemented as an implicit monitor.
 * 
 * There is ten internal synchronization points: four blocking point for the
 * Waiter, where he waits for the students to read the menu, describe the order,
 * accept a portion and honor the bill; and 6 blocking points for the Students,
 * where a student waits for the waiter to come salute him, for the waiter to
 * get the pad so he can describe the order, the student that has to organize
 * the order waits for everyone to inform him of their order, waits for an new
 * portion to arrive or for the end of the meal, when there are no more courses
 * to be delivered, waits for everyone to finish eating the current course and
 * student that has to honor the bill waits for the waiter to present the bill
 * to him
 */

public class Table {
	/**
	 * Number of entity groups requesting the shutdown.
	 */

	private int nEntities;

	/**
	 * Reference to TableClientProxy threads.
	 */

	private final TableClientProxy[] student;
	/**
	 * id of the last student to eat in a course
	 */
	private int lastToEatID;

	/**
	 * Number of students currently chatting
	 */
	private int nChatting;

	/**
	 * id of the first student to enter the restaurant.
	 */

	private int first;

	/**
	 * number of portions delivered
	 */

	private int portionsDelivered;

	/**
	 * number of courses delivered
	 */

	private int coursesDelivered;

	/**
	 * number of students that entered the restaurant
	 */

	private int nStudents;

	/**
	 * number of students that have eaten a portion of the current course
	 */

	private int eat;

	/**
	 * number of orders received by the student that is organizing the order
	 */

	private int nOrders;

	/**
	 * Boolean flag that indicates if the menu has been read by a student
	 */
	private boolean menuRead;

	/**
	 * Boolean flag that indicates if the bill has been presented to the student
	 */

	private boolean billPresented;

	/**
	 * Boolean flag that indicates if the order has been described to the waiter
	 */

	private boolean orderDescribed;

	/**
	 * Boolean flag that indicates if the bill has been honored
	 */

	private boolean billHonored;

	/**
	 * Boolean flag that indicates if the a student has been saluted
	 */

	private boolean clientSaluted;

	/**
	 * Boolean flag that indicates if the waiter got the pad
	 */

	private boolean gotThePad;

	/**
	 * Boolean flag that indicates if a portion has been delivered
	 */

	private boolean portionDelivered;

	/**
	 * Boolean flag that indicates if everyone has finished eating the current
	 * course
	 */

	private boolean allFinishedEating;

	/**
	 * Boolean flag that indicates if a student has informed the student that is
	 * responsible to take everyones order
	 */

	private boolean informed;

	/**
	 * Boolean flag that indicates if there are no more courses in the order
	 */

	private boolean noMoreCourses;

	/**
	 * Boolean flag that indicates if the portion has been accepted
	 */

	private boolean portionAccepted;

	/**
	 * MemFIFO that has the order of the students at the table
	 */

	private MemFIFO<Integer> seatOrder;

	/**
	 * Reference to the General Repository.
	 */

	private final GeneralReposStub reposStub;
	
	/**
	 * number of students that have left chatting.
	 */

	private int chatLeft;

	/**
	 * Table instantiation.
	 *
	 * @param reposStub reference to the general repository
	 */
	public Table(GeneralReposStub reposStub) {
		// first starts at -1 and only the first student to enter will change it to its
		// ID
		chatLeft = 0;
		first = -1;
		lastToEatID = -1;
		student = new TableClientProxy[SimulPar.S];
		for (int i = 0; i < SimulPar.S; i++)
			student[i] = null;
		try {
			seatOrder = new MemFIFO<>(new Integer[SimulPar.S]);
		} catch (Exception e) {
			seatOrder = null;
			System.exit(1);
		}
		this.reposStub = reposStub;
	}

	/**
	 * Operation salute the client.
	 *
	 * It is called by a waiter to salute the client
	 * 
	 */
	public synchronized void saluteTheClient() {
		// set state of waiter
		((TableClientProxy) Thread.currentThread()).setWaiterState(WaiterStates.PRSMN);
		reposStub.setWaiterState(((TableClientProxy) Thread.currentThread()).getWaiterID(), WaiterStates.PRSMN);
		// setting clientSaluted flag and waking up the student
		setClientSaluted(true);
		notifyAll();
		// Sleep while waiting for the student to read the menu
		while (!menuRead) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		// reset menuRead flag
		menuRead = false;
	}

	/**
	 * Operation deliver portion.
	 *
	 * It is called by a waiter to deliver a portion to a student
	 * 
	 */
	public synchronized void deliverPortion() {
		portionsDelivered++;
		reposStub.setPortionsDelivered(portionsDelivered);
		setPortionDelivered(true);
		notifyAll();
		// Sleep while waiting for the student to accept the portion
		while (!portionAccepted) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		portionAccepted = false;
	}

	/**
	 * Operation present the bill.
	 *
	 * It is called by a waiter to present the bill to the student
	 * 
	 */
	public synchronized void presentBill() {
		// set state of waiter
		((TableClientProxy) Thread.currentThread()).setWaiterState(WaiterStates.RECPM);
		reposStub.setWaiterState(((TableClientProxy) Thread.currentThread()).getWaiterID(), WaiterStates.RECPM);
		billPresented = true;
		notifyAll();
		// Sleep while waiting for the student to honor the bill
		while (!billHonored) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		// reset billHonored flag
		setBillHonored(false);
	}

	/**
	 * Operation have all portions been served
	 *
	 * It is called by a waiter to know if all the portions have been served
	 * 
	 * @return true, if all the portions have been served -
     *         false, otherwise
	 */

	public synchronized boolean haveAllPortionsBeenServed() {
		return portionsDelivered == SimulPar.N;
	}

	/**
	 * Operation get the pad
	 *
	 * It is called by a waiter to get the pad
	 * 
	 */

	public synchronized void getThePad() {
		// set state of waiter
		((TableClientProxy) Thread.currentThread()).setWaiterState(WaiterStates.TKODR);
		reposStub.setWaiterState(((TableClientProxy) Thread.currentThread()).getWaiterID(), WaiterStates.TKODR);
		// setting gotThePad flag and wake up the student
		setGotThePad(true);
		notifyAll();
		// Sleep while waiting for the student to describe the order
		while (!orderDescribed) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		// reset orderDescribed flag
		setOrderDescribed(false);
	}

	/**
	 * Operation set portion delivered
	 *
	 * This function sets the value of portionDelivered flag
	 *
	 * @param b portionDelivered flag
	 */

	private synchronized void setPortionDelivered(boolean b) {
		portionDelivered = b;
	}

	/**
	 * Operation set all finished eating
	 *
	 * This function sets the value of allFinishedEating flag
	 *
	 * @param b allFinishedEating flag
	 */
	private synchronized void setAllFinishedEating(boolean b) {
		allFinishedEating = b;
	}

	/**
	 * Operation set got the pad
	 *
	 * This function sets the value of gotThePad flag
	 *
	 * @param b gotThePad flag
	 */
	private synchronized void setGotThePad(boolean b) {
		gotThePad = b;
	}

	/**
	 * Operation set order described
	 *
	 * This function sets the value of orderDescribed flag
	 *
	 * @param described orderDescribed flag
	 */
	public synchronized void setOrderDescribed(boolean described) {
		orderDescribed = described;
	}

	/**
	 * Operation set bill honored
	 *
	 * This function sets the value of billHonored flag
	 *
	 * @param honored billHonored flag
	 */
	public synchronized void setBillHonored(boolean honored) {
		billHonored = honored;
	}

	/**
	 * Operation set client saluted
	 *
	 * This function sets the value of clientSaluted flag
	 *
	 * @param saluted clientSaluted flag
	 */

	public synchronized void setClientSaluted(boolean saluted) {
		clientSaluted = saluted;
	}

	/**
	 * Operation set informed
	 *
	 * This function sets the value of informed flag
	 *
	 * @param b informed flag
	 */
	public synchronized void setInformed(boolean b) {
		informed = b;
	}

	/**
	 * Operation take a seat
	 *
	 * It is called by a student when it wants to take a seat at the table
	 * 
	 */
	public synchronized void takeASeat() {
		int studentID;
		// set state of student
		studentID = ((TableClientProxy) Thread.currentThread()).getStudentID();
		student[studentID] = ((TableClientProxy) Thread.currentThread());
		((TableClientProxy) Thread.currentThread()).setStudentState(StudentStates.TKSTT);
		reposStub.setStudentState(studentID, StudentStates.TKSTT);
		// adding student to the sit order FIFO
		try {
			seatOrder.write(studentID);
		} catch (MemException e1) {
			e1.printStackTrace();
		}
		// if first = -1 the current student is the first to enter the restaurant
		if (first == -1) {
			first = studentID;
		}
		// setting the table seat of the student
		((TableClientProxy) Thread.currentThread()).setSeat(nStudents);
		reposStub.setStudentSeat(studentID, nStudents);
		nStudents++;
		// Sleep while waiting for the waiter to salute the student
		while (!clientSaluted) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		// reset clientSaluted flag
		setClientSaluted(false);
	}

	/**
	 * Operation selecting the course
	 *
	 * It is called by a student to know if all the portions have been served
	 * 
	 */
	public synchronized void selectingCourse() {
		int studentID;
		// set state of student
		studentID = ((TableClientProxy) Thread.currentThread()).getStudentID();
		((TableClientProxy) Thread.currentThread()).setStudentState(StudentStates.SELCS);
		reposStub.setStudentState(studentID, StudentStates.SELCS);
		// set menuRead flag and waking up the waiter
		menuRead = true;
		notifyAll();
	}

	/**
	 * Operation first to enter
	 *
	 * It is called by a student to know if it was the first to enter in the
	 * restaurant
	 * 
	 * @return true, if was the first to enter in the restaurant -
     *         false, otherwise
	 */
	public synchronized boolean firstToEnter() {
		int studentID = ((TableClientProxy) Thread.currentThread()).getStudentID();
		return studentID == first;
	}

	/**
	 * Operation inform companions
	 *
	 * It is called by a student to inform the companion about its order
	 */
	public synchronized void informCompanions() {
		nOrders++;
		// set informed flag
		setInformed(true);
		// waking up the student that takes the order
		notifyAll();
	}

	/**
	 * Operation organize order
	 *
	 * It is called by a student to start organizing the order
	 * 
	 */

	public synchronized void organizeOrder() {
		int studentID;
		// set state of student
		studentID = ((TableClientProxy) Thread.currentThread()).getStudentID();
		((TableClientProxy) Thread.currentThread()).setStudentState(StudentStates.OGODR);
		reposStub.setStudentState(studentID, StudentStates.OGODR);
		// for each student wait minus himself
		while (nOrders < SimulPar.S - 1) {
			// Sleep while waiting for a student to inform him of its request
			while (!informed) {
				try {
					wait();
				} catch (Exception e) {
				}
			}
			// reset informed flag
			setInformed(false);
		}
	}

	/**
	 * Operation describe order
	 *
	 * It is called by a student to describe the order to the waiter
	 * 
	 */

	public synchronized void describeOrder() {
		// Sleep while waiting for the waiter to get the pad
		while (!gotThePad) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		// reset gotThePad flag, set orderDescribed flag and waking up the waiter
		setGotThePad(false);
		setOrderDescribed(true);
		notifyAll();
	}

	/**
	 * Operation chatAgain
	 *
	 * It is called by the last student to eat to wake up the other students
	 * 
	 */

	public synchronized void chatAgain() {
		notifyAll();
	}

	/**
	 * Operation chat
	 *
	 * It is called by a student to start chatting with the companions
	 * 
	 */

	public synchronized void chat() {
		int studentID;
		// set state of student
		studentID = ((TableClientProxy) Thread.currentThread()).getStudentID();
		((TableClientProxy) Thread.currentThread()).setStudentState(StudentStates.CHTWC);
		reposStub.setStudentState(studentID, StudentStates.CHTWC);
		nChatting++;
		if (lastToEatID == studentID) {
			lastToEatID = -1;
		}
		while (nChatting < SimulPar.S) {
			try {
				wait();
			} catch (Exception e) {
			}
		} 
		chatLeft--;
		if (chatLeft == 0) {
			allFinishedEating = false;
			chatLeft = nChatting;
			nChatting = 0;
		}
		
		while (!portionDelivered && !noMoreCourses) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		if (portionDelivered) {
			// set portion accepted flag
			portionAccepted = true;
			setPortionDelivered(false);
			notifyAll();
		}
	}

	/**
	 * Operation enjoy the meal
	 *
	 * It is called by a student to start eating the portion
	 * 
	 */

	public synchronized void enjoyMeal() {
		notifyAll();
		int studentID;
		// set state of student
		studentID = ((TableClientProxy) Thread.currentThread()).getStudentID();
		((TableClientProxy) Thread.currentThread()).setStudentState(StudentStates.EJYML);
		reposStub.setStudentState(studentID, StudentStates.EJYML);
		try {
			Thread.sleep((long) (1 + 40 * Math.random()));
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Operation last to eat
	 *
	 * It is called by a student to know if it was the last to eat the portion
	 * 
	 * @return true, if was the last to eat the portion -
     *         false, otherwise
	 */

	public synchronized boolean lastToEat() {
		int studentID;
		// set state of student
		studentID = ((TableClientProxy) Thread.currentThread()).getStudentID();
		// increase number of portions eaten
		eat++;
		if (eat == SimulPar.S) {
			lastToEatID = studentID;
			coursesDelivered++;
			reposStub.setCoursesDelivered(coursesDelivered);
			if (coursesDelivered == SimulPar.M) {
				allFinishedEating = true;
				noMoreCourses = true;
				notifyAll();
				return true;
			}
			eat = 0;
			portionsDelivered = 0;
			reposStub.setPortionsDelivered(portionsDelivered);
			allFinishedEating = true;
			notifyAll();
			return true;
		}
		return false;
	}

	/**
	 * Operation last to enter restaurant
	 *
	 * It is called by a student to know if it was the last to enter in the
	 * restaurant
	 * 
	 * @return true, if was the last to enter in the restaurant-
     *         false, otherwise
	 */

	public synchronized boolean lastToEnterRestaurant() {
		// set state of student
		int studentID = ((TableClientProxy) Thread.currentThread()).getStudentID();
		return studentID == seatOrder.getLast();
	}

	/**
	 * Operation honor the bill
	 *
	 * It is called by a student to honor the bill
	 * 
	 */

	public synchronized void honorTheBill() {
		int studentID;
		// set state of student
		studentID = ((TableClientProxy) Thread.currentThread()).getStudentID();
		((TableClientProxy) Thread.currentThread()).setStudentState(StudentStates.PYTBL);
		reposStub.setStudentState(studentID, StudentStates.PYTBL);
		// sleep while waiting for the waiter to present the bill
		while (!billPresented) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		// reset billPresented flag
		billPresented = false;
		// set billHonored flag and wake up waiter
		setBillHonored(true);
		notifyAll();
	}

	/**
	 * Operation go home
	 *
	 * It is called by a student to leave the restaurant and go home
	 * 
	 */
	public synchronized void goHome() {
		int studentID;
		// set state of student
		studentID = ((TableClientProxy) Thread.currentThread()).getStudentID();
		((TableClientProxy) Thread.currentThread()).setStudentState(StudentStates.GGHOM);
		reposStub.setStudentState(studentID, StudentStates.GGHOM);
	}

	/**
	 * Operation wait for everyone to finish
	 *
	 * It is called by a student to wait of everyone to finish eating the current
	 * course
	 * 
	 */
	public synchronized void waitForEveryoneToFinish() {
		int studentID;
		// set state of student
		studentID = ((TableClientProxy) Thread.currentThread()).getStudentID();
		((TableClientProxy) Thread.currentThread()).setStudentState(StudentStates.CHTWC);
		reposStub.setStudentState(studentID, StudentStates.CHTWC);
		while (!allFinishedEating) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * Operation end of work.
	 *
	 * New operation.
	 *
	 * @param studentId student id
	 */
	public synchronized void endOperation(int studentId) {
		while (nEntities == 0) { /* the waiter waits for the termination of the students */
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		if (student[studentId] != null)
			student[studentId].interrupt();
	}

	/**
	 * Operation server shutdown.
	 *
	 * New operation.
	 */

	public synchronized void shutdown() {
		nEntities += 1;
		if (nEntities >= SimulPar.ET)
			ServerTable.waitConnection = false;
		notifyAll(); // the student may now terminate
	}
}