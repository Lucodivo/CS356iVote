import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Connor
 */
public class SingAnsQuestion extends Question {
    private HashMap<String, SingleAnswer> userVotes;

    /**
     *
     * @param questionString
     * @param candidateAnswers
     */
    public SingAnsQuestion(String questionString, ArrayList<String> candidateAnswers) {
        super(questionString, candidateAnswers);
        userVotes = new HashMap<String, SingleAnswer>();
    }

    /**
     *
     * @return
     */
    public Answer createAnswer(){
        return new SingleAnswer();
    }

    /**
     *
     * @param userID
     * @param answer
     */
    @Override
    public void submitVote(String userID, Answer answer) {
        adjustVoteCount(userID, answer);
        userVotes.put(userID, new SingleAnswer((SingleAnswer)answer));
    }

    /**
     *
     * @param userID
     * @param answers
     */
    @Override
    public void adjustVoteCount(String userID, Answer answers) {
        String oldVote = null;
        String newVote;
        boolean oldVoteExist = this.userVotes.get(userID) != null;

        if(oldVoteExist){
            oldVote = userVotes.get(userID).getAnswer();
        }
        newVote = ((SingleAnswer)answers).getAnswer();

        for(int i = 0; i < this.candidateAnswers.size(); i++){
            String currentCandAns = this.candidateAnswers.get(i);
            if(oldVote != null && oldVote == currentCandAns){
                voteCount[i]--;
            }
            if(newVote == currentCandAns){
                voteCount[i]++;
            }
        }
    }
}

/**
 *
 */
