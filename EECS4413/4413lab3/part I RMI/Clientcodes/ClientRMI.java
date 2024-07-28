import java.rmi.Naming;
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.io.*;

public class ClientRMI{

      public static void main(String[] args) {
      try{
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        //Registry registry = LocateRegistry.getRegistry("localhost" , 1234);
        Processor stub = (Processor) Naming.lookup("rmi://localhost:1234/process");
        System.out.println("Enter Your String: ");
        String in;
        while(!((in=br.readLine()).equals("stop"))){
          System.out.println("upper:\t" + stub.upper(in));
          System.out.println("sort:\t" + stub.sort(in));
          System.out.println("rever:\t" + stub.reverse(in));
          System.out.println("isPanl:\t" + stub.isPalindrome(in));
        }
        System.out.println("Enter Your String: ");
      }catch(Exception e){
        System.out.println("why");
      }
  }
}
