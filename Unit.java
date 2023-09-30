import java.util.ArrayList;

/*AUTHOR Simran Kaur
 *ID 24297718
 */
public class Unit {
    String unit_title = "";
    ArrayList<Student> students;

    public Unit(String unit_title, ArrayList<Student> students) {
        this.unit_title = unit_title;
        this.students = students;
    }

    public String getUnitTitle() {
        return unit_title;
    }

    public void setUnitTitle(String unit_title) {
        this.unit_title = unit_title;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }


}