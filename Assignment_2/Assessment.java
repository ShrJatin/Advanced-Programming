package Assignment_2;

public class Assessment implements Utility{

    private final String problem;
    private final int max_marks;
    private final String type;
    private final int id;
    private static int random = 0;
    private Submission submission;

    Assessment(String problem, int max_marks, String type){
        this.problem = problem;
        this.max_marks = max_marks;
        this.type = type;
        this.id = random;
        random++;
    }

    @Override
    public Submission getSubmission() {
        return this.submission;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String print = "";
        if(this.type.equals("assignment")){
            print = "ID: " + this.id + " Assignment: " + this.problem + " Max Marks: " + this.max_marks + "\n" + "----------------" + "\n";
        } else if(this.type.equals("quiz")){
            print = "ID: " + this.id + " Question: " + this.problem + "\n" + "----------------" + "\n";
        }

        return print;
    }

}
