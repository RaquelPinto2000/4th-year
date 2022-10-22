package clientSide.main;

import clientSide.entities.Student;
import clientSide.stubs.BarStub;
import clientSide.stubs.GeneralReposStub;
import clientSide.stubs.TableStub;
import genclass.GenericIO;
import serverSide.main.SimulPar;

/**
 * Client side of the Restaurant (Student).
 *
 * Implementation of a client-server model of type 2 (server replication).
 * Communication is based on a communication channel under the TCP protocol.
 */
public class ClientTheRestaurantStudent {
	/**
	 * Main method.
	 *
	 * @param args runtime arguments 
	 *		args[0] - name of the platform where is located the table server 
	 *      args[1] - name of the platform where is located the bar server 
	 *      args[2] - port number for listening to service requests 
	 *      args[3] - port number for listening to service requests
	 *      args[4] - name of the platform where is located the general repository server 
	 *      args[5] - port number for listening to service requests
	 */
	public static void main(String[] args) {

		String tableServerHostName; // name of the platform where is located the table server
		int tableServerPortNumb = -1; // port number for listening to service requests
		String barServerHostName; // name of the platform where is located the bar server
		int barServerPortNumb = -1; // port number for listening to service requests
		String genReposServerHostName; // name of the platform where is located the general repository server
		int genReposServerPortNumb = -1; // port number for listening to service requests
		Student[] student = new Student[SimulPar.S]; // array of chef threads
		TableStub tableStub; // remote reference to the table
		BarStub barStub; // remote reference to the bar
		GeneralReposStub genReposStub; // remote reference to the general repository

		/* getting problem runtime parameters */

		if (args.length != 6) {
			GenericIO.writelnString("Wrong number of parameters!");
			System.exit(1);
		}
		tableServerHostName = args[0];
		barServerHostName = args[1];
		try {
			tableServerPortNumb = Integer.parseInt(args[2]);
		} catch (NumberFormatException e) {
			GenericIO.writelnString("args[2] is not a number!");
			System.exit(1);
		}
		if ((tableServerPortNumb < 4000) || (tableServerPortNumb >= 65536)) {
			GenericIO.writelnString("args[1] is not a valid port number!");
			System.exit(1);
		}
		try {
			barServerPortNumb = Integer.parseInt(args[3]);
		} catch (NumberFormatException e) {
			GenericIO.writelnString("args[3] is not a number!");
			System.exit(1);

		}
		if ((barServerPortNumb < 4000) || (barServerPortNumb >= 65536)) {
			GenericIO.writelnString("args[3] is not a valid port number!");
			System.exit(1);
		}
		genReposServerHostName = args[4];
		try {
			genReposServerPortNumb = Integer.parseInt(args[5]);
		} catch (NumberFormatException e) {
			GenericIO.writelnString("args[5] is not a number!");
			System.exit(1);
		}
		if ((genReposServerPortNumb < 4000) || (genReposServerPortNumb >= 65536)) {
			GenericIO.writelnString("args[5] is not a valid port number!");
			System.exit(1);
		}

		/* problem initialization */

		tableStub = new TableStub(tableServerHostName, tableServerPortNumb);
		barStub = new BarStub(barServerHostName, barServerPortNumb);
		genReposStub = new GeneralReposStub(genReposServerHostName, genReposServerPortNumb);
		for (int i = 0; i < SimulPar.S; i++)
			student[i] = new Student("student_" + (i + 1), i, barStub, tableStub);

		/* start of the simulation */

		for (int i = 0; i < SimulPar.S; i++)
			student[i].start();

		/* waiting for the end of the simulation */

		GenericIO.writelnString();
		for (int i = 0; i < SimulPar.S; i++) {/*
			while (student[i].isAlive()) {
				tableStub.endOperation(i);
				Thread.yield();
			}*/
			try {
				student[i].join();
			} catch (InterruptedException e) {
			}
			GenericIO.writelnString("The student " + (i + 1) + " has terminated.");
		}
		GenericIO.writelnString();
		tableStub.shutdown();
		barStub.shutdown();
		genReposStub.shutdown();
	}

}
