package Assignment_2;

import java.util.*;

public class Student implements Viewer {

    private final ArrayList<Assessment> assessments;
    private static int sub = 0;
    private final String name;

    Student(){
        this.name = "S" + sub;
        this.assessments = new ArrayList<>();
        sub++;
    }

    void printSubmission(){
        System.out.println("Graded Submissions");
        for(Assessment assessment : assessments){
            if(assessment.getSubmission().isGraded()){
                System.out.println(assessment.getSubmission());
            }
        }
        System.out.println("----------------");

        System.out.println("UnGraded Submissions");
        for(Assessment assessment : assessments){
            if(!assessment.getSubmission().isGraded()){
                System.out.println(assessment.getSubmission());
            }
        }

        System.out.println("----------------");
    }


    public String getName() {
        return name;
    }

    public ArrayList<Submission> getSubmissions() {
        return submissions;
    }

    public void addComment(ArrayList<Utility> util1, Comment comment){
        util1.add(comment);
    }

    @Override
    public void viewer(ArrayList<Utility> util){
        for(Utility utility : util){
            System.out.println(utility);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
