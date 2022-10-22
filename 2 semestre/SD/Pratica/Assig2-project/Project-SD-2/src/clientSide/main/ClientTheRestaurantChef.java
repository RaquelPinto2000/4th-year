package clientSide.main;

import clientSide.entities.Chef;
import clientSide.stubs.BarStub;
import clientSide.stubs.GeneralReposStub;
import clientSide.stubs.KitchenStub;
import genclass.GenericIO;
import serverSide.main.SimulPar;

/**
 * Client side of the Restaurant (chef).
 *
 * Implementation of a client-server model of type 2 (server replication).
 * Communication is based on a communication channel under the TCP protocol.
 */

public class ClientTheRestaurantChef {
	/**
	 * Main method.
	 *
	 * @param args runtime arguments 
	 *		args[0] - name of the platform where is located the kitchen server 
	 *      args[1] - name of the platform where is located the bar server 
	 *      args[2] - port number for listening to service requests 
	 *      args[3] - port number for listening to service requests 
	 *      args[4] - name of the platform where is located the general repository server 
	 *      args[5] - port number for listening to service requests
	 */
	public static void main(String[] args) {

		String kitchenServerHostName; // name of the platform where is located the kitchen server
		int kitchenServerPortNumb = -1; // port number for listening to service requests
		String barServerHostName; // name of the platform where is located the bar server
		int barServerPortNumb = -1; // port number for listening to service requests
		String genReposServerHostName; // name of the platform where is located the general repository server
		int genReposServerPortNumb = -1; // port number for listening to service requests
		Chef[] chef = new Chef[1]; // array of chef threads
		KitchenStub kitchenStub; // remote reference to the kitchen
		BarStub barStub; // remote reference to the bar
		GeneralReposStub genReposStub; // remote reference to the general repository

		/* getting problem runtime parameters */

		if (args.length != 6) {
			GenericIO.writelnString("Wrong number of parameters!");
			System.exit(1);
		}
		kitchenServerHostName = args[0];
		barServerHostName = args[1];
		try {
			kitchenServerPortNumb = Integer.parseInt(args[2]);
		} catch (NumberFormatException e) {
			GenericIO.writelnString("args[2] is not a number!");
			System.exit(1);
		}
		if ((kitchenServerPortNumb < 4000) || (kitchenServerPortNumb >= 65536)) {
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

		kitchenStub = new KitchenStub(kitchenServerHostName, kitchenServerPortNumb);
		barStub = new BarStub(barServerHostName, barServerPortNumb);
		genReposStub = new GeneralReposStub(genReposServerHostName, genReposServerPortNumb);
		for (int i = 0; i < SimulPar.C; i++)
			chef[i] = new Chef("chef_" + (i + 1), i, 0, barStub, kitchenStub);

		/* start of the simulation */

		for (int i = 0; i < SimulPar.C; i++)
			chef[i].start();

		/* waiting for the end of the simulation */

		GenericIO.writelnString();
		for (int i = 0; i < SimulPar.C; i++) {
			/*
			while (chef[i].isAlive()) {
				GenericIO.writelnString("Chef is alive");
				kitchenStub.endOperation(i);
				Thread.yield();
			}
			GenericIO.writelnString("Chef put of while");*/
			try {
				chef[i].join();
			} catch (InterruptedException e) {
			}
			GenericIO.writelnString("The chef " + (i + 1) + " has terminated.");
		}
		GenericIO.writelnString();
		kitchenStub.shutdown();
		barStub.shutdown();
		genReposStub.shutdown();
	}

}
