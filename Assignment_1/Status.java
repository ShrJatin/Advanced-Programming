package Assignment_1;

class Status{

    private Vaccine vaccine;
    private int dose_count;
    private String status;
    private int next_due;

    Status(){
        this.dose_count = 0;
        this.status = "Citizen REGISTERED";
        this.next_due = -1;
    }

    public int getDose_count() {
        return dose_count;
    }

    public int getNext_due() {
        return next_due;
    }

    public String getStatus() {
        return status;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setStatus(Slot slot) {

        vaccine = slot.getVaccine();
        setDose_count();

        if(dose_count == slot.getVaccine().getDose_count()){
            status = "FULLY VACCINATED";
            next_due = Integer.MAX_VALUE;

        } else {
            status = "PARTIALLY VACCINATED";
            next_due = slot.getDay() + slot.getVaccine().getDose_gap();
        }
    }
    public void setDose_count() {
        this.dose_count++;
    }

}