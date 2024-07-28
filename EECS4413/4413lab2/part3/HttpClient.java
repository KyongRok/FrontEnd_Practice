/**
 * This program demonstrates how to use a socket to communicate
 * with a web server.
 */
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class HttpClient {
   public static void main(String[] args) throws Exception {

      // Open socket

      final int HTTP_PORT = 80;

      String request = "";
      String hostname = args[0];
      if (args.length == 2) {
         String root = args[1];
         request = "GET " + root + " " + "HTTP/1.1";
      }else{
         request = "GET /" + " " + "HTTP/1.1";
      }
      

      try{
         Socket s = new Socket(hostname, HTTP_PORT);
         InputStream instream = s.getInputStream();
         OutputStream outstream = s.getOutputStream();

         Scanner in = new Scanner(instream);
         PrintWriter out = new PrintWriter(outstream);

         String command = request + "\r\n" + "Host: " + hostname + "\r\n\r\n";
         System.out.println(command);

         out.print(command);
         out.flush();

         while(in.hasNextLine()){
            String input = in.nextLine();
            System.out.println(input);
         }
         
      }catch(Exception e){

      }
      // Get streams

   }
}
