package Assignment_4;

public abstract class Tile<T> {

    T toy;
    Tile(T toy) {
        this.toy = toy;
    }

    public abstract void giveGift(Player player) throws TypeMismatchException;

}

class EvenTile <T> extends Tile<T>{

    public EvenTile(T toy) {
        super(toy);
    }

    @Override
    public void giveGift(Player player) throws TypeMismatchException {

        if(toy instanceof SoftToy){
            SoftToy s_toy = (SoftToy) toy;
            try {
                SoftToy C_toy = (SoftToy) s_toy.clone();
                player.storeToy(C_toy);
                System.out.println("\tYou won a " + C_toy + " toy");
            }
            catch (CloneNotSupportedException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

        else throw new TypeMismatchException("Toy type may not have matched");
    }
}


class OddTile<T> extends Tile<T>{

    public OddTile(T toy) {
        super(toy);
    }

    @Override
    public void giveGift(Player player) throws TypeMismatchException {

        if(toy instanceof SoftToy){
            SoftToy s_toy = (SoftToy) toy;
            try {
                SoftToy C_toy = (SoftToy) s_toy.clone();
                player.storeToy(C_toy);
                System.out.println("\tYou won a " + C_toy + " toy");
            }
            catch (CloneNotSupportedException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

        else throw new TypeMismatchException("Toy type may not have matched");
    }
}