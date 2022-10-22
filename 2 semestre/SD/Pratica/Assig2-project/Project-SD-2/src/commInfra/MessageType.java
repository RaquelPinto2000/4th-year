package commInfra;


/**
 *   Type of the exchanged messages.
 *   Implementation of a client-server model of type 2 (server replication).
 *   Communication is based on a communication channel under the TCP protocol.
 */
public class MessageType {

	/**
	 * Initialization of the logging file name and the number of iterations (service
	 * request).
	 */

	public static final int SETNFIC = 1;

	/**
	 * Logging file was initialized (reply).
	 */

	public static final int NFICDONE = 2;

	/**
	 * Server shutdown (service request).
	 */

	public static final int SHUT = 3;
	/**
	 * Server was shutdown (reply).
	 */

	public static final int SHUTDONE = 4;
	/**
	 * Set chef state (service request).
	 */

	public static final int STCST = 5;

	/**
	 * Set waiter state (service request).
	 */

	public static final int STWST = 6;

	/**
	 * Set student state (service request).
	 */

	public static final int STSST = 7;

	/**
	 * Setting acknowledged (reply).
	 */

	public static final int SACK = 8;

	/**
	 * Payment was received (reply).
	 */

	public static final int RPAYDONE = 9;

	/**
	 * Call a chef (service request).
	 */

	public static final int CALLCHEF = 10;

	/**
	 * Request waiting for an order (service request).
	 */

	public static final int REQWAFOR = 11;

	/**
	 * Request waiting for an order (service request).
	 */

	public static final int WAFORDONE = 12;

	/**
	 * Request preparing a course (service request).
	 */
	public static final int REQPRPCS = 13;

	/**
	 * Preparing a course done (reply).
	 */
	public static final int PRPCSDONE = 14;

	/**
	 * Request continue preparation (service request).
	 */
	public static final int REQCONTPRE = 15;

	/**
	 * Continue preparation done (reply).
	 */
	public static final int CONTPREDONE = 16;

	/**
	 * Request proceed presentation (service request).
	 */
	public static final int REQPROPRE = 17;

	/**
	 * Continue proceed presentation done (reply).
	 */
	public static final int PROPREDONE = 18;

	/**
	 * Request deliver Portion (service request).
	 */
	public static final int REQDEPORT = 19;

	/**
	 * Deliver portion done (reply).
	 */
	public static final int DEPORTDONE = 20;

	/**
	 * Request have next portion ready (service request).
	 */
	public static final int REQHNPORTREADY = 21;

	/**
	 * Have next portion ready done (reply).
	 */
	public static final int HNPORTREADYDONE = 22;

	/**
	 * Request alert waiter (service request).
	 */
	public static final int REQALERTWAITER = 23;

	/**
	 * Alert waiter done (reply).
	 */
	public static final int ALERTWAITERDONE = 24;

	/**
	 * Request clean up (service request).
	 */
	public static final int REQCLEANUP = 25;

	/**
	 * Clean up done (reply).
	 */
	public static final int CLEANUPDONE = 26;

	/**
	 * End of work - chef (service request).
	 */

	public static final int ENDOPCHEF = 27;

	/**
	 * Chef clean up (reply).
	 */

	public static final int ENDOPDONECHEF = 28;

	/**
	 * Order been completed (service request).
	 */

	public static final int REQORDERCOMPLET = 29;

	/**
	 * Order been completed (reply).
	 */

	public static final int ORDERCOMPLETDONE = 30;

	/**
	 * All portions delived (service request).
	 */

	public static final int REQAPORTDELIVED = 31;

	/**
	 * All portions delived (reply).
	 */

	public static final int APORTDELIVEDDONE = 32;

	/**
	 * Request alert waiter (service request).
	 */
	public static final int REQALWAITER = 33;

	/**
	 * Alert waiter done (reply).
	 */
	public static final int ALWAITERDONE = 34;

	/**
	 * Request hand the note to the chef (service request).
	 */
	public static final int REQNOTECHEF = 35;

