package Assignment_2;

import java.io.*;
import java.util.*;

class Course {

    private final ArrayList<Instructor> instructors = new ArrayList<>();
    private final ArrayList<Student> students = new ArrayList<>();

    private final ArrayList<Utility> assessments = new ArrayList<>();
    private final ArrayList<Utility> lectures = new ArrayList<>();
    private final ArrayList<Utility> comments = new ArrayList<>();

    void course() throws IOException {

        Reader.init(System.in);

        instructors.add(new Instructor());
        instructors.add(new Instructor());

        students.add(new Student());
        students.add(new Student());
        students.add(new Student());

        while(true){

            System.out.println("\nWelcome to Backpack\n" +
                    "\t 1. Enter as instructor\n" +
                    "\t 2. Enter as student\n" +
                    "\t 3. Exit");

            int role = Reader.nextint();

            if(role == 1){

                for(int i = 0; i < instructors.size(); i++){
                    System.out.println(i + "-" + instructors.get(i));
                }

                int instructor_no = Reader.nextint();
                Instructor instructor = instructors.get(instructor_no);

                boolean show_menu = true;
                while(show_menu){

                    System.out.println("Welcome " + instructor + "\n" +
                            "\t INSTRUCTOR MENU\n" +
                            "\t 1. Add class material\n" +
                            "\t 2. Add assessments\n" +
                            "\t 3. View lecture materials\n" +
                            "\t 4. View assessments\n" +
                            "\t 5. Grade assessments\n" +
                            "\t 6. Close assessment\n" +
                            "\t 7. View comments\n" +
                            "\t 8. Add comments\n" +
                            "\t 9. Logout");

                    int n2 = Reader.nextint();

                    if (n2 == 1) {
                        ArrayList<String> slides = new ArrayList<>();

                        System.out.println("\t 1. Add Lecture Slide\n" +
                                "\t 2. Add Lecture Video");
                        int choice = Reader.nextint();

                        if (choice == 1) {
                            System.out.print("Enter topic of slides: ");
                            String title = Reader.next();

                            System.out.print("Enter number of slides: ");
                            int count_slides = Reader.nextint();

                            System.out.println("Enter content of slides: ");
                            for (int i = 0; i < count_slides; i++) {
                                System.out.print("Content of slide " + (i + 1) + ": ");
                                slides.add(Reader.next());
                            }
                            instructor.adder(lectures, new Lecture(title, slides, instructor.getName()));

                        } else if (choice == 2) {
                            System.out.print("Enter topic of video: ");
                            String title = Reader.next();

                            System.out.print("Enter filename of video: ");
                            String filename = Reader.next();

                            if (!(filename.length() >= 5 && filename.endsWith(".mp4"))) {
                                System.out.println("Upload failed!You try to upload a file with wrong extension!");
                                continue;
                            }

                            instructor.adder(lectures, new Lecture(title, filename, instructor.getName()));
                        }
                    } else if (n2 == 2) {
                        String problem = null, type = null;
                        int max_marks = 1;
                        System.out.println("1. Add Assignment\n" +
                                "2. Add Quiz");

                        int choice = Reader.nextint();

                        if (choice == 1) {

                            System.out.print("Enter problem statement: ");
                            problem = Reader.next();

                            System.out.print("Enter max marks: ");
                            max_marks = Reader.nextint();
                            type = "assignment";

                        } else if (choice == 2) {
                            System.out.print("Enter quiz question: ");
                            problem = Reader.next();
                            type = "quiz";
                        }

                        instructor.adder(assessments, new Assessment(problem, max_marks, type));
                        assessmentsUtil.add(new Assessment(problem, max_marks, type));

                    } else if (n2 == 3) {
                        instructor.viewer(lectures);
                    } else if (n2 == 4) {
                        instructor.viewer(assessments);
                    } else if (n2 == 5) {
                        System.out.println("List of assessments\n");
                        instructor.viewer(assessments);

                        System.out.print("Enter ID of assessment to view submissions: ");
                        int choice = Reader.nextint();

                        System.out.println("Choose ID from these ungraded submissions");

                    } else if (n2 == 6) {
                        System.out.println("List of Open assessments: ");
                        instructor.viewer(assessments);

                        System.out.print("Enter id of assessment to close: ");
                        int assessment_chose = Reader.nextint();
                        int index;
                        for(Assessment assessment : assessmentsUtil){
                            if(assessment.getId() == assessment_chose){
                                index = assessmentsUtil.indexOf(assessment);
                            }
                        }

                        assessments.remove(index);
                        assessments_view.remove(index);

                    } else if (n2 == 7) {
                        instructor.viewer(comments);

                    } else if (n2 == 8) {
                        System.out.print("Enter comment: ");
                        String comment = Reader.next();
                        instructor.adder(comments, new Comment(comment, instructor.getName()));

                    } else if (n2 == 9) {
                        show_menu = false;
                    } else {
                        System.out.println("Invalid Input");
                    }
                }

            } else if (role ==2){

                for(int i = 0; i < students.size(); i++){
                    System.out.println(i + "-" + students.get(i));
                }
                int student_no = Reader.nextint();

                Student student = students.get(student_no);

                boolean show_menu = true;
                while(show_menu){

                    System.out.println("Welcome " + student + "\n" +
                            "\tSTUDENT MENU\n" +
                            "\t 1. View lecture materials\n" +
                            "\t 2. View assessments\n" +
                            "\t 3. Submit assessment\n" +
                            "\t 4. View grades\n" +
                            "\t 5. View comments\n" +
                            "\t 6. Add comments\n" +
                            "\t 7. Logout");

                    int n2 = Reader.nextint();

                    if (n2 == 1) {
                        student.viewer(lectures);
                    } else if (n2 == 2) {
                        student.viewer(assessments);

                    } else if (n2 == 3) {
                        System.out.println("Pending assessments");

                        for (int i = 0; i < assessments.size(); i++) {
                            for (Submission submission : student.getSubmissions()) {
                                if (!(submission.getId() == assessments.get(i).getId())) {
                                    System.out.println(assessments);
                                }
                            }
                        }

                        System.out.print("Enter ID of assessment: ");
                        int assessment_id = Reader.nextint();

                        for (Utility assessment : assessments) {
                            if (assessment.getId() == assessment_id) {
                                assessment.
                            }
                        }

                    } else if (n2 == 4) {
                        student.printSubmission();

                    } else if (n2 == 5) {
                        student.viewer(comments);

                    } else if (n2 == 6) {
                        System.out.print("Enter comment: ");
                        String comment = Reader.next();
                        student.addComment(comments, new Comment(comment, student.getName()));

                    } else if (n2 == 7) {
                        show_menu = false;

                    } else {
                        System.out.println("Invalid Input");
                    }
                }

            } else if(role==3) {
                break;

            } else {
                System.out.println("Invalid Input");
            }
        }
    }
}
