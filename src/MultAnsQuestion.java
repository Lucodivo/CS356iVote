import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Connor
 */
public class MultAnsQuestion extends Question {
    private HashMap<String, MultipleAnswer> userVotes;

    /**
     *
     * @param questionString
     * @param candidateAnswers
     */
    public MultAnsQuestion(String questionString, ArrayList<String> candidateAnswers) {
        super(questionString, candidateAnswers);
        this.userVotes = new HashMap<String, MultipleAnswer>();
    }

    /**
     *
     * @return
     */
    public Answer createAnswer(){
        return new MultipleAnswer();
    }

    /**
     *
     * @param userID
     * @param answer
     */
    @Override
    public void submitVote(String userID, Answer answer) {
        adjustVoteCount(userID, answer);
        this.userVotes.put(userID, ((MultipleAnswer)answer).clone());
    }

    /**
     *
     * @param userID
     * @param answers
     */
    public void adjustVoteCount(String userID, Answer answers) {
        HashSet<String> oldVotes = null;
        HashSet<String> newVotes;
        boolean oldVotesExist = this.userVotes.get(userID) != null;

        if(oldVotesExist){
            oldVotes = userVotes.get(userID).getAnswers();
        }
        newVotes = ((MultipleAnswer)answers).getAnswers();

        for(int i = 0; i < this.candidateAnswers.size(); i++){
            String currentCandAns = this.candidateAnswers.get(i);
            if(oldVotes != null && oldVotes.contains(currentCandAns)){
                voteCount[i]--;
            }
            if(newVotes.contains(currentCandAns)){
                voteCount[i]++;
            }
        }
    }
}