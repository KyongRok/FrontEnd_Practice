// class to store reusults
import java.util.*;
import java.io.Serializable;
class SumMaxResult implements Serializable  {
	private int arr[]; // the array operated on
    private int max;   // max value
	private int sum;   // sum value
	private Date date;  // result created date/time

	public SumMaxResult(int max, int sum , int[]  arr, Date date){
		this.arr = arr;
		this.date = date;
		this.sum = sum;
		this.max = max;
	}
    public int getSum(){
		return sum;
	}
	public int getMax(){
		return max;
	}
	public int[] getArr(){
		return this.arr;
	}

	public Date getDate(){
		return this.date;
	}
	
}
		