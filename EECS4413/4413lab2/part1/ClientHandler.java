import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler extends Thread {
    Socket clientSocket;
    String clientstring;
    String replystring;

    public ClientHandler(Socket s) {
        this.clientSocket = s;
    }

    @Override
    public void run() {
        
        System.out.println("listening...");
        try {
            ObjectOutputStream obj = new ObjectOutputStream(clientSocket.getOutputStream());
             BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream());
            while (true) {
               
                while (true) {

                    if (!((clientstring = inFromClient.readLine()).contains("array"))) {
                        replystring = clientstring.toUpperCase();
                        outToClient.println(replystring);
                        outToClient.flush();
                    } else {

                        String[] array = null;
                        array = clientstring.split(" ");
                        int[] int_arr = new int[array.length - 1];
                        int j = 0;
                        for (int i = 1; i < array.length; i++) {
                            int_arr[j] = Integer.parseInt(array[i]);
                            j++;
                        }
                        calHandler cal = new calHandler(int_arr);
                        int sum = cal.getsum();
                        int max = cal.getmax();
                        Date date = cal.getdate();
                        SumMaxResult re = new SumMaxResult(max, sum, int_arr, date);
                        replystring = "Calculating...\n";
                        outToClient.println(replystring);
                        outToClient.flush();
                        obj.writeObject(re);
                        obj.flush();

                    }

                }
            }
        } catch (Exception e) {
            ;
        }
    }
}
