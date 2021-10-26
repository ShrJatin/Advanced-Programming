package Assiggnment_3;

public class Player {

    private final String name;
    private int points;
    private Floor floor;
    private final Dice dice;

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

        if(!floor.getType().equals("Empty")){
            this.jump(((ModifiedFloor) floor).getToFloor());
        }
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
