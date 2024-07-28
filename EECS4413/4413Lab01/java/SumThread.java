/**
 * This thread finds the sum of values of a subsection of an given array.
 *  
 */
 

public class SumThread extends Thread {
    private String name;  // name of the thread 
	private int low, hi;   // range of array  from lo to hi, [lo, hi) include low but does not includ hi
    private int[] arr;   // array to be searched
    private int ans = 0;  // store results

    public SumThread(int[] arr, int lw,int high, String threadname){
        this.name = threadname;
        this.low = lw;
        this. hi = high;
        this.arr = arr;
    }

    public int SumThreadReturn(){
        return this.ans;
    }
   
    @Override
    public void run() {
        int temp = 0;
		for(int i = this.low; i <= this.hi; i++){
            temp += arr[i];
        }
        this.ans = temp;
		System.out.println(this.name + " finish");
    }

 
 }

// create a similar class called MaxThread.java, which finds the max value in a subsection of an given array.
 