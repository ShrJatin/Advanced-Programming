package Assignment_3;

import java.util.*;

public class Player {

    private final String name;
    private int points;
    private Floor floor;
    private final Dice dice;
    private final ArrayList<Prize> prizes = new ArrayList<>();

    Player(String name){
        this.name = name;
        this.points = 0;
        this.dice = new Dice(2);
    }

    void jump(Floor floor){

        floor.updateStat(this);
        System.out.println("Player position Floor-" + this.floor.getLocation());
        System.out.println(name + " has reached an " + this.floor.getType() + " Floor");
        System.out.println("Total points " + this.points);

        if(prizes.size() > 0){
            System.out.print("Prizes Collected: ");
            for(Prize prize : prizes){
                System.out.print(" #" + prize.getPrize() + "# ");
            }
            System.out.println();
        }

        if(!floor.getType().equals("Empty")){
            System.out.println("........");
            this.jump(floor.getToFloor());
        }
    }

    public ArrayList<Prize> getPrizes() {
        return prizes;
    }

    public String getName() {
        return name;
    }

    public int roll(){
        return dice.roll();
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Floor getFloor() {
        return floor;
    }
}
