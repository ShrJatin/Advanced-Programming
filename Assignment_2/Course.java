package Assignment_2;

import java.io.*;
import java.util.*;

class Course implements Utility{

    private final ArrayList<Instructor> instructors = new ArrayList<>();
    private final ArrayList<Student> students = new ArrayList<>();

    private final ArrayList<Utility> assessments = new ArrayList<>();
    private final ArrayList<Utility> lectures = new ArrayList<>();
    private final ArrayList<Utility> comments = new ArrayList<>();

    boolean isNumeric(String s){

        for(int i = 0; i < s.length(); i++){
            char check = s.charAt(i);
            if(check < '0' || check > '9'){
                return true;
            }
        }
        return false;
    }

    void course() throws IOException, CloneNotSupportedException {

        Reader.init();

        instructors.add(new Instructor());
        instructors.add(new Instructor());

        students.add(new Student());
        students.add(new Student());
        students.add(new Student());

        label:
        while(true){

            System.out.println("\nWelcome to Backpack\n" +
                    "\t 1. Enter as instructor\n" +
                    "\t 2. Enter as student\n" +
                    "\t 3. Exit");

            String role = Reader.next();

            switch (role) {
                case "1": {
                    System.out.println("Instructors:");
                    for (int i = 0; i < instructors.size(); i++) {
                        System.out.println(i + "-" + instructors.get(i));
                    }

                    String _instructor_no = Reader.next();
                    if(isNumeric(_instructor_no) || Integer.parseInt(_instructor_no) >= instructors.size() || Integer.parseInt(_instructor_no) < 0){
                        System.out.println("Invalid Instructor ID");
                        continue;
                    }
                    int instructor_no = Integer.parseInt(_instructor_no);

                    Instructor instructor = instructors.get(instructor_no);

                    boolean show_menu = true;
                    while (show_menu) {

                        System.out.println("\nWelcome " + instructor + "\n" +
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

                        String n2 = Reader.next();

                        switch (n2) {
                            case "1": {
                                ArrayList<String> slides = new ArrayList<>();

                                System.out.println("\t 1. Add Lecture Slide\n" +
                                        "\t 2. Add Lecture Video");
                                String choice = Reader.next();

                                if (choice.equals("1")) {
                                    System.out.print("Enter topic of slides: ");
                                    String title = Reader.next();

                                    System.out.print("Enter number of slides: ");
                                    String temp = Reader.next();
                                    if (isNumeric(temp)) {
                                        System.out.println("Number of slides can ony be an Integer");
                                        continue;
                                    }
                                    int count_slides = Integer.parseInt(temp);

                                    System.out.println("Enter content of slides: ");
                                    for (int i = 0; i < count_slides; i++) {
                                        System.out.print("Content of slide " + (i + 1) + ": ");
                                        slides.add(Reader.next());
                                    }
                                    instructor.adder(lectures, new Lecture(title, slides, instructor.getName()));


                                } else if (choice.equals("2")) {
                                    System.out.print("Enter topic of video: ");
                                    String title = Reader.next();

                                    System.out.print("Enter filename of video: ");
                                    String filename = Reader.next();

                                    if (!(filename.length() >= 5 && filename.endsWith(".mp4"))) {
                                        System.out.println("Upload failed!You try to upload a file with wrong extension!");
                                        continue;
                                    }

                                    instructor.adder(lectures, new Lecture(title, filename, instructor.getName()));
                                } else {
                                    System.out.println("Error: Invalid option selection for addition of class material");
                                    continue;
                                }

                                break;
                            }
                            case "2": {
                                String problem = null, type = null;
                                int max_marks = 1;
                                System.out.println("\t 1. Add Assignment\n" +
                                        "\t 2. Add Quiz");

                                String choice = Reader.next();

                                if (choice.equals("1")) {

                                    System.out.print("Enter problem statement: ");
                                    problem = Reader.next();

                                    System.out.print("Enter max marks: ");
                                    String temp = Reader.next();
                                    if (isNumeric(temp)) {
                                        System.out.println("Max Marks can ony be an Integer");
                                        continue;
                                    }
                                    max_marks = Integer.parseInt(temp);
                                    type = "assignment";

                                } else if (choice.equals("2")) {
                                    System.out.print("Enter quiz question: ");
                                    problem = Reader.next();
                                    type = "quiz";
                                } else {
                                    System.out.println("Error: Invalid option selection for addition of class material");
                                }

                                assessments.add(new Assessment(problem, max_marks, type));


                                break;
                            }
                            case "3":
                                instructor.viewer(lectures);

                                break;
                            case "4":
                                instructor.viewer(assessments);

                                break;
                            case "5":
                                Assessment utilAssessment = null;
                                Assessment studentAssessment = null;

                                System.out.println("List of assessments");
                                instructor.viewer(assessments);

                                System.out.print("Enter ID of assessment to view submissions: ");
                                String temp = Reader.next();
                                if (isNumeric(temp)) {
                                    System.out.println("ID of assessment can ony be an Integer");
                                    continue;
                                }
                                int assessment_id = Integer.parseInt(temp);

                                for (Utility _assessment : assessments) {
                                    if (((Assessment) _assessment).getId() == assessment_id) {
                                        utilAssessment = (Assessment) ((Assessment) _assessment).clone();
                                        break;
                                    }
                                }

                                if (utilAssessment == null) {
                                    System.out.println("Invalid Id of Assessment");
                                    continue;
                                }

                                System.out.println("Choose ID from these ungraded submissions");
                                int opt = 0;
                                for (Student _student : students) {
                                    for (Assessment _assessment : _student.getAssessments())
                                        if (_assessment.getId() == utilAssessment.getId() && !_assessment.getSubmission().isGraded()) {
                                            System.out.println(opt + ". " + _student);
                                            opt++;
                                        }
                                }
                                if (opt == 0) {
                                    System.out.println("No ungraded Assessment left");
                                    continue;
                                }

                                temp = Reader.next();
                                if (isNumeric(temp)) {
                                    System.out.println("ID of assessment can ony be an Integer");
                                    continue;
                                }
                                int student_id = Integer.parseInt(temp);

                                opt = 0;
                                for (Student _student : students) {
                                    for (Assessment _assessment : _student.getAssessments()) {
                                        if (_assessment.getId() == utilAssessment.getId() && !_assessment.getSubmission().isGraded()) {
                                            if (opt == student_id) {
                                                studentAssessment = _assessment;
                                            }
                                            opt++;
                                            break;
                                        }
                                    }
                                }

                                if (studentAssessment == null) {
                                    System.out.println("Invalid Id of Student");
                                    continue;
                                }

                                System.out.print("Submission:\n" +
                                        "Submission: " + studentAssessment.getSubmission().getSubmission() + "\n" +
                                        "-------------------------------\n" +
                                        "Max Marks: " + studentAssessment.getMax_marks() + "\n" +
                                        "Marks scored: ");

                                temp = Reader.next();
                                if (isNumeric(temp)) {
                                    System.out.println("Marks can ony be an Integer");
                                    continue;
                                }
                                int marks_scored = Integer.parseInt(temp);

                                if (marks_scored > studentAssessment.getMax_marks()) {
                                    System.out.println("You cant give extra marks.");
                                    continue;
                                }
                                studentAssessment.getSubmission().setGrading(marks_scored, instructor.getName());

                                break;
                            case "6":
                                System.out.println("List of Open assessments: ");
                                instructor.viewer(assessments);

                                System.out.print("Enter id of assessment to close: ");
                                int assessment_chose = Reader.nextint();

                                assessments.removeIf(assessment -> ((Assessment) assessment).getId() == assessment_chose);

                                break;
                            case "7":
                                instructor.viewer(comments);

                                break;
                            case "8":
                                System.out.print("Enter comment: ");
                                String comment = Reader.next();
                                instructor.adder(comments, new Comment(comment, instructor.getName()));

                                break;
                            case "9":
                                show_menu = instructor.logout();
                                break;
                            default:
                                System.out.println("Invalid Input");
                                break;
                        }
                    }

                    break;
                }
                case "2": {
                    System.out.println("Students:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(i + "-" + students.get(i));
                    }

                    String temp = Reader.next();
                    if(isNumeric(temp) || Integer.parseInt(temp) >= students.size() || Integer.parseInt(temp) < 0){
                        System.out.println("Invalid Students ID");
                        continue;
                    }
                    Student student = students.get(Integer.parseInt(temp));

                    boolean show_menu = true;
                    while (show_menu) {

                        System.out.println("\nWelcome " + student + "\n" +
                                "\t STUDENT MENU\n" +
                                "\t 1. View lecture materials\n" +
                                "\t 2. View assessments\n" +
                                "\t 3. Submit assessment\n" +
                                "\t 4. View grades\n" +
                                "\t 5. View comments\n" +
                                "\t 6. Add comments\n" +
                                "\t 7. Logout");

                        String n2 = Reader.next();

                        switch (n2) {
                            case "1":
                                student.viewer(lectures);

                                break;
                            case "2":
                                student.viewer(assessments);

                                break;
                            case "3":
                                Assessment assessment = null;
                                String answer = "";

                                System.out.println("Pending Assessments");
                                boolean pending = false;
                                for (Utility _assessment : assessments) {
                                    boolean notFound = true;
                                    for (Assessment studentAssessment : student.getAssessments()) {
                                        if (((Assessment) _assessment).getId() == studentAssessment.getId()) {
                                            notFound = false;
                                            break;
                                        }
                                    }
                                    if (notFound) {
                                        System.out.println(_assessment);
                                        pending = true;
                                    }
                                }

                                if (!pending) {
                                    System.out.println("No pending Assessment on you");
                                    continue;
                                }

                                System.out.print("Enter ID of assessment: ");

                                temp = Reader.next();
                                if (isNumeric(temp)) {
                                    System.out.println("Assessment ID can ony be an Integer");
                                    continue;
                                }
                                int assessment_id = Integer.parseInt(temp);

                                boolean submitted = false;
                                for (Assessment studentAssessment : student.getAssessments()) {
                                    if (studentAssessment.getId() == assessment_id) {
                                        submitted = true;
                                        break;
                                    }
                                }

                                for (Utility _assessment : assessments) {
                                    if (((Assessment) _assessment).getId() == assessment_id) {
                                        assessment = (Assessment) ((Assessment) _assessment).clone();
                                    }
                                }

                                if (submitted || assessment == null) {
                                    System.out.println("Invalid Id of Assessment");
                                    continue;
                                }

                                if (assessment.getType().equals("quiz")) {
                                    System.out.print(assessment.getProblem() + ": ");
                                    answer = Reader.next();

                                } else if (assessment.getType().equals("assignment")) {
                                    System.out.print("Enter filename of assignment: ");
                                    answer = Reader.next();

                                    if (!(answer.length() >= 5 && answer.endsWith(".zip"))) {
                                        System.out.println("Upload failed!You try to upload a file with wrong extension!");
                                        continue;
                                    }
                                }

                                if (answer.equals("")) {
                                    System.out.println("Please provide a Valid Answer");
                                    continue;
                                }

                                student.setAssessments(assessment, answer);

                                break;
                            case "4":
                                student.printSubmission();

                                break;
                            case "5":
                                student.viewer(comments);

                                break;
                            case "6":
                                System.out.print("Enter comment: ");
                                String comment = Reader.next();
                                student.addComment(comments, new Comment(comment, student.getName()));

                                break;
                            case "7":
                                show_menu = student.logout();

                                break;
                            default:
                                System.out.println("Invalid Input");
                                break;
                        }
                    }

                    break;
                }
                case "3":
                    System.out.println("Exiting...\n-------------------------------------------------------------------------------------------------");
                    break label;

                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
}
