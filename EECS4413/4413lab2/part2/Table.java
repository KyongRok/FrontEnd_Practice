import java.util.*;

/************************************************
 * this class implements database, storing client info
 *************************************************/
public class Table {
  // a appropriate data structure attribut to store records to update the data
  // structure, and return relavent message
  private List<userClass> tables;

  public Table() {
    tables = Collections.synchronizedList(new ArrayList<userClass>());
    
  }

  public int register(String n, String type){
    int flag = 0;
    int nameCheck = 0;

    for (int i = 0; i < tables.size(); i++) {
      String tempName = tables.get(i).getName();
      if (tempName.equals(n)) {
        nameCheck = 1;
      }

    }
    if ((type.equals("grad") || type.equals("ugrad") || type.equals("faculty")) && nameCheck == 0) {
      userClass uc = new userClass(n, type);
      tables.add(uc);
      nameCheck = 1;
      flag = 1;
    }
    // flag = 1 -> add successful

    return flag;
  }

  public int quit(String name) {
    int flag = 0;
    int index = -1;
    for(int i = 0; i < tables.size(); i++){
      if((tables.get(i).getName()).equals(name)){
        index = i;
        flag = 1;
      }
    }
    if(flag == 1){
      System.out.println("yep");
      tables.remove(index);
      index = -1;
      flag = 0;
    }
    
    return flag;
  }

  public ArrayList<userClass> query_ugrad() {
    ArrayList<userClass> u = new ArrayList<>();
    if (tables.size() != 0) {
      for (int i = 0; i < tables.size(); i++) {
        if ((tables.get(i).getType()).equals("ugrad")) {
          u.add(tables.get(i));
        }
      }
    }

    return u;
  }

  public ArrayList<userClass> query_grad() {
    ArrayList<userClass> u = new ArrayList<>();
    if (tables.size() != 0) {
      for (int i = 0; i < tables.size(); i++) {
        if ((tables.get(i).getType()).equals("grad")) {
          u.add(tables.get(i));
        }
      }
    }
    return u;
  }

  public ArrayList<userClass> query_faculty() {
    ArrayList<userClass> u = new ArrayList<>();
    if (tables.size() != 0) {
      for (int i = 0; i < tables.size(); i++) {
        if ((tables.get(i).getType()).equals("faculty")) {
          u.add(tables.get(i));
        }
      }
    }

    return u;
  }

  public ArrayList<userClass> query_all() {
    ArrayList<userClass> u = new ArrayList<>();
    if (tables.size() != 0) {
      for (int i = 0; i < tables.size(); i++) {
        u.add(tables.get(i));
      }
    }

    return u;
  }
  // provide public methods such as
  // string REGISTER(...)
  // string QUERY(...)
  // string QUIT( ...)

  // Note that the method may need to be synchronzied so differetn threads wont
  // update data strure at the same time.

} // end of class
