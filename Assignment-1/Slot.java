class Slot implements Comparable<Slot> {

    int day;
    int quantity;
    Vaccine vaccine;


    Slot(int day, int quantity, Vaccine vaccine){

        this.day = day;
        this.quantity = quantity;
        this.vaccine = vaccine;

    }

    public int compareTo(Slot o) {
      return this.day - o.day;
    }

}