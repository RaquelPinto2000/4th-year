package interfaces;

import java.rmi.*;
/**
 *   Operational interface of a remote object of type Bar.
 *
 *     It provides the functionality to access the Bar.
 */

public interface BarInterface extends Remote{

	public void alertWaiter() throws RemoteException; //chef
	public void enter() throws RemoteException; //student
	public void callTheWaiter() throws RemoteException;//student
	public void signalWaiter() throws RemoteException;//student
	public void shouldHaveArrivedEarlier() throws RemoteException;//student
	public int goHome(int studentID) throws RemoteException;//student
	
	public char lookAround(int waiterID) throws RemoteException; //waiter
	public int returnToTheBarAfterSalute(int waiterID) throws RemoteException;//waiter
	public int returnToTheBarAfterTakingTheOrder(int waiterID) throws RemoteException;//waiter
	public int returnToTheBarAfterPortionsDelivered(int waiterID) throws RemoteException;//waiter
	public int prepareBill(int waiterID) throws RemoteException;//waiter
	public void receivedPayment() throws RemoteException;//waiter
	public int returnToTheBar(int waiterID) throws RemoteException;//waiter
	public void sayGoodbye() throws RemoteException;//waiter
	
  /**
   *  Operation end of work.
   *
   *   New operation.
   *
   *      @param waiterId waiter id
   *      @throws RemoteException if either the invocation of the remote method, or the communication with the registry
   *                              service fails
   */

    public void endOperation (int waiterId) throws RemoteException;

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
