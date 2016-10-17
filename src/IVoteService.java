import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Connor
 */
public class IVoteService implements VoteService {
    private Question question;
    private HashMap<String,HashSet<String>> studentVotes;

    /**
     *
     * @param question
     */
    public IVoteService (Question question) {
        this.question = question;
        this.studentVotes = new HashMap<>();
    }

    /**
     *
     * @param student
     */
    public void submitStudentVote(Student student){
        submitVote(student.getStudentID(), student.getAnswer());
    }

    /**
     *
     * @param userID
     * @param answer
     */
    public void submitVote(String userID, Answer answer) {
        this.question.submitVote(userID, answer);
    }

    /**
     *
     */
    public void printVotes(){
        int [] voteCount = question.getVoteCount();
        for(int i = 0; i < voteCount.length; i++){
            System.out.println(question.getCandidateAnswers().get(i) + " - " + voteCount[i]);
        }
    }
}
