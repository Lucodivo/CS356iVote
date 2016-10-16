import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Connor on 10/8/2016.
 */
public class IVoteService implements VoteService {
    private Question question;
    private HashMap<String,HashSet<String>> studentVotes;

    public IVoteService (Question question) {
        this.question = question;
        this.studentVotes = new HashMap<>();
    }

    public void submitStudentVote(Student student){
        submitVote(student.getStudentID(), student.getAnswer());
    }

    public void submitVote(String userID, Answer answer) {
        this.question.submitVote(userID, answer);
    }

    public void printVotes(){
        int [] voteCount = question.getVoteCount();
        for(int i = 0; i < voteCount.length; i++){
            System.out.println(question.getCandidateAnswers().get(i) + " - " + voteCount[i]);
        }
    }
}
