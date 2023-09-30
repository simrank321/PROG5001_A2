public class Student {
    String first_name,last_name,student_id ="";

    StudentMarks studentMarks;

    public Student(String first_name,
                   String last_name,
                   String student_id,
                   double assignment_1,
                   double assignment_2,
                   double assignment_3
    ) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.student_id = student_id;

        this.studentMarks = new StudentMarks(assignment_1,
                assignment_2,
                assignment_3);
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStudentID() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
}
