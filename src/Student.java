import java.util.HashSet;
import java.util.Vector;

/**
 * Created by Connor on 10/8/2016.
 */
public class Student {
    private String studentID;
    private Answer answer;

    public Student (String studentID, Answer answers) {
        this.studentID = studentID;
        this.answer = answers;
    }

    public String getStudentID() {
        return studentID;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswers(Answer answers) {
        this.answer = answers;
    }
}
