package Assignment_3;

class Floor {

    private final String type;
    private final int location;
    private final int rewards;

    Floor(String type, int location, int rewards) {
        this.type = type;
        this.location = location;
        this.rewards = rewards;
    }

    public void updateStat(Player player) {
        player.setPoints(player.getPoints() + rewards);
        player.setFloor(this);
    }

    public String getType() {
        return type;
    }

    public int getLocation() {
        return location;
    }
}

class ModifiedFloor extends Floor{

    private final Floor toFloor;

    ModifiedFloor(String type, int location, int rewards, Floor toFloor){
        super(type,location,rewards);
        this.toFloor = toFloor;
    }

    public Floor getToFloor() {
        return toFloor;
    }
}
