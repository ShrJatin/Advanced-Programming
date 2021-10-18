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

    public int getGrades() {
        return grades;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getSubmission() {
        return submission;
    }

    public int getId() {
        return id;
    }


    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setGraded(boolean graded) {
        isGraded = graded;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        String print = "";
        if(this.isGraded){
            print = "Submission: " + this.submission + "\n" +
                    "Marks scored: " + this.grades + "\n" +
                    "Graded by: " + this.instructor + "\n";
        } else {
            print = "Submission: " + this.submission + "\n";
        }

        return print;
    }
}
