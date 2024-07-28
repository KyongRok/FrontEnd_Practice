import java.io.*;
import java.net.*;

public class Client {

    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String replySentence;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket(argv[0], Integer.parseInt(argv[1]));
        PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ObjectInputStream inobj = new ObjectInputStream(clientSocket.getInputStream());
        
        while ((clientSentence = inFromUser.readLine()) != null) {
            outToServer.println(clientSentence);
            replySentence = inFromServer.readLine();
            System.out.println("FROM SERVER: " + replySentence);
            if (clientSentence.contains("array")) {
                SumMaxResult re = (SumMaxResult) inobj.readObject();
                int[] arr = re.getArr();
                System.out.print("[");
                for(int i = 0; i< arr.length; i++){
                    System.out.print(arr[i] + " ");
                }
                System.out.print("]\n");
                System.out.println("SUM: " + re.getSum());
                System.out.println("MAX:" + re.getMax()); 
                System.out.println(re.getDate());
                break;
            }
        }

        clientSocket.close();
    }

}