	/**
	 * Hand the note to the chef done (reply).
	 */
	public static final int NOTECHEFDONE = 36;

	/**
	 * Request collect portion (service request).
	 */
	public static final int REQCOLLECTPORTION = 37;

	/**
	 * Collect portion done (reply).
	 */
	public static final int COLLECTPORTIONDONE = 38;

	/**
	 * Request return to the bar after salute (service request).
	 */
	public static final int REQRETURNBARSALUTE = 39;

	/**
	 * Return to the bar after salute done (reply).
	 */
	public static final int RETURNBARSALUTEDONE = 40;

	/**
	 * Request return to the bar after taking the order (service request).
	 */
	public static final int REQRETURNBARTAKINGORDER = 41;

	/**
	 * Return to the bar after taking the order done (reply).
	 */
	public static final int RETURNBARTAKINGORDERDONE = 42;

	/**
	 * Request return to the bar after portions delivered (service request).
	 */
	public static final int REQRETURNBARPORTIONSDELIVERED = 43;

	/**
	 * Return to the bar after portions delivered done (reply).
	 */
	public static final int RETURNBARPORTIONSDELIVEREDDONE = 44;

	/**
	 * Request prepare bill (service request).
	 */
	public static final int REQPREPAREBILL = 45;

	/**
	 * Prepare bill done (reply).
	 */
	public static final int PREPAREBILLDONE = 46;

	/**
	 * Request received payment (service request).
	 */
	public static final int REQRECEIVEDPAYMENT = 47;

	/**
	 * Received payment done (reply).
	 */
	public static final int RECEIVEDPAYMENTDONE = 48;

	/**
	 * Request return to the bar (service request).
	 */
	public static final int REQRETURNBAR = 49;

	/**
	 * Return to the bar done (reply).
	 */
	public static final int RETURNBARDONE = 50;

	/**
	 * Request say goodbye (service request).
	 */
	public static final int REQSAYGOODBYE = 51;

	/**
	 * Say goodbye done (reply).
	 */
	public static final int SAYGOODBYEDONE = 52;

	/**
	 * Request salute the client (service request).
	 */
	public static final int REQSALUTECLIENT = 53;

	/**
	 * Salute the client done (reply).
	 */
	public static final int SALUTECLIENTDONE = 54;

	/**
	 * Request get the pad (service request).
	 */
	public static final int REQGETPAD = 55;

	/**
	 * Get the pad done (reply).
	 */
	public static final int GETPADDONE = 56;

	/**
	 * Request have all portions been served (service request).
	 */
	public static final int REQAPORTSERVED = 57;

	/**
	 * Take a seat done (reply).
	 */
	public static final int TAKESEATDONE = 58;

	/**
	 * Request selecting course (service request).
	 */
	public static final int REQSELCOURSE = 59;

	/**
	 * Selecting course done (reply).
	 */
	public static final int SELCOURSEDONE = 60;

	/**
	 * Request first to enter served (service request).
	 */
	public static final int REQFIRSTENTER = 61;

	/**
	 * First to enter done (reply).
	 */
	public static final int FIRSTENTERDONE = 62;

	/**
	 * Request inform companions (service request).
	 */
	public static final int REQINFORMCOMPANIONS = 63;

	/**
	 * Inform Companions done (reply).
	 */
	public static final int INFORMCOMPANIONSDONE = 64;

	/**
	 * Request organize order (service request).
	 */
	public static final int REQORGORDER = 65;

	/**
	 * Organize order done (reply).
	 */
	public static final int ORGORDERDONE = 66;

	/**
	 * Request describe order (service request).
	 */
	public static final int REQDESCORDER = 67;

	/**
	 * Describe order done (reply).
	 */
	public static final int DESCORDERDONE = 68;

	/**
	 * Request chat (service request).
	 */
	public static final int REQCHAT = 69;

	/**
	 * Chat done (reply).
	 */
	public static final int CHATDONE = 70;

	/**
	 * Request enjoy meal (service request).
	 */
	public static final int REQENJOYMEAL = 71;

