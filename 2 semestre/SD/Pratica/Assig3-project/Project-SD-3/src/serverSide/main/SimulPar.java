package serverSide.main;

/**
 *  Definition of the simulation parameters.
 */
public class SimulPar {

	/**
	 * Number of Waiter in the restaurant
	 */

	public static final int W = 1;

	/**
	 * Number of Chefs in the restaurant
	 */

	public static final int C = 1;

	/**
	 * Number of Students
	 */

	public static final int S = 7;

	/**
	 * Number of courses
	 */

	public static final int M = 3;

	/**
	 * Number of portions
	 */

	public static final int N = S;

	/**
	 * Number of entities requesting Table shutdown.
	 */

	public static final int ET = 2;
	
	/**
	 * Number of entities requesting Kitchen shutdown.
	 */

	public static final int EK = 2;
	
	/**
	 * Number of entities requesting Bar shutdown.
	 */

	public static final int EB = 3;
	
	/**
	 * Number of entities requesting general repos shutdown.
	 */

	public static final int EG = 3;

	/**
	 * It can't be instantiated
	 */

	private SimulPar() {
	}

}
