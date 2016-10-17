/**
 * A class that represents a student as a String representing some identification
 * and an Answer they have chosen for a specific question.
 *
 * @author Connor
 */
public class Student {
    /**
     * student's ID to be used as a key
     */
    private String studentID;
    /**
     * student's answer to be used as a submitted value
     */
    private Answer answer;

    /**
     * Constructor
     * Creates and returns a student using specified argument values
     *
     * @param studentID user ID to be used as a key
     * @param answers answer to be submitted to question
     */
    public Student (String studentID, Answer answers) {
        this.studentID = studentID;
        this.answer = answers;
    }

    // getters
    /**
     * Getter
     *
     * @return the student's ID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Getter
     *
     * @return the student's answer
     */
    public Answer getAnswer() {
        return answer;
    }

    /**
     * Setter
     *
     * @param answers the students new answer
     */
    public void setAnswers(Answer answers) {
        this.answer = answers;
    }
}
