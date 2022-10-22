package interfaces;

import java.rmi.*;
/**
 *   Operational interface of a remote object of type Table.
 *
 *     It provides the functionality to access the Table.
 */

public interface TableInterface extends Remote{

	/**
	 * Operation take a seat
	 *
	 * It is called by a student when it wants to take a seat at the table
	 * @param studentID student identifier
	 * @return ReturnInt
	 * @throws RemoteException 
	 * 
	 */
	public ReturnInt takeASeat(int studentID) throws RemoteException; //student
	/**
	 * Operation selecting the course
	 *
	 * It is called by a student to know if all the portions have been served
	 * @param studentID student identifier
	 * @return StudentStates.SELCS
	 * @throws RemoteException 
	 * 
	 */
	public int selectingCourse(int studentID) throws RemoteException; //student
	/**
	 * Operation organize order
	 *
	 * It is called by a student to start organizing the order
	 * @param studentID student identifier
	 * @return StudentStates.OGODR
	 * @throws RemoteException 
	 * 
	 */
	public int organizeOrder(int studentID) throws RemoteException; //student
	/**
	 * Operation inform companions
	 *
	 * It is called by a student to inform the companion about its order
	 */
	public void informCompanions() throws RemoteException; //student
	/**
	 * Operation describe order
	 *
	 * It is called by a student to describe the order to the waiter
	 * 
	 */
	public void describeOrder() throws RemoteException; //student
	/**
	 * Operation chat
	 *
	 * It is called by a student to start chatting with the companions
	 * @param studentID student identifier
	 * @return StudentStates.CHTWC
	 * @throws RemoteException 
	 * 
	 */
	public int chat(int studentID) throws RemoteException; //student
	/**
	 * Operation enjoy the meal
	 *
	 * It is called by a student to start eating the portion
	 * @param studentID student identifier
	 * @return StudentStates.EJYML
	 * @throws RemoteException 
	 * 
	 */
	public int enjoyMeal(int studentID) throws RemoteException; //student
	/**
	 * Operation wait for everyone to finish
	 *
	 * It is called by a student to wait of everyone to finish eating the current
	 * course
	 * @param studentID student identifier
	 * @return StudentStates.CHTWC
	 * @throws RemoteException 
	 * 
	 */
	public int waitForEveryoneToFinish(int studentID) throws RemoteException; //student
	/**
	 * Operation honor the bill
	 *
	 * It is called by a student to honor the bill
	 * @param studentID student identifier
	 * @return StudentStates.PYTBL
	 * @throws RemoteException 
	 * 
	 */
	public int honorTheBill(int studentID) throws RemoteException; //student
	/**
	 * Operation last to eat
	 *
	 * It is called by a student to know if it was the last to eat the portion
	 * @param studentID student identifier
	 * @return true, if was the last to eat the portion -
     *         false, otherwise
	 * @throws RemoteException 
	 */
	public boolean lastToEat(int studentID) throws RemoteException; //student
	/**
	 * Operation first to enter
	 *
	 * It is called by a student to know if it was the first to enter in the
	 * restaurant
	 * 
	 * @return true, if was the first to enter in the restaurant -
     *         false, otherwise
	 */
	public boolean firstToEnter(int studentID) throws RemoteException; //student
	/**
	 * Operation last to enter restaurant
	 *
	 * It is called by a student to know if it was the last to enter in the
	 * restaurant
	 * @param studentID student identifier
	 * @return true, if was the last to enter in the restaurant-
     *         false, otherwise
	 */
	public boolean lastToEnterRestaurant(int studentID) throws RemoteException; //student
		
	/**
	 * Operation salute the client.
	 *
	 * It is called by a waiter to salute the client
	 * @param waiterID waiter identifier
	 * @return WaiterStates.PRSMN
	 * @throws RemoteException 
	 * 
	 */
	public int saluteTheClient(int waiterID)throws RemoteException; //table
	/**
	 * Operation get the pad
	 *
	 * It is called by a waiter to get the pad
	 * @param waiterID waiter identifier
	 * @return WaiterStates.TKODR
	 * @throws RemoteException 
	 * 
	 */

	public int getThePad(int waiterID) throws RemoteException; //table
	/**
	 * Operation deliver portion.
	 *
	 * It is called by a waiter to deliver a portion to a student
	 * @throws RemoteException 
	 * 
	 */
	public void deliverPortion() throws RemoteException; //table  
	/**
	 * Operation present the bill.
	 *
	 * It is called by a waiter to present the bill to the student
	 * @param waiterID waiter identifier
	 * @return WaiterStates.RECPM
	 * @throws RemoteException 
	 * 
	 */
	public int presentBill(int waiterID) throws RemoteException; //table
	/**
	 * Operation have all portions been served
	 *
	 * It is called by a waiter to know if all the portions have been served
	 * 
	 * @return true, if all the portions have been served -
     *         false, otherwise
	 */

	public boolean haveAllPortionsBeenServed() throws RemoteException; //table
	
  /**
   *  Operation end of work.
   *
   *   New operation.
   *
   *      @param studentId student id
   *      @throws RemoteException if either the invocation of the remote method, or the communication with the registry
   *                              service fails
   */

   public void endOperation (int studentId) throws RemoteException;

  /**
   *   Operation server shutdown.
   *
   *   New operation.
   *
   *     @throws RemoteException if either the invocation of the remote method, or the communication with the registry
   *                             service fails
   */

   public void shutdown () throws RemoteException;
	
}
