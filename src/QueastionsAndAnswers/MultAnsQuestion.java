package QueastionsAndAnswers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * QueastionsAndAnswers.MultAnsQuestion is a QueastionsAndAnswers.Question that uses the QueastionsAndAnswers.MultipleAnswer
 * class to accept user answers. This means that the question allows
 * users to have multiple answers for the same question.
 *
 * @author Connor
 */
public class MultAnsQuestion extends Question {
    /**
     * HashMap to match the user with their answers
     */
    private HashMap<String, MultipleAnswer> userVotes;

    /**
     * Constructor
     * Initializes private variables questionString, candidate answer to
     * users specified arguments.
     *
     * @param questionString the actual question
     * @param candidateAnswers the candidate answers given to user
     */
    public MultAnsQuestion(String questionString, ArrayList<String> candidateAnswers) {
        super(questionString, candidateAnswers);
        // Initializes userVotes to new HashMap.
        this.userVotes = new HashMap<String, MultipleAnswer>();
    }

    /**
     * Factory method to obtain a QueastionsAndAnswers.MultipleAnswer object
     *
     * @return a new QueastionsAndAnswers.MultipleAnswer object
     */
    public Answer createAnswer(){
        return (new MultipleAnswer());
    }

    /**
     * (Re)Submits and stores the user's vote into a HashMap.
     * Will update old answer with new answer.
     *
     * @param userID a users ID to be used as key in HashMap
     * @param answers a users QueastionsAndAnswers.Answer to be used as value in HashMap
     */
    @Override
    public void submitVote(String userID, Answer answers) {
        // adjust the vote count while we still have access to old votes
        adjustVoteCount(userID, answers);
        // update the user's QueastionsAndAnswers.Answer
        this.userVotes.put(userID, ((MultipleAnswer)answers).clone());
    }

    /**
     * Tracks the vote counts for candidate answers, based on the new
     * and old answer objects
     *
     * @param userID a users ID to be used as key in HashMap
     * @param answers a users QueastionsAndAnswers.Answer to be used as value in HashMap
     */
    protected void adjustVoteCount(String userID, Answer answers) {

        // initialize the old votes to null (might not exist)
        HashSet<String> oldVotes = null;
        // get user's new answers
        HashSet<String> newVotes = ((MultipleAnswer)answers).getAnswers();

        // check if the user has already submitted a vote
        boolean oldVotesExist = this.userVotes.get(userID) != null;
        // get user's old votes if they exist
        if(oldVotesExist){
            oldVotes = userVotes.get(userID).getAnswers();
        }

        // update vote count for each candidate answer
        for(int i = 0; i < this.candidateAnswers.size(); i++){
            // grab the current answer string
            String currentCandAns = this.candidateAnswers.get(i);
            // if there is an old answer that contains currents candAns
            if(oldVotes != null && oldVotes.contains(currentCandAns)){
                //decrement vote count
                voteCount[i]--;
            }
            // if the new answer contains current candAns
            if(newVotes.contains(currentCandAns)){
                // increment vote count
                voteCount[i]++;
            }
        }
    }
}