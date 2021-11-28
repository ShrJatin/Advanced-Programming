package Assignment_4;

public class SoftToy implements Cloneable{

    private final String name;

    public SoftToy(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return  name;
    }
}
