import java.util.ArrayList;

/*AUTHOR Simran Kaur
 *ID 24297718
 */
abstract class UnitAnalysis {


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

        //return the array with a student where their total marks are below a threshold
        return students_below_threshold;

    }

    //method to get the top 5 high-scoring students
    public  ArrayList<Student> getTop5Students(ArrayList<Student> students) {

        // array list to store the top 5 students
        ArrayList<Student> top_5_students = new ArrayList<>();

        // The sort method.
        Student temp;

       //for loop to get a student and the next student and compare and swap them
        for (int i = 0; i < students.size(); i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).studentMarks.getTotalMarks() <(students.get(j).studentMarks.getTotalMarks())) {
                    temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }

        }

        //get the first five students of the ordered list of students who are the top performers
        int count = 0;
        // loop through the student's list to get the top 5
        for (int i = count; i < 5; i++) {

            //add each of the students in the top 5 into the top 5 list
            top_5_students.add(students.get(i));
        }

       // return the top 5 students
        return top_5_students;
    }


    //get the bottom 5 lowest performing students
    public  ArrayList<Student> getBottom5Students(ArrayList<Student> students) {

        ArrayList<Student> bottom_5_students = new ArrayList<>();
        // The sort method.
        Student temp;

        //for loop to get a student and the next student and compare and swap them
        for (int i = 0; i < students.size(); i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).studentMarks.getTotalMarks() <(students.get(j).studentMarks.getTotalMarks())) {
                    temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }

        }

        //set loop five counts below the student size to get the bottom 5 students
        int count = students.size() - 5;

        //loop through the ordered list of students
        for (int i = count; i < students.size(); i++) {

            //add the bottom students to the bottom_5_students array list
            bottom_5_students.add(students.get(i));

        }

        //return the list of bottom 5 lowest performing student
        return bottom_5_students;
    }

}
