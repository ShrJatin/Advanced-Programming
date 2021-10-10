package Assignment_1;

class Citizen{

    String name;
    private int age;
    String id;

    Status status;

    Citizen(String name, int age, String id){
        this.name = name;
        this.age = age;
        this.id = id;
        this.status = new Status();
        
        System.out.println("Citizen Name: " + this.name + ", Age: " + this.age + ", Unique ID: "+this.id);
    }

    void set_status(Slot slot){

        status.vaccine = slot.vaccine;
        status.dose_count ++;

        if(status.dose_count == slot.vaccine.dose_count){
            status.status = "FULLY VACCINATED";
            status.next_due = Integer.MAX_VALUE;

        } else {
            status.status = "PARTIALLY VACCINATED"; 
            status.next_due = slot.day + slot.vaccine.dose_gap;
        }
    }

    
    
    void get_status(){
        System.out.println(status.status);

        if (status.status.equals("PARTIALLY VACCINATED")) {
            System.out.println("Vaccine Given: " + status.vaccine.name);
            System.out.println("Number of Doses given: " + status.dose_count);
            System.out.println("Next Dose due date: " + status.next_due);
            
        } else if(status.status.equals("FULLY VACCINATED")) {
            System.out.println("Vaccine Given: " + status.vaccine.name);
            System.out.println("Number of Doses given: " +status.dose_count);
        }
    }

}
