public class Maxcal extends Thread{
    private String name;
    private int low,hi;
    private int[] arr;
    private int ans=0;
    public Maxcal(int[] arr, int lw, int high, String threadname){
        this.name = threadname;
        this.low = lw;
        this.hi = high;
        this.arr = arr;
    }
    public int MaxThreadReturn(){
        return this.ans;
    }


    @Override
    public void run(){
        int temp = 0;
        for(int i = this.low; i <= this.hi; i++){
            if(arr[i] >= temp){
                temp = arr[i];
            }
        }
        this.ans = temp;
        System.out.println(this.name + " finish");
    }
}
