import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Connor on 10/16/2016.
 */
public class MultAnsQuestion extends Question {
    private HashMap<String, MultAnswer> userVotes;

    public MultAnsQuestion(String questionString, ArrayList<String> candidateAnswers) {
        super(questionString, candidateAnswers);
        this.userVotes = new HashMap<String, MultAnswer>();
    }

    public Answer createAnswer(){
        return new MultAnswer();
    }

    @Override
    public void submitVote(String userID, Answer answer) {
        adjustVoteCount(userID, answer);
        this.userVotes.put(userID, ((MultAnswer)answer).clone());
    }

    public void adjustVoteCount(String userID, Answer answers) {
        HashSet<String> oldVotes = null;
        HashSet<String> newVotes;
        boolean oldVotesExist = this.userVotes.get(userID) != null;

        if(oldVotesExist){
            oldVotes = userVotes.get(userID).getAnswers();
        }
        newVotes = ((MultAnswer)answers).getAnswers();

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

class MultAnswer implements Answer, Cloneable{
    private HashSet<String> answers;

    public MultAnswer(){
        this.answers = new HashSet<String>();
    }

    public HashSet<String> getAnswers() {
        return this.answers;
    }

    @Override
    public void put(String answer) {
        this.answers.add(answer);
    }

    @Override
    public boolean isEmpty() {
        return answers.isEmpty();
    }

    public MultAnswer clone() {
        try {
            return (MultAnswer) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.print("Can't clone MultAnswer");
            return this;
        }
    }
}