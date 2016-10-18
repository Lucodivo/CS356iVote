package QueastionsAndAnswers;

import java.util.ArrayList;

/**
 * Abstract QueastionsAndAnswers.Question class that sets a framework to hold a question string, candidate answer
 * strings and integers representing vote counts.
 *
 * @author Connor
 */
public abstract class Question {
    /**
     * the actual question to be asked
     */
    private String questionString;
    /**
     * the potential answers given to the user
     */
    protected ArrayList<String> candidateAnswers;
    /**
     * the number of votes for each candidate answer
     */
    protected int [] voteCount;

    /**
     * Constructor
     * Creates a QueastionsAndAnswers.Question object with specified question and potential answers.
     *
     * @param questionString question to be asked
     * @param candidateAnswers potential answers
     */
    public Question(String questionString, ArrayList<String> candidateAnswers){
        // initialize all private variables
        this.questionString = questionString;
        this.candidateAnswers = candidateAnswers;
        voteCount = new int[this.candidateAnswers.size()];
    }

    // getters
    /**
     * Getter
     *
     * @return the candidate answers
     */
    public ArrayList<String> getCandidateAnswers() {
        return candidateAnswers;
    }

    /**
     * Getter
     *
     * @return the question being asked
     */
    public String getQuestionString() {
        return questionString;
    }

    /**
     * Getter
     *
     * @return the number of votes for each candidate answer
     */
    public int[] getVoteCount() {
        return voteCount;
    }

    // abstract methods

    /**
     * Abstract Method
     * Submits a vote to the QueastionsAndAnswers.Question object
     *
     * @param userID key to use when storing answer
     * @param answer value to use when storing answer
     */
    abstract public void submitVote(String userID, Answer answer);

    /**
     * Abstract Method
     * Factory method to ensure that each QueastionsAndAnswers.Question will return a new
     * object that uses the QueastionsAndAnswers.Answer interface.
     *
     * @return a new object that uses the QueastionsAndAnswers.Answer interface
     */
    abstract public Answer createAnswer();

    /**
     * Abstract Method
     * To adjust the vote counts accordingly
     *
     * @param userID key to use when retrieving old answer
     * @param answers the new answer to be accounted for
     */
    abstract protected void adjustVoteCount(String userID, Answer answers);
}