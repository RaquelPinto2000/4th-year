package interfaces;

import java.rmi.*;

/**
 *   Operational interface of a remote object of type GeneralRepos.
 *
 *     It provides the functionality to access the General Repository of Information.
 */

public interface GeneralReposInterface extends Remote{

	
	 /**
	   *   Operation initialization of simulation.
	   *
	   *   New operation.
	   *
	   *     @param logFileName name of the logging file
	   *     @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	   *                             service fails
	   */

	   public void initSimul (String logFileName) throws RemoteException;

	  /**
	   *   Operation server shutdown.
	   *
	   *   New operation.
	   *
	   *     @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	   *                             service fails
	   */

	   public void shutdown () throws RemoteException;
	   
	   /**
		 * Set waiter state
		 * 
		 * @param waiterID waiter identifier
		 * @param waiterState waiter state
		 * 
		 */
	   public void setWaiterState(int waiterID, int waiterState) throws RemoteException;
	   
	   /**
 		 * Set student state
 		 * 
 		 * @param studentID student identifier
 		 * @param studentState student state
 		 * 
 		 */
	   public void setStudentState(int studentID, int studentState) throws RemoteException;
	   
	   /**
		 * Set chef state
		 * 
		 * @param chefID chef identifier
		 * @param chefState chef state
		 * 
		 */
	   public void setChefState (int chefID, int chefState) throws RemoteException;
	   
	   /**
		 * Set portions delivered
		 * 
		 * @param portionsDelivered portions Delivered
		 * 
		 */
	   public void setPortionsDelivered (int portionsDelivered) throws RemoteException;
	   /**
		 * Set student seat
		 * 
		 * @param studentID student identifier
		 * @param nStudents number of students
		 * 
		 */
	   public void setStudentSeat(int studentID, int nStudents) throws RemoteException;
	   
	   /**
		 * Set courses delivered
		 * 
		 * @param coursesDelivered courses Delivered
		 * 
		 */
	   public void setCoursesDelivered (int coursesDelivered) throws RemoteException;
	
	
}
