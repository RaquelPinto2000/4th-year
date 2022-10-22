package clientSide.entities;

/**
 * Waiter cloning.
 *
 * It specifies his own attributes. Implementation of a client-server model of
 * type 2 (server replication). Communication is based on a communication
 * channel under the TCP protocol.
 */
public interface WaiterCloning {
	/**
	 * Get waiter id
	 * 
	 * @return waiterID waiter identifier
	 */
	public int getWaiterID();

	/**
	 * Set waiter id
	 * 
	 * @param waiterID waiter identifier
	 */

	public void setWaiterID(int waiterID);

	/**
	 * Get waiter state
	 * 
	 * @return waiterState waiter state
	 */

	public int getWaiterState();

	/**
	 * Set waiter state
	 * 
	 * @param waiterState waiter state
	 */

	public void setWaiterState(int waiterState);
}
