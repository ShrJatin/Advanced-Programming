package Assignment_2;

public class Assessment implements Utility, Cloneable{

    private final String problem;
    private final int max_marks;
    private final String type;
    private final int id;
    private static int random = 0;
    private Submission submission = null;

    Assessment(String problem, int max_marks, String type){
        this.problem = problem;
        this.max_marks = max_marks;
        this.type = type;
        this.id = random;
        random++;
    }

    public Submission getSubmission() {
        return this.submission;
    }

    public void setSubmission(String submission) {
        this.submission = new Submission(submission);
    }

    public int getMax_marks() {
        return max_marks;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getProblem() {
        return problem;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    @Override
    public String toString() {
        String print = "";
        if(this.type.equals("assignment")){
            print = "ID: " + this.id + " Assignment: " + this.problem + " Max Marks: " + this.max_marks + "\n" + "----------------";
        } else if(this.type.equals("quiz")){
            print = "ID: " + this.id + " Question: " + this.problem + "\n" + "----------------";
        }
        return print;
    }

}
