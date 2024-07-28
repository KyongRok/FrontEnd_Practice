import java.io.*;
import java.net.*;

public class Client {
    
    public static void main(String argv[]) throws Exception{
        String clientSentence;
        String replySentence;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket(argv[0], Integer.parseInt(argv[1]));
        PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        while ((clientSentence = inFromUser.readLine()) != null) {
            outToServer.println(clientSentence);
            replySentence = inFromServer.readLine();   
            System.out.println("COMMAND: " + clientSentence + "\n");
            System.out.println(replySentence+"\n");
            outToServer.flush();
            if(replySentence.equals("quit")){
                break;
            }
        }

        clientSocket.close();
    }
}
