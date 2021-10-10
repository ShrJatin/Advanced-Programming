class Status{

    Vaccine vaccine;
    int dose_count;
    String status;
    int next_due;

    Status(){
        this.dose_count = 0;
        this.status = "Citizen REGISTERED";
        this.next_due = -1;
    }
}