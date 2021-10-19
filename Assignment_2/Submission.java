package Assignment_2;

public class Submission {

    private final String submission;
    private boolean isGraded;
    private int grades;
    private String instructor;

    Submission(String submission) {

        this.submission = submission;
        this.isGraded = false;
        this.grades = 0;
        this.instructor = null;
    }

    public boolean isGraded() {
        return isGraded;
    }

    public String getSubmission() {
        return submission;
    }

    public void setGrading(int grades, String instructor) {
        this.grades = grades;
        this.instructor = instructor;
        this.isGraded  = true;
    }

    @Override
    public String toString() {
        String print;
        if(this.isGraded){
            print = "Submission: " + this.submission + "\n" +
                    "Marks scored: " + this.grades + "\n" +
                    "Graded by: " + this.instructor;
        } else {
            print = "Submission: " + this.submission ;
        }

        return print;
    }
}
