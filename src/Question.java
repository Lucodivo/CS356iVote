import java.util.ArrayList;

/**
 * @author Connor
 */
public abstract class Question {
    private String questionString;
    protected ArrayList<String> candidateAnswers;
    protected int [] voteCount;

    /**
     *
     * @param questionString
     * @param candidateAnswers
     */
    public Question(String questionString, ArrayList<String> candidateAnswers){
        this.questionString = questionString;
        this.candidateAnswers = candidateAnswers;
        voteCount = new int[this.candidateAnswers.size()];
    }

    // getters
    /**
     *
     * @return
     */
    public ArrayList<String> getCandidateAnswers() {
        return candidateAnswers;
    }

    /**
     *
     * @return
     */
    public String getQuestionString() {
        return questionString;
    }

    /**
     *
     * @return
     */
    public int[] getVoteCount() {
        return voteCount;
    }

    // abstract methods

    /**
     *
     * @param userID
     * @param answer
     */
    abstract public void submitVote(String userID, Answer answer);

    /**
     *
     * @return
     */
    abstract public Answer createAnswer();

    /**
     *
     * @param userID
     * @param answers
     */
    abstract public void adjustVoteCount(String userID, Answer answers);
}