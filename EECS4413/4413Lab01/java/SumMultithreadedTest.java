import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class SumMultithreadedTest{
    /**
     * Get sum and max of an array.
     *
     *  
     */
   
   public static void main(String[] args) {
        int[] mynums = new int[]{7,3,5,6,8,15, 9,3,10};
		// create two instance of SumThread class, give them name "sum thread A", "sum thread B", 
		// give them the aray, and the range.  One will work on the first half of the array, another will work on the second half of the array
		SumThread threadSum1 = new SumThread(mynums, 0,4,"sum thread A");
		SumThread threadSum2 = new SumThread(mynums, 5,8 ,"sum Thread B");
		
		// create two instance of MaxThread class, give them name "max thread X", "max thread Y", 
		// give them the aray, and the range.  One will work on the first half of the array, another will work on the second half of the array
		MaxThread threadMax1 = new MaxThread(mynums, 0,4,"max thread X");
		MaxThread threadMax2 = new MaxThread(mynums, 5,8, "max Thread Y");


		// starts/fire the 4 threads so they work in parallel

		threadSum1.start();
		threadSum2.start();
		threadMax1.start();
		threadMax2.start();


	    // wait for the 4 threads to finish, and retrieve the results.
		try{
			threadMax1.join();
			threadMax2.join();
			threadSum1.join();
			threadSum2.join();
		}catch(InterruptedException e){

		}
		//...
		int sum1 = threadSum1.SumThreadReturn();
		int sum2 = threadSum2.SumThreadReturn();
		int sum = sum1+sum2;
		int max;
		int mthread1 = threadMax1.MaxThreadReturn();
		int mthread2 = threadMax2.MaxThreadReturn();
		max = mthread2;
		if(mthread1 >= mthread2){
			max = mthread1;
		}

		System.out.println(sum + " " + max  );
		Date d = new Date();
		System.out.println(d); 

		// store the result data to the instancre of SumMaxResult class

		// write the object to a disk file "result.txt"

		//...
		SumMaxResult result = new SumMaxResult(max, sum, mynums, d);
		try{
			FileOutputStream fout = new FileOutputStream("result.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(result);
			out.flush();
			out.close();
		}catch(Exception e){
	
		}
		
		System.out.println("Writing success");
   }


}


 