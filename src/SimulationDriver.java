import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Connor on 10/8/2016.
 */
public class SimulationDriver {
    private static int NUM_STUDENTS = 3;
    private static int NUM_CANDIDATE_ANSWERS = 6;
    private static int ANSWER_PERCENTAGE = 40;
    private static Random rand;

    public static void main(String args[]){
        rand = new Random();

        String questionString = new String("Wut?");
        ArrayList<String> candidateAnswers = new ArrayList<>();
        for(int i = 0; i < NUM_CANDIDATE_ANSWERS; i++){
            candidateAnswers.add(Character.toString((char)(i + 65)));
        }
        Question multAnsQuestion = new MultAnsQuestion(questionString, candidateAnswers);

        IVoteService iVoteService1 = new IVoteService(multAnsQuestion);

        ArrayList<Student> students1 = getMultRandStudents(multAnsQuestion);

        System.out.println("------- Multiple Answer Question Test -------");
        for(int i = 0; i < NUM_STUDENTS; i++){
            System.out.println("Submitting Student " + students1.get(i).getStudentID() + ":");
            iVoteService1.submitStudentVote(students1.get(i));
            iVoteService1.printVotes();
        }

        System.out.println();

        /*
        Initializing a SingAnsQuestion using the exact same
         */
        Question singAnsQuestion = new SingAnsQuestion(questionString, candidateAnswers);

        IVoteService iVoteService2 = new IVoteService(singAnsQuestion);

        ArrayList<Student> students2 = getMultRandStudents(singAnsQuestion);

        System.out.println("------- Single Answer Question Test -------");
        for(int i = 0; i < NUM_STUDENTS; i++){
            System.out.println("Submitting Student " + students2.get(i).getStudentID() + ":");
            iVoteService2.submitStudentVote(students2.get(i));
            iVoteService2.printVotes();
        }
    }

    private static ArrayList<Student> getMultRandStudents(Question question){
        ArrayList<Student> students = new ArrayList<Student>();

        for(int i = 0; i < NUM_STUDENTS; i++){
            String iStudentID = Integer.toString(i);
            Answer iStudentAnswers = question.createAnswer();

            for(int j = 0; j < NUM_CANDIDATE_ANSWERS; j++){
                if(rand.nextInt(100) < ANSWER_PERCENTAGE){
                    iStudentAnswers.put(question.getCandidateAnswers().get(j));
                }
            }
            if(iStudentAnswers.isEmpty()){
                iStudentAnswers.put(question.getCandidateAnswers().get(rand.nextInt(NUM_CANDIDATE_ANSWERS)));
            }
            students.add(new Student(iStudentID, iStudentAnswers));
        }

        return students;
    }


}
