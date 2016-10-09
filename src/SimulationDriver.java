import java.util.HashSet;
import java.util.Vector;

/**
 * Created by Connor on 10/8/2016.
 */
public class SimulationDriver {

    public static void main(String args[]){
        String qString = new String("Wut?");
        Vector<String> candidateAnswers = new Vector<>();
        candidateAnswers.add("A.");
        candidateAnswers.add("B.");
        candidateAnswers.add("C.");
        candidateAnswers.add("D.");
        candidateAnswers.add("E.");
        Question question = new Question(qString, candidateAnswers, true);

        IVoteService iVoteService = new IVoteService(question);

        String studentID = new String("12345");
        HashSet<String> studentAnswers = new HashSet<>();
        studentAnswers.add("A.");
        studentAnswers.add("C.");
        studentAnswers.add("E.");
        Student student = new Student(studentID, studentAnswers);

        if(iVoteService.submitStudentVote(student)){
            System.out.println("Submission successful");
        } else {
            System.out.println("Submission failed");
        }

        iVoteService.printVotes();

        studentAnswers.clear();
        studentAnswers.add("C.");
        studentAnswers.add("D.");
        studentAnswers.add("E.");

        if(iVoteService.submitStudentVote(student)){
            System.out.println("Submission successful");
        } else {
            System.out.println("Submission failed");
        }

        iVoteService.printVotes();

        String studentID2 = new String("67890");
        HashSet<String> studentAnswers2 = new HashSet<>();
        studentAnswers2.add("A.");
        studentAnswers2.add("B.");
        studentAnswers2.add("C.");
        Student student2 = new Student(studentID2, studentAnswers2);

        if(iVoteService.submitStudentVote(student2)){
            System.out.println("Submission successful");
        } else {
            System.out.println("Submission failed");
        }

        iVoteService.printVotes();
    }
}
