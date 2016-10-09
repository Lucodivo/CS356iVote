import java.util.Vector;

/**
 * Created by Connor on 10/8/2016.
 */
public class Question {

    private String question;
    private Vector<String> candidateAnswers;
    private boolean isMultAnswer;

    public Question(String question, Vector<String> candidateAnswers, boolean isMultAnswer){
        this.question = question;
        this.candidateAnswers = candidateAnswers;
        this.isMultAnswer = isMultAnswer;
    }

    // getters
    public Vector<String> getCandidateAnswers() {
        return candidateAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isMultAnswer() {
        return isMultAnswer;
    }
}