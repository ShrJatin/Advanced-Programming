package Assignment_1;

class Vaccine{

    String name;
    int dose_count;
    int dose_gap;
    
    Vaccine(String name, int dose_count, int dose_gap){
        this.name = name;
        this.dose_count = dose_count;
        this.dose_gap = dose_gap;
   
        System.out.println("Vaccine Name: " + this.name + ", Number of Doses: " + this.dose_count + ", Gap Between Doses: "+this.dose_gap);
    }
}