// this class retrieve the results from the disk file

import java.io.FileInputStream;
import java.io.ObjectInputStream;

class Depersist {

 public static void main(String args[]){  
  
  //  open file "result.txt" and retrieve the SumMaxResult object
  
  //  and output the 4 attributes of the object
    Depersist d = new Depersist();
    SumMaxResult re = (SumMaxResult) d.objfromfile("result.txt");
    System.out.println("Sum: " + re.getSum() + " Max: " + re.getMax()+"");
    System.out.print("Array: [");
    for(int i = 0; i < re.getArr().length; i++){
      System.out.print(re.getArr()[i]+ ",");
    }
    System.out.println("]");
    System.out.println("Date: " + re.getDate());
  }
  public Object objfromfile(String fname){
    
    try{
      FileInputStream filein = new FileInputStream("result.txt");
      ObjectInputStream objectin = new ObjectInputStream(filein);
      Object obj = objectin.readObject();
      objectin.close();
      return obj;
    }catch(Exception e){
      return null;
    } 
  }
}
  
      
  
