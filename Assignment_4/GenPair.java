package Assignment_4;

import java.util.Random;

public class GenPair <T> {

    private T el1;
    private T el2;
    private final int strBound;
    private final Random random;

    public GenPair() {
        random = new Random();
        this.strBound = 4;
    }

    public T getEl1() {
        return el1;
    }
    public T getEl2() {
        return el2;
    }

    public void setEl2(T el2) {
        this.el2 = el2;
    }
    public void setEl1(T el1) {
        this.el1 = el1;
    }

    public GenPair<Integer> intPair() {

        GenPair<Integer> intPair = new GenPair<>();
        intPair.setEl1(getInt());
        intPair.setEl2(getInt());

        return intPair;
    }

    public GenPair<String> strPair() {

        GenPair<String> strPair = new GenPair<>();
        strPair.setEl1(getString());
        strPair.setEl2(getString());

        return strPair;
    }

    public Integer getInt() {
        return random.nextInt();
    }

    public String getString() {

        String collection = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        String str = "";

        for(int i = 0; i < strBound; i++) {
            int idx = random.nextInt(collection.length()-1);
            str = str.concat(collection.substring(idx, idx + 1));
        }

        return str;
    }
}
