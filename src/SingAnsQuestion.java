import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Connor on 10/16/2016.
 */
public class SingAnsQuestion extends Question {
    private HashMap<String,SingAnswer> userVotes;

    public SingAnsQuestion(String questionString, ArrayList<String> candidateAnswers) {
        super(questionString, candidateAnswers);
        userVotes = new HashMap<String,SingAnswer>();
    }

    public Answer createAnswer(){
        return new SingAnswer();
    }

    @Override
    public void submitVote(String userID, Answer answer) {
        adjustVoteCount(userID, answer);
        userVotes.put(userID, new SingAnswer((SingAnswer)answer));
    }

    @Override
    public void adjustVoteCount(String userID, Answer answers) {
        String oldVote = null;
        String newVote;
        boolean oldVoteExist = this.userVotes.get(userID) != null;

        if(oldVoteExist){
            oldVote = userVotes.get(userID).getAnswer();
        }
        newVote = ((SingAnswer)answers).getAnswer();

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

class SingAnswer implements Answer {
    private String answer;

    public SingAnswer() {
        answer = new String();
    }

    public SingAnswer(SingAnswer a) {
        this.answer = a.answer;
    }

    public String getAnswer(){
        return this.answer;
    }

    @Override
    public void put(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean isEmpty() {
        return answer.isEmpty();
    }
}