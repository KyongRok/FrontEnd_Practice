
import java.net.*; 


/**************************************************************************
 client connects to server, sends to server REGISTER, QUERY or QUIT message
 for QUERY, the server will search its Table database and return the search result
****************************************************************************/
class Server
{ 

  public static void main(String argv[]) throws Exception 
  { 
      // basic database that will be shared by all connection sessions/
      Table table = new Table(); 
     
      // establish connection
      ServerSocket welcomeSocket = new ServerSocket(Integer.parseInt(argv[0]));

      System.out.println("server ready, waitting for connections ...");
      
      while (true)
      {
          Socket connection = welcomeSocket.accept();
          ServerThread th = new ServerThread(connection , table);
          th.start();
       
       } // end of while
		  
  } // end of main
 
  
  
}  // end of class 
 
