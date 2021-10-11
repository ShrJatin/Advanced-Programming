package Assignment_1;

class Slot implements Comparable<Slot> {

    private final int day;
    private final Vaccine vaccine;
    private int quantity;


    Slot(int day, int quantity, Vaccine vaccine){

        this.day = day;
        this.quantity = quantity;
        this.vaccine = vaccine;

    }

    public int compareTo(Slot o) {
        return this.day - o.day;
    }

    public int getDay() {
        return day;
    }

    public int getQuantity() {
        return quantity;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setQuantity() {
        this.quantity--;
    }
}