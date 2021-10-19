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
        System.out.println("----------------\n");

        System.out.println("UnGraded Submissions");
        for(Assessment assessment : assessments){
            if(!assessment.getSubmission().isGraded()){
                System.out.println(assessment.getSubmission());
            }
        }
        System.out.println("----------------\n");
    }


    public String getName() {
        return name;
    }

    public ArrayList<Assessment> getAssessments() {
        return this.assessments;
    }

    public void setAssessments(Assessment assessment, String submission) {
      this.assessments.add(assessment);
      this.assessments.get(this.assessments.size()-1).setSubmission(submission);
    }

    public void addComment(ArrayList<Utility> util1, Comment comment){
        util1.add(comment);
    }

    @Override
    public void viewer(ArrayList<Utility> util){
        if(util.size() == 0) System.out.println("Nothing is added Here");
        else for(Utility utility : util){
                System.out.println(utility);
        }
    }

    @Override
    public boolean logout(){
        System.out.println("Logging out...");
        return false;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
