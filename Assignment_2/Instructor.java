package Assignment_2;

import java.util.*;

public class Instructor implements Adder, Viewer {

    private static int sub = 0;
    private final String name;

    Instructor(){
        this.name = "I" + sub;
        sub++;
    }

    public String getName() {
        return name;
    }

    @Override
    public void adder(ArrayList<Utility> util1, Utility util2){
        util1.add(util2);
    }

    @Override
    public void viewer(ArrayList<Utility> util){
        for(Utility utility : util){
            System.out.println(utility);
        }
    }

    @Override
    public boolean logout(){
        System.out.println("Logging out...");
        return false;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
