import java.util.ArrayList;
import java.util.HashMap;

/**
 * SingAnsQuestion is a Question that uses the SingleAnswer
 * class to accept a users' answers. This means that the question allows
 * users to only have one answer for the same question.
 *
 * @author Connor
 */
public class SingAnsQuestion extends Question {
    /**
     * HashMap used to match a user with their answer
     */
    private HashMap<String, SingleAnswer> userVotes;

    /**
     * Constructor
     * Initializes private variables questionString, candidate answer to
     * users specified arguments.
     *
     * @param questionString the actual question
     * @param candidateAnswers the candidate answers given to user
     */
    public SingAnsQuestion(String questionString, ArrayList<String> candidateAnswers) {
        super(questionString, candidateAnswers);
        // initialize userVotes HashMap
        userVotes = new HashMap<String, SingleAnswer>();
    }

    /**
     * Factory method to obtain a SingleAnswer object
     *
     * @return a new SingleAnswer object
     */
    public Answer createAnswer(){
        return new SingleAnswer();
    }

    /**
     * (Re)Submits and stores the user's vote into a HashMap.
     * Will update old answer with new answer.
     *
     * @param userID a users ID to be used as key in HashMap
     * @param answer a users Answer to be used as value in HashMap
     */
    @Override
    public void submitVote(String userID, Answer answer) {
        adjustVoteCount(userID, answer);
        userVotes.put(userID, new SingleAnswer((SingleAnswer)answer));
    }

    /**
     * Tracks the vote counts for candidate answers, based on the new
     * and old answer objects
     *
     * @param userID a users ID to be used as key in HashMap
     * @param answers a users Answer to be used as value in HashMap
     */
    @Override
    protected void adjustVoteCount(String userID, Answer answers) {
        // old and new votes to user in adjustments
        String oldVote = null;
        String newVote;

        // check if the user has voted before
        boolean oldVoteExist = this.userVotes.get(userID) != null;
        // if there is an old vote, retrieve it
        if(oldVoteExist){
            oldVote = userVotes.get(userID).getAnswer();
        }
        // retrieve new vote string
        newVote = ((SingleAnswer)answers).getAnswer();

        // for all of the candidate answers
        for(int i = 0; i < this.candidateAnswers.size(); i++){
            // get the current candidate answer
            String currentCandAns = this.candidateAnswers.get(i);
            // if there is an old vote and it is equal to canAnswer, decrement count
            if(oldVote != null && oldVote.equals(currentCandAns)){
                voteCount[i]--;
            }
            // if the new vote is equal to canAnswer, increment count
            if(newVote.equals(currentCandAns)){
                voteCount[i]++;
            }
        }
    }
}
