import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Connor on 10/8/2016.
 */
public class IVoteService {
    private Question question;
    private HashMap<String,HashSet<String>> studentVotes;
    private int[] votes;

    public IVoteService (Question question) {
        this.question = question;
        this.studentVotes = new HashMap<>();
        this.votes = new int[question.getCandidateAnswers().size()];
    }

    public boolean submitStudentVote(Student student){
        int numAnswers = student.getAnswers().size();

        if(numAnswers == 0) {
            return false;
        }

        if(numAnswers > 1 && !question.isMultAnswer()){
            return false;
        }

        if(studentVotes.containsKey(student.getStudentID())){
            HashSet<String> outdatedVotes = studentVotes.get(student.getStudentID());
            removeVote(outdatedVotes);
        }

        studentVotes.put(student.getStudentID(), new HashSet<>(student.getAnswers()));
        addVote(student);
        return true;
    }

    private void removeVote(HashSet<String> votes){
        for(int i = 0; i < this.votes.length; i++){
            if(votes.contains(question.getCandidateAnswers().elementAt(i))){
                this.votes[i]--;
            }
        }
    }

    private void addVote(Student student){
        for(int i = 0; i < question.getCandidateAnswers().size(); i++){
            if(student.getAnswers().contains(question.getCandidateAnswers().elementAt(i))){
                votes[i]++;
            }
        }
    }

    public void printVotes(){
        for(int i = 0; i < votes.length; i++){
            System.out.println(question.getCandidateAnswers().get(i) + " - " + votes[i]);
        }
    }
}
