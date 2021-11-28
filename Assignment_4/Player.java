package Assignment_4;

public class Player {

    private final Bucket<SoftToy> bucket;

    public Player() {
        this.bucket = new Bucket<>();
    }

    void storeToy(SoftToy toy) {
        bucket.storeToBucket(toy);
    }

    public Bucket<SoftToy> getBucket() {
        return bucket;
    }

    void showBucket() {
        System.out.println(bucket);
    }
}
