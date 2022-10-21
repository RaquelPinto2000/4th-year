package interfaces;

import java.rmi.*;
/**
 *   Operational interface of a remote object of type Table.
 *
 *     It provides the functionality to access the Table.
 */

public interface TableInterface extends Remote{

	public int takeASeat(int studentID) throws RemoteException; //student
	public void selectingCourse() throws RemoteException; //student
	public void organizeOrder() throws RemoteException; //student
	public void informCompanions() throws RemoteException; //student
	public void describeOrder() throws RemoteException; //student
	public void chat() throws RemoteException; //student
	public void enjoyMeal() throws RemoteException; //student
	public void waitForEveryoneToFinish() throws RemoteException; //student
	public void honorTheBill() throws RemoteException; //student
	public boolean lastToEat() throws RemoteException; //student
	public boolean firstToEnter() throws RemoteException; //student
	public boolean lastToEnterRestaurant() throws RemoteException; //student
	
	public int saluteTheClient(int waiterID)throws RemoteException; //table
	public int getThePad(int waiterID) throws RemoteException; //table
	public void deliverPortion() throws RemoteException; //table  
	public int presentBill(int waiterID) throws RemoteException; //table
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
