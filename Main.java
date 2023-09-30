import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*AUTHOR Simran Kaur
 *ID 24297718
 */
public class Main {

    //set file path for the excel file
    static String FILE_NAME = "./prog5001_students_grade_2022.csv";

    public static void main(String[] args) {

        //read excel file
        Unit unit = readExcelFile();

        //get the students list with their total marks
        ArrayList<Student> students = unit.getStudents();
        printStudents( students);



        //Get the students below threshold mark
        int threshold_mark = getThresholdMark();

        ArrayList<Student> studentsBelowThreshold = unit.getMarksBelowThreshold(threshold_mark, students);
        printStudentBelowThreshold(studentsBelowThreshold);


        //getting top 5 performing students
        ArrayList<Student> top5Students = unit.getTop5Students(students);
        printTop5Students(top5Students);


        //getting top 5 performing students
        ArrayList<Student> bottom5Students = unit.getBottom5Students(students);
        printBottom5Students(bottom5Students);


    }



//@TODO SET  MENU TO GET USER INPUT FOR MENU

    //GET THRESHOLD MARK FROM USER INPUT
    public static int getThresholdMark() {
        int user_input = 0;
        try {

            System.out.println("\n\nGet Marks Below a threshold ");
            System.out.println("======================================================");
            System.out.println("\n" +
                    "Enter the mark threshhold");

            Scanner sc = new Scanner(System.in);
            user_input = sc.nextInt();

        } catch (Exception e) {
            e.printStackTrace();
            getThresholdMark();
        }
        return user_input;
    }



   // print students
    public static void printStudents( ArrayList<Student> students) {
        for (Student student1 : students) {
            //concatenate the student data  to a string
            String student_results = "Student [" + student1.getFirstName() +
                    ", " + student1.getLastName() +
                    ", " + student1.getStudentID() +
                    ", [" + student1.studentMarks.getAssignment1() + ", " +
                    " " + student1.studentMarks.getAssignment2() + "," +
                    "  " + student1.studentMarks.getAssignment3() + "] Total = " + student1.studentMarks.getTotalMarks() + " ]";
            //print student details on command line
            System.out.println(student_results);
        }

    }

    //print Students Below Threshold
    public static void printStudentBelowThreshold(ArrayList<Student> studentsBelowThreshold){
        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println("Students Below Threshold");
        if (studentsBelowThreshold.size() > 0) {
            for (Student student1 : studentsBelowThreshold) {
                //concatenate the student data  to a string
                String student_results = "Student  [" + student1.getFirstName() +
                        ", " + student1.getLastName() +
                        ", " + student1.getStudentID() +
                        ", [" + student1.studentMarks.getAssignment1() + ", " +
                        " " + student1.studentMarks.getAssignment2() + "," +
                        "  " + student1.studentMarks.getAssignment3() + "] Total = " + student1.studentMarks.getTotalMarks() + " ]";
                //print student details on command line
                System.out.println(student_results);
            }

        } else {
            System.out.println("No Student Below Threshold");
        }
    }


   // print top 5 Students
    public static void printTop5Students(ArrayList<Student> top5Students) {
        System.out.println("\n\n+++++++++++++++++++++++++++++++++++\n");
        System.out.println("top 5 Students ");
        if (top5Students.size() > 0) {
            for (Student student1 : top5Students) {
                //concatenate the student data  to a string
                String student_results = "Student  [" + student1.getFirstName() +
                        ", " + student1.getLastName() +
                        ", " + student1.getStudentID() +
                        ", [" + student1.studentMarks.getAssignment1() + ", " +
                        " " + student1.studentMarks.getAssignment2() + "," +
                        "  " + student1.studentMarks.getAssignment3() + "] Total = " + student1.studentMarks.getTotalMarks() + " ]";
                //print student details on command line
                System.out.println(student_results);
            }

        } else {
            System.out.println("No top 5 students");
        }
    }



    //print bottom 5 Students
    private static void printBottom5Students(ArrayList<Student> bottom5Students) {
        System.out.println("\n\n+++++++++++++++++++++++++++++++++++\n");
        System.out.println("bottom 5 Students ");

        //loop through the bottom 5 students
        if (bottom5Students.size() > 0) {
            for (Student student1 : bottom5Students) {
                //concatenate the student data  to a string
                String student_results = "Student  [" + student1.getFirstName() +
                        ", " + student1.getLastName() +
                        ", " + student1.getStudentID() +
                        ", [" + student1.studentMarks.getAssignment1() + ", " +
                        " " + student1.studentMarks.getAssignment2() + "," +
                        "  " + student1.studentMarks.getAssignment3() + "] Total = " + student1.studentMarks.getTotalMarks() + " ]";
                //print student details on command line
                System.out.println(student_results);
            }

        } else {
            System.out.println("No bottom 5 students");
        }
    }



    //read  excel file
    public static Unit readExcelFile() {

        //set the line separator
        String line = "";

        //set the column separator
        String splitBy = ",";

        //set the line index to 1 for reading the first line
        int line_index = 1;

        Unit unit;
        String unit_title = null;
        ArrayList<Student> students = new ArrayList<>();

        try {
            //parsing the Excel CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));


            //loop through the BufferedReader class using while loop
            //returns the line separated by empty space
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {

                //check for comma separator to separate the columns of the read line and store as an array String
                String[] student = line.split(splitBy);


                if (line_index == 1) { // check if the line index is at the first line storing the unit title

                    //print unit title in command line
                    unit_title = student[0];
                    System.out.println(unit_title);
                } else if (line_index == 2) { // check if the line index is at the student fields line which is the second line

                    //concatenate the column titles to a string
                    String student_details = "Student Details [ " + student[0] +
                            ", " + student[1] +
                            ", " + student[2] +
                            "," + student[3] + ", " +
                            " " + student[4] + "," +
                            "  " + student[5] + "]";


                    //print student details on command line
                    System.out.println(student_details);

                } else if (line_index > 2) { // check if the line index is at the student data lines

                    //create a student class
                    Student student1 = new Student(student[1],
                            student[0],
                            student[2],
                            Double.parseDouble(student[3]),
                            Double.parseDouble(student[4]),
                            Double.parseDouble(student[5]));
                    student1.studentMarks.setTotalMarks();
                    students.add(student1);

                } else {
                    //print student  on command line
                    System.out.println(student);
                }

                //increment the line_index by 1;
                line_index += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        unit = new Unit(unit_title, students);

        return unit;
    }
}