import java.net.*;
public class Server {

   public static void main(String argv[]) throws Exception {
      ServerSocket welcomeSocket = new ServerSocket(Integer.parseInt(argv[0]));

      while (true) {
         Socket connectionSocket = welcomeSocket.accept();
         ClientHandler handler = new ClientHandler(connectionSocket);
         handler.start();
      }
   }
}
