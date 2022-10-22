package clientSide.entities;

/**
 * Chef cloning.
 *
 * It specifies his own attributes. Implementation of a client-server model of
 * type 2 (server replication). Communication is based on a communication
 * channel under the TCP protocol.
 */

public interface ChefCloning {

	/**
	 * Get Chef ID
	 * 
	 * @return chefID chef identifier
	 */
	public int getChefID();

	/**
	 * Set Chef ID
	 * 
	 * @param chefID chef identifier
	 */
	public void setChefID(int chefID);

	/**
	 * Get Chef state
	 * 
	 * @return chefState chef state
	 */
	public int getChefState();

	/**
	 * Set Chef state
	 * 
	 * @param chefState chef state
	 */
	public void setChefState(int chefState);
}
