import java.util.ArrayList;

abstract class StudentsBelowThreshold {
    public ArrayList<Student> getMarksBelowThreshold(double threshold, ArrayList<Student> students) {
        ArrayList<Student> students_below_threshold = new ArrayList<>();
        System.out.println("Getting the students below cut mark :");

        for (int i = 0; i < students.size(); i++) {
            if ((students.get(i).studentMarks.getTotalMarks()) < threshold) {
                students_below_threshold.add(students.get(i));
            }
        }

        return students_below_threshold;

    }
}
