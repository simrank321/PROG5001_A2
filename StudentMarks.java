/*AUTHOR Simran Kaur
 *ID 24297718
 */
public class StudentMarks{
    double assignment_1,assignment_2,assignment_3 =0.0;
    double total_marks =0.0;

    public StudentMarks( double assignment_1, double assignment_2, double assignment_3) {
        this.assignment_1 = assignment_1;
        this.assignment_2 = assignment_2;
        this.assignment_3 = assignment_3;
    }

    public double getTotalMarks() {
        return total_marks;
    }

    public void setTotalMarks() {
        double total_marks  =  this.assignment_1 + this.assignment_2+ this.assignment_3;
        this.total_marks = total_marks;
    }

    public double getAssignment1() {
        return assignment_1;
    }

    public void setAssignment1(double assignment_1) {
        this.assignment_1 = assignment_1;
    }

    public double getAssignment2() {
        return assignment_2;
    }

    public void setAssignment2(double assignment_2) {
        this.assignment_2 = assignment_2;
    }

    public double getAssignment3() {
        return assignment_3;
    }

    public void setAssignment3(double assignment_3) {
        this.assignment_3 = assignment_3;
    }

    public double calculateTotalMarks(){
        this.total_marks  =  this.assignment_1 + this.assignment_2+ this.assignment_3;
        return  this.total_marks;
    }
}
