import java.util.ArrayList;

/**
 * Created by Connor on 10/8/2016.
 */
public abstract class Question {
    private String questionString;
    protected ArrayList<String> candidateAnswers;
    protected int [] voteCount;

    public Question(String questionString, ArrayList<String> candidateAnswers){
        this.questionString = questionString;
        this.candidateAnswers = candidateAnswers;
        voteCount = new int[this.candidateAnswers.size()];
    }

    // getters
    public ArrayList<String> getCandidateAnswers() {
        return candidateAnswers;
    }

    public String getQuestionString() {
        return questionString;
    }

    public int[] getVoteCount() {
        return voteCount;
    }

    abstract public void submitVote(String userID, Answer answer);

    abstract public Answer createAnswer();

    abstract public void adjustVoteCount(String userID, Answer answers);
}