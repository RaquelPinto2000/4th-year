package clientSide.entities;
/**
 * Student cloning.
 *
 * It specifies his own attributes. Implementation of a client-server model of
 * type 2 (server replication). Communication is based on a communication
 * channel under the TCP protocol.
 */
public interface StudentCloning {

	/**
	 * Get Student ID
	 * 
	 * @return studentID student identifier
	 */
	public int getStudentID();

	/**
	 * Set Student ID
	 * 
	 * @param studentID student identifier
	 */
	public void setStudentID(int studentID);

	/**
	 * Get number of the seat at the table
	 * 
	 * @return seat number of the seat at the table
	 */
	public int getSeat();

	/**
	 * Set number of the seat at the table
	 * 
	 * @param seat number of the seat at the table
	 */
	public void setSeat(int seat);

	/**
	 * Get Student state
	 * 
	 * @return studentState student state
	 */
	public int getStudentState();

	/**
	 * Set Student state
	 * 
	 * @param studentState student state
	 */
	public void setStudentState(int studentState);

}
