package Assignment_3;

import java.util.*;

class Floor {

    private final String type;
    private final int location;
    private final int rewards;
    private final ArrayList<Prize> prizes;
    private Floor toFloor;

    Floor(String type, int location, int rewards) {
        this.type = type;
        this.location = location;
        this.rewards = rewards;
        this.prizes = makePrizeList();

    }
    public ArrayList<Prize> makePrizeList(){
        ArrayList<Prize> prizes = new ArrayList<>();
        prizes.add(new Prize("Snake Winner", 6));
        prizes.add(new Prize("King Cobra Winner", 12));
        prizes.add(new Prize("Game Winner", 13));
        return prizes;
    }

    Floor getToFloor() {
        return toFloor;
    }

    void setToFloor(Floor toFloor) {
        this.toFloor = toFloor;
    }

    public void updateStat(Player player) {
        player.setPoints(player.getPoints() + rewards);
        player.setFloor(this);

        if (type.equals("Elevator") && !player.getPrizes().contains(new Prize("Elevator Winner", 8)))
            player.getPrizes().add(new Prize("Elevator Winner", 8));

        if (type.equals("Ladder") && !player.getPrizes().contains(new Prize("Ladder Winner", 2))) {
            player.getPrizes().add(new Prize("Ladder Winner", 2));
        }

        for(Prize prize : prizes) {
            if(location >= prize.getMoney() && !player.getPrizes().contains(prize)){
                player.getPrizes().add(prize);
                break;
            }
        }
    }

    public String getType() {
        return type;
    }

    public int getLocation() {
        return location;
    }
}

class EmptyFloor extends Floor{
    EmptyFloor(int location){
        super("Empty",location,1);
    }
}

class SnakeFloor extends Floor{
    SnakeFloor(String type, int location, int rewards, Floor toFloor) {
        super(type, location, rewards);
        super.setToFloor(toFloor);

    }
}

class NormalSnakeFloor extends SnakeFloor{
    NormalSnakeFloor(int location, Floor toFloor){
        super("Snake",location, -2, toFloor);
    }
}

class CobraSnakeFloor extends SnakeFloor{
    CobraSnakeFloor( int location, Floor toFloor){
        super("King Cobra",location,-4, toFloor);
    }
}


class LadderFloor extends Floor{
    LadderFloor(String type, int location, int rewards, Floor toFloor){
        super(type,location,rewards);
        super.setToFloor(toFloor);
    }
}

class NormalLadderFloor extends LadderFloor{
    NormalLadderFloor(int location, Floor toFloor){
        super("Ladder",location,2, toFloor);
    }
}

class ElevatorLadderFloor extends LadderFloor{
    ElevatorLadderFloor(int location, Floor toFloor){
        super("Elevator",location,4, toFloor);
    }
}
