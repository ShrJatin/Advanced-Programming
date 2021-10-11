package Assignment_1;

class Citizen{

    private final String name;
    private final int age;
    private final String id;
    private final Status status;

    Citizen(String name, int age, String id){
        this.name = name;
        this.age = age;
        this.id = id;
        this.status = new Status();

        System.out.println("Citizen Name: " + this.name + ", Age: " + this.age + ", Unique ID: "+this.id);
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

}
