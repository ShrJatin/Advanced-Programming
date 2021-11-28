package Assignment_4;

import java.util.*;

public class Bucket<T> {

    private final ArrayList <T> bucket;

    public Bucket() {
        this.bucket = new ArrayList<>();
    }

    public ArrayList<T> getBucket() {
        return bucket;
    }

    public void storeToBucket(T object){
        bucket.add(object);
    }

    @Override
    public String toString() {

        StringBuilder toStrBuilder = new StringBuilder();
        toStrBuilder.append("| ");
        for(T t : bucket)
            toStrBuilder.append(t).append(" | ");
        String toStr = toStrBuilder.toString();

        toStr+="\n";

        return toStr;
    }
}
