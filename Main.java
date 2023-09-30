import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*AUTHOR Simran Kaur
 *ID 24297718
 */
public class Main {

    //set file path for the excel file
    static String FILE_NAME = "./prog5001_students_grade_2022.csv";

    public static void main(String [] args){

   Unit unit =  readExcelFile();

   ArrayList<Student> students = unit.getStudents();

        for (Student student1 :students ) {
            //concatenate the student data  to a string
            String student_results = "Student [" + student1.getFirstName() +
                    ", " + student1.getLastName() +
                    ", " +  student1.getStudentID() +
                    ", [" +  student1.studentMarks.getAssignment1() + ", " +
                    " " + student1.studentMarks.getAssignment2() + "," +
                    "  " + student1.studentMarks.getAssignment3() + "] Total = "+ student1.studentMarks.getTotalMarks()+" ]";
            //print student details on command line
            System.out.println(student_results);
        }




    }

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

        unit = new Unit(unit_title,students);

        return  unit;
    }
}