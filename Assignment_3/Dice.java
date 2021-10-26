package Assignment_3;

import java.util.*;

class Dice {

    private final int numFaces;
    private int faceValue;
    private final Random rand = new Random();

    Dice(int _numFaces) {
        numFaces = _numFaces;
    }

    private void setFaceValue (int value) {
        if (value <= numFaces)
            faceValue = value;
    }

    public int roll() {
        int curr_faceValue = 1 + rand.nextInt(numFaces);
        setFaceValue(curr_faceValue);
        System.out.println("Dice Gave " + faceValue);
        return faceValue;
    }
}
