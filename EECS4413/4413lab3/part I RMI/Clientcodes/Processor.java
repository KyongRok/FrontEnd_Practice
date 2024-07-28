import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Processor extends Remote {
	
	public String upper(String s) throws RemoteException;
  	public String sort(String s) throws RemoteException;
	public String reverse(String s) throws RemoteException;
	public boolean isPalindrome(String s) throws RemoteException;
}

