import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 

public class ServerRMI {
    public static void main(String args[]) {
    try{

      System.out.println("Running...");
      ProcessorImpl p = new ProcessorImpl();
      // Processor stub = (Processor) UnicastRemoteObject.exportObject(p, 0);
      // Registry registry = LocateRegistry.getRegistry(1234);
      // registry.rebind("rmi://localhost:1234/process", stub);
      Naming.rebind("rmi://localhost:1234/process", p);
    }catch(Exception e){
      ;
    }
  }

}
