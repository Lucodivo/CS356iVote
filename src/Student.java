import java.util.HashSet;
import java.util.Vector;

/**
 * Created by Connor on 10/8/2016.
 */
public class Student {
    private String studentID;
    private HashSet<String> answers;

    public Student (String studentID, HashSet<String> answers) {
        this.studentID = studentID;
        this.answers = answers;
    }

    public String getStudentID() {
        return studentID;
    }

    public HashSet<String> getAnswers() {
        return answers;
    }

    public void setAnswers(HashSet<String> answers) {
        this.answers = answers;
    }
}
