package Watch;

import Counter.CounterArray;

/**
 *
 * Created by Irindul on 28/09/2016.
 * Class of a Clock. Contains an array of counters set with clock value.
 */
public class Clock {
    private CounterArray clocks;

    public Clock(){
        int[] steps = {1, 1, 1};
        int[] infs = {0, 0, 0};
        int[] sups = {60, 60, 12};
        clocks = new CounterArray(3, steps, infs, sups);
    }

    public int getSeconds(){
        return  clocks.getCounterI(0).getValue();
    }

    int getMinutes(){
        return  clocks.getCounterI(1).getValue();
    }

    int getHour(){
        return  clocks.getCounterI(2).getValue();
    }

    public void reset(){
        clocks.flush();
    }

    void display(){
        System.out.println(this.getHour() + "h" + this.getMinutes() + "m" + this.getSeconds() + "s");
    }

    void increment(){
        clocks.increment();
    }

    public void clock(){
        while(true){  //Infinite loop the clock is always running till it runs out of energy. Not handle here.
            this.display(); //We call the display function.
            this.sleep(1000);
            this.increment();
        }
    }


    public static void sleep(int n){
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
