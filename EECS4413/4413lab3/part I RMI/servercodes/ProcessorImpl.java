import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.Arrays;

public class ProcessorImpl extends UnicastRemoteObject implements Processor {
  // Implementations must have an explicit constructor
  public ProcessorImpl() throws RemoteException {
    super();
  }

  public String upper(String s) throws RemoteException {
    return s.toUpperCase();
  }

  public String reverse(String s) throws RemoteException {
    String reverse = "";

    for (int i = (s.length() - 1); i >= 0; i--) {
      reverse += s.charAt(i);
    }
    return reverse;
  }

  public String sort(String s) throws RemoteException {
    char tempArray[] = s.toCharArray();
    Arrays.sort(tempArray);

    return new String(tempArray);
  }

  public boolean isPalindrome(String s) throws RemoteException {
    String reverse = "";

    for (int i = (s.length() - 1); i >= 0; i--) {
      reverse += s.charAt(i);
    }

    if (s.toLowerCase().equals(reverse.toLowerCase())) {
      return true;
    }
    return false;
  }

}
