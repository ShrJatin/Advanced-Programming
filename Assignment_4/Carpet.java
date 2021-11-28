package Assignment_4;

import java.util.ArrayList;

public class Carpet <T>{

    private final ArrayList<T> carpet;
    private final int length;

    public Carpet(int length){
        carpet = new ArrayList<>();
        this.length = length;
    }

    public ArrayList<T> getCarpet() {
        return carpet;
    }

    public T getTile(int index) throws TileNotExistException{
        if(index > length)
            throw new TileNotExistException("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!\n");
        else
            return carpet.get(index - 1);
    }

    public int getLength() {
        return length;
    }

    void fillCarpet(T t) throws CarpetLengthExceedException{

        if(carpet.size() > length) {
            throw new CarpetLengthExceedException("Carpet length exceeded");
        } else {
            try {
                carpet.add(t);
            } catch (NullPointerException e) {
                System.out.println("Filling Object Might be Null");
                e.printStackTrace();
            }
        }
    }
}
