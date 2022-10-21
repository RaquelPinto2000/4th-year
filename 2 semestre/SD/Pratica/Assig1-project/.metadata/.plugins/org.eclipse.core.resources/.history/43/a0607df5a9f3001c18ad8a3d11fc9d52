package interfaces;

import java.rmi.*;
/**
 *   Operational interface of a remote object of type kitchen.
 *
 *     It provides the functionality to access the kitchen.
 */

public interface KitchenInterface extends Remote{

	public int watchTheNews(int chefId) throws RemoteException; //chef
	public int startPreparations(int chefId) throws RemoteException; //chef
	public int continuePreparation(int chefId) throws RemoteException; //chef
	public int proceedToPresentation(int chefId) throws RemoteException; //chef
	public int deliverPortion(int chefId) throws RemoteException; //chef
	public int haveNextPortionReady(int chefId) throws RemoteException; //chef
	public void alertWaiter() throws RemoteException; //chef
	public int cleanUp(int chefId) throws RemoteException; //chef
	public boolean orderBeenCompleted() throws RemoteException; //chef
	public boolean allPortionsDelived() throws RemoteException; //chef
	
	public int handTheNoteToTheChef(int waiterID) throws RemoteException; //Waiter
	public int collectPortion(int waiterID) throws RemoteException; //Waiter
	
	  /**
	   *  Operation end of work.
	   *
	   *   New operation.
	   *
	   *      @param chefId chef id
	   *      @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	   *                              service fails
	   */

	   public void endOperation (int chefId) throws RemoteException;

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
