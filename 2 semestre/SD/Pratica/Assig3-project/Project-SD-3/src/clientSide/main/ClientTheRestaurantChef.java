package clientSide.main;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import clientSide.entities.Chef;
import genclass.GenericIO;
import interfaces.BarInterface;
import interfaces.GeneralReposInterface;
import interfaces.KitchenInterface;
import serverSide.main.SimulPar;

/**
 * Client side of the Restaurant (chef).
 *
 *  Implementation of a client-server model of type 2 (server replication).
 *  Communication is based on Java RMI.
 */

public class ClientTheRestaurantChef {
	/**
	 * Main method.
	 *
	 * @param args runtime arguments 
	 * 			  args[0] - name of the platform where is located the RMI registering service
     *        	  args[1] - port number where the registering service is listening to service requests
     *        	  args[2] - name of the logging file
     */
	public static void main(String[] args) {
		String rmiRegHostName;                                         // name of the platform where is located the RMI registering service
		int rmiRegPortNumb = -1;                                       // port number where the registering service is listening to service requests
		String fileName;                                               // name of the logging file
		  
	    
		/* getting problem runtime parameters */

	      if (args.length != 3)
	         { GenericIO.writelnString ("Wrong number of parameters!");
	           System.exit (1);
	         }
	      rmiRegHostName = args[0];
	      try
	      { rmiRegPortNumb = Integer.parseInt (args[1]);
	      }
	      catch (NumberFormatException e)
	      { GenericIO.writelnString ("args[1] is not a number!");
	        System.exit (1);
	      }
	      if ((rmiRegPortNumb < 4000) || (rmiRegPortNumb >= 65536))
	         { GenericIO.writelnString ("args[1] is not a valid port number!");
	           System.exit (1);
	         }
	      fileName = args[2];
		
	      /* problem initialization */  
	      String nameEntryGeneralRepos = "GeneralRepository";            // public name of the general repository object
	      GeneralReposInterface genReposStub = null;                     // remote reference to the general repository object
	      String nameEntryBar = "Bar";                    				 // public name of the bar object
	      String nameEntryKitchen = "Kitchen";                    		 // public name of the kitchen object
	      KitchenInterface kitchenStub = null; 							 // remote reference to the bar
	      BarInterface barStub = null;                          		 // remote reference to the bar object
	      Registry registry = null;                                      // remote reference for registration in the RMI registry service
	      Chef[] chef = new Chef[SimulPar.C]; 							 // array of chef threads
			
		
		/* problem initialization */
	      try
	      { registry = LocateRegistry.getRegistry (rmiRegHostName, rmiRegPortNumb);
	      }
	      catch (RemoteException e)
	      { GenericIO.writelnString ("RMI registry creation exception: " + e.getMessage ());
	        e.printStackTrace ();
	        System.exit (1);
	      }

		 
		 try
	      { genReposStub = (GeneralReposInterface) registry.lookup (nameEntryGeneralRepos);
	      }
	      catch (RemoteException e)
	      { GenericIO.writelnString ("GeneralRepos lookup exception: " + e.getMessage ());
	        e.printStackTrace ();
	        System.exit (1);
	      }
	      catch (NotBoundException e)
	      { GenericIO.writelnString ("GeneralRepos not bound exception: " + e.getMessage ());
	        e.printStackTrace ();
	        System.exit (1);
	      }
		
		 try
	      { barStub = (BarInterface) registry.lookup (nameEntryBar);
	      }
	      catch (RemoteException e)
	      { GenericIO.writelnString ("Bar lookup exception: " + e.getMessage ());
	        e.printStackTrace ();
	        System.exit (1);
	      }
	      catch (NotBoundException e)
	      { GenericIO.writelnString ("Bar not bound exception: " + e.getMessage ());
	        e.printStackTrace ();
	        System.exit (1);
	      }

		 try
	      { kitchenStub = (KitchenInterface) registry.lookup (nameEntryKitchen);
	      }
	      catch (RemoteException e)
	      { GenericIO.writelnString ("Kitchen lookup exception: " + e.getMessage ());
	        e.printStackTrace ();
	        System.exit (1);
	      }
	      catch (NotBoundException e)
	      { GenericIO.writelnString ("Kitchen not bound exception: " + e.getMessage ());
	        e.printStackTrace ();
	        System.exit (1);
	      }
		 
		 try
	     { genReposStub.initSimul (fileName);
	     }
	     catch (RemoteException e)
	     { GenericIO.writelnString ("GeneralRepos generator remote exception on initSimul: " + e.getMessage ());
	       System.exit (1);
	     }
		
		
		
		
		for (int i = 0; i < SimulPar.C; i++)
			chef[i] = new Chef("chef_" + (i + 1), i, 0, barStub, kitchenStub);

		/* start of the simulation */
		for (int i = 0; i < SimulPar.C; i++)
			chef[i].start();

		/* waiting for the end of the simulation */
		GenericIO.writelnString();
		for (int i = 0; i < SimulPar.C; i++) {
			try {
				chef[i].join();
			} catch (InterruptedException e) {
			}
			GenericIO.writelnString("The chef " + (i + 1) + " has terminated.");
		}
		GenericIO.writelnString();
		
		try {
			barStub.shutdown();
		}catch (RemoteException e){ 
			GenericIO.writelnString ("Chef generator remote exception on Bar shutdown: " + e.getMessage ());
		    System.exit (1);
		}
		try {
			kitchenStub.shutdown();
		}catch (RemoteException e){ 
			GenericIO.writelnString ("Chef generator remote exception on Kitchen shutdown: " + e.getMessage ());
		    System.exit (1);
		}
		try {
			genReposStub.shutdown();
		}catch (RemoteException e){ 
			GenericIO.writelnString ("Chef generator remote exception on GeneralRepos shutdown: " + e.getMessage ());
		    System.exit (1);
		}
	}

}
