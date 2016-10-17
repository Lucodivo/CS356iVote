import java.util.HashSet;
import java.util.Vector;

/**
 * @author Connor
 */
public class Student {
    private String studentID;
    private Answer answer;

    /**
     *
     * @param studentID
     * @param answers
     */
    public Student (String studentID, Answer answers) {
        this.studentID = studentID;
        this.answer = answers;
    }

    /**
     *
     * @return
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     *
     * @return
     */
    public Answer getAnswer() {
        return answer;
    }

    /**
     *
     * @param answers
     */
    public void setAnswers(Answer answers) {
        this.answer = answers;
    }
}
