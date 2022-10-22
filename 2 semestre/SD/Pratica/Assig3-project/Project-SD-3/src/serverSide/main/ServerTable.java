package serverSide.main;

import java.rmi.registry.*;
import java.rmi.*;
import java.rmi.server.*;
import serverSide.objects.*;
import interfaces.*;
import genclass.GenericIO;

/**
 *    Instantiation and registering of a table object.
 *
 *    Implementation of a client-server model of type 2 (server replication).
 *    Communication is based on Java RMI.
 */

public class ServerTable {
  /**
   *  Flag signaling the end of operations.
   */

   private static boolean end = false;

  /**
   *  Main method.
   *
   *        args[0] - port number for listening to service requests
   *        args[1] - name of the platform where is located the RMI registering service
   *        args[2] - port number where the registering service is listening to service requests
   */

   public static void main (String[] args)
   {
      int portNumb = -1;                                             // port number for listening to service requests
      String rmiRegHostName;                                         // name of the platform where is located the RMI registering service
      int rmiRegPortNumb = -1;                                       // port number where the registering service is listening to service requests

      if (args.length != 3)
         { GenericIO.writelnString ("Wrong number of parameters!");
           System.exit (1);
         }
      try
      { portNumb = Integer.parseInt (args[0]);
      }
      catch (NumberFormatException e)
      { GenericIO.writelnString ("args[0] is not a number!");
        System.exit (1);
      }
      if ((portNumb < 4000) || (portNumb >= 65536))
         { GenericIO.writelnString ("args[0] is not a valid port number!");
           System.exit (1);
         }
      rmiRegHostName = args[1];
      try
      { rmiRegPortNumb = Integer.parseInt (args[2]);
      }
      catch (NumberFormatException e)
      { GenericIO.writelnString ("args[2] is not a number!");
        System.exit (1);
      }
      if ((rmiRegPortNumb < 4000) || (rmiRegPortNumb >= 65536))
         { GenericIO.writelnString ("args[2] is not a valid port number!");
           System.exit (1);
         }

     /* create and install the security manager */

      if (System.getSecurityManager () == null)
         System.setSecurityManager (new SecurityManager ());
      GenericIO.writelnString ("Security manager was installed!");

     /* get a remote reference to the general repository object */

      String nameEntryGeneralRepos = "GeneralRepository";            // public name of the general repository object
      GeneralReposInterface reposStub = null;                        // remote reference to the general repository object
      Registry registry = null;                                      // remote reference for registration in the RMI registry service

      try
      { registry = LocateRegistry.getRegistry (rmiRegHostName, rmiRegPortNumb);
      }
      catch (RemoteException e)
      { GenericIO.writelnString ("RMI registry creation exception: " + e.getMessage ());
        e.printStackTrace ();
        System.exit (1);
      }
      GenericIO.writelnString ("RMI registry was created!");

      try
      { reposStub = (GeneralReposInterface) registry.lookup (nameEntryGeneralRepos);
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

     /* instantiate a table object */

      Table table = new Table (reposStub);                 		  // table object
      TableInterface TableStub = null;                          // remote reference to the table object

      try
      { TableStub = (TableInterface) UnicastRemoteObject.exportObject (table, portNumb);
      }
      catch (RemoteException e)
      { GenericIO.writelnString ("Table stub generation exception: " + e.getMessage ());
        e.printStackTrace ();
        System.exit (1);
      }
      GenericIO.writelnString ("Stub was generated!");

     /* register it with the general registry service */

      String nameEntryBase = "RegisterHandler";                      // public name of the object that enables the registration
                                                                     // of other remote objects
      String nameEntryObject = "Table";                     		     // public name of the table object
      Register reg = null;                                           // remote reference to the object that enables the registration
                                                                     // of other remote objects

      try
      { reg = (Register) registry.lookup (nameEntryBase);
      }
      catch (RemoteException e)
      { GenericIO.writelnString ("RegisterRemoteObject lookup exception: " + e.getMessage ());
        e.printStackTrace ();
        System.exit (1);
      }
      catch (NotBoundException e)
      { GenericIO.writelnString ("RegisterRemoteObject not bound exception: " + e.getMessage ());
        e.printStackTrace ();
        System.exit (1);
      }

      try
      { reg.bind (nameEntryObject, TableStub);
      }
      catch (RemoteException e)
      { GenericIO.writelnString ("Table registration exception: " + e.getMessage ());
        e.printStackTrace ();
        System.exit (1);
      }
      catch (AlreadyBoundException e)
      { GenericIO.writelnString ("Table already bound exception: " + e.getMessage ());
        e.printStackTrace ();
        System.exit (1);
      }
      GenericIO.writelnString ("Table object was registered!");

     /* wait for the end of operations */

      GenericIO.writelnString ("Table is in operation!");
      try
      { while (!end)
          synchronized (Class.forName ("serverSide.main.ServerTable"))
          { try
            { (Class.forName ("serverSide.main.ServerTable")).wait ();
            }
            catch (InterruptedException e)
            { GenericIO.writelnString ("Table main thread was interrupted!");
            }
          }
      }
      catch (ClassNotFoundException e)
      { GenericIO.writelnString ("The data type ServerTable was not found (blocking)!");
        e.printStackTrace ();
        System.exit (1);
      }

     /* server shutdown */

      boolean shutdownDone = false;                                  // flag signalling the shutdown of the table service

      try
      { reg.unbind (nameEntryObject);
      }
      catch (RemoteException e)
      { GenericIO.writelnString ("Table deregistration exception: " + e.getMessage ());
        e.printStackTrace ();
        System.exit (1);
      }
      catch (NotBoundException e)
      { GenericIO.writelnString ("Table not bound exception: " + e.getMessage ());
        e.printStackTrace ();
        System.exit (1);
      }
      GenericIO.writelnString ("Table was deregistered!");

      try
      { shutdownDone = UnicastRemoteObject.unexportObject (table, true);
      }
      catch (NoSuchObjectException e)
      { GenericIO.writelnString ("Table unexport exception: " + e.getMessage ());
        e.printStackTrace ();
        System.exit (1);
      }

      if (shutdownDone)
         GenericIO.writelnString ("Table was shutdown!");
   }

  /**
   *  Close of operations.
   */

   public static void shutdown ()
   {
      end = true;
      try
      { synchronized (Class.forName ("serverSide.main.ServerTable"))
        { (Class.forName ("serverSide.main.ServerTable")).notify ();
        }
      }
     catch (ClassNotFoundException e)
     { GenericIO.writelnString ("The data type ServerTable was not found (waking up)!");
       e.printStackTrace ();
       System.exit (1);
     }
   }
}
