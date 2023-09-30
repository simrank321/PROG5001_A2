import java.util.ArrayList;

/*AUTHOR Simran Kaur
 *ID 24297718
 */
abstract class StudentsBelowThreshold {


    public ArrayList<Student> getMarksBelowThreshold(double threshold, ArrayList<Student> students) {
       //array list to store students below the threshold
        ArrayList<Student> students_below_threshold = new ArrayList<>();
        System.out.println("Getting the students below threshold :");

        //loop through the students list
        for (int i = 0; i < students.size(); i++) {

            //check if the student's total mark is below the threshold
            if ((students.get(i).studentMarks.getTotalMarks()) < threshold) {

                //store the student in the students_below_threshold array if the student total mark is below the threshold mark
                students_below_threshold.add(students.get(i));
            }
        }

        //return the array with student where their total marks are below threshold
        return students_below_threshold;

    }
}
