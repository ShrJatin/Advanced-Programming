package Assignment_1;

class Vaccine{

    private final String name;
    private final int dose_count;
    private final int dose_gap;

    Vaccine(String name, int dose_count, int dose_gap){
        this.name = name;
        this.dose_count = dose_count;
        this.dose_gap = dose_gap;

        System.out.println("Vaccine Name: " + this.name + ", Number of Doses: " + this.dose_count + ", Gap Between Doses: "+this.dose_gap);
    }

    public String getName() {
        return name;
    }

    public int getDose_count() {
        return dose_count;
    }

    public int getDose_gap() {
        return dose_gap;
    }
}