	/**
	 * Enjoy meal done (reply).
	 */
	public static final int ENJOYMEALDONE = 72;

	/**
	 * Request last to eat (service request).
	 */
	public static final int REQLASTEAT = 73;

	/**
	 * Last to eat done (reply).
	 */
	public static final int LASTEATDONE = 74;

	/**
	 * Request chat again (service request).
	 */
	public static final int REQCHATAGAIN = 75;

	/**
	 * Chat again done (reply).
	 */
	public static final int CHATAGAINDONE = 76;

	/**
	 * Request wait for everyone to finish (service request).
	 */
	public static final int REQEVERYONEFINISH = 77;

	/**
	 * Wait for everyone to finish done (reply).
	 */
	public static final int EVERYONEFINISHDONE = 78;

	/**
	 * Request last to enter restaurant (service request).
	 */
	public static final int REQLASTENTERRESTAURANT = 79;

	/**
	 * Last to enter restaurant done (reply).
	 */
	public static final int LASTENTERRESTAURANTDONE = 80;

	/**
	 * Request honor the bill (service request).
	 */
	public static final int REQHONORBILL = 81;

	/**
	 * Honor the bill done (reply).
	 */
	public static final int HONORBILLDONE = 82;

	/**
	 * Request enter (service request).
	 */
	public static final int REQENTER = 83;

	/**
	 * Enter done (reply).
	 */
	public static final int ENTERDONE = 84;

	/**
	 * Request call the waiter (service request).
	 */
	public static final int REQCALLWAITER = 85;

	/**
	 * Call the waiter done (reply).
	 */
	public static final int CALLWAITERDONE = 86;

	/**
	 * Request signal waiter (service request).
	 */
	public static final int REQSIGNALWAITER = 87;

	/**
	 * Signal waiter done (reply).
	 */
	public static final int SIGNALWAITERDONE = 88;
	/**
	 * Request should have arrived earlier (service request).
	 */
	public static final int REQARREARLIER = 89;

	/**
	 * Should have arrived earlier done (reply).
	 */
	public static final int ARREARLIERDONE = 90;

	/**
	 * Request go home (service request).
	 */
	public static final int REQGOHOME = 91;

	/**
	 * Go home done (reply).
	 */
	public static final int GOHOMEDONE = 92;

	/**
	 * Request deliver portion (service request).
	 */
	public static final int REQDELIVERPORTION = 93;
	/**
	 * Deliver portion done (reply).
	 */
	public static final int DELIVERPORTIONDONE = 94;
	/**
	 * Request present bill (service request).
	 */
	public static final int REQPRESENTBILL = 95;

	/**
	 * Present bill done (reply).
	 */
	public static final int PRESENTBILLDONE = 96;

	/**
	 * Have all portions been served done (reply).
	 */
	public static final int APORTSERVEDDONE = 97;

	/**
	 * Request take a seat (service request).
	 */
	public static final int REQTAKESEAT = 98;
	
	/**
	 * Request look around (service request).
	 */
	public static final int REQLOOKAROUND = 99;
	
	/**
	 * Look around done (reply).
	 */
	public static final int LOOKAROUNDDONE = 100;
	
	/**
	 * Waiter end op (reply).
	 */

	public static final int ENDOPDONEWAITER = 101;
	
	/**
	 * Student end op (reply).
	 */

	public static final int ENDOPDONESTUDENT = 102;
	
	/**
	 * End of work - waiter (service request).
	 */

	public static final int ENDOPWAITER = 103;
	
	/**
	 * End of work - student (service request).
	 */

	public static final int ENDOPSTUDENT = 104;
	
	/**
	 * Set student seat at the table - repos (service request).
	 */

	public static final int STSSEAT = 105;
	
	/**
	 * Set number of portions delivered - repos (service request).
	 */

	public static final int STSPD = 106;
	
	/**
	 * Set number of courses delivered - repos (service request).
	 */

	public static final int STSCD = 107;
}
