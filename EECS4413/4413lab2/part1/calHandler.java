
import java.util.*;

public class calHandler {
    private int low1;
    private int low2;
    private int high1;
    private int high2;
    private Date date;
    private int sum;
    private int max;

    private int[] array;

    public calHandler(int[] array) {
        this.array = array;
        low1 = 0;
        high1 = (array.length) / 2;
        low2 = ((array.length) / 2) + 1;
        high2 = array.length - 1;
        docal();

    }

    public void docal() {
        Maxcal max1 = new Maxcal(array, low1, high1, "MaxThread A");
        Maxcal max2 = new Maxcal(array, low2, high2, "MaxThread B");

        Sumcal sum1 = new Sumcal(array, low1, high1, "SumThread X");
        Sumcal sum2 = new Sumcal(array, low2, high2, "SumThread Y");

        max1.start();
        max2.start();
        sum1.start();
        sum2.start();

        try {
            max1.join();
            max2.join();
            sum1.join();
            sum2.join();
        } catch (Exception e) {

        }
        int sum = sum1.SumThreadReturn() + sum2.SumThreadReturn();
        int max;
        if (max1.MaxThreadReturn() >= max2.MaxThreadReturn()) {
            max = max1.MaxThreadReturn();
        } else {
            max = max2.MaxThreadReturn();
        }
        Date d = new Date();
        this.sum = sum;
        this.max = max;
        this.date = d;
    }

    public int getsum(){
        return this.sum;
    }

    public int getmax(){
        return this.max;
    }

    public Date getdate(){
        return this.date;
    }
}
