import java.util.ArrayList;
import java.util.Random;

/**
 * The main driver of the project. Creates two different questions that use the same question string and candidate
 * answer strings. The difference is that one question accepts multiple answers, while the other does not. This class
 * also creates random students that enter in answers to each of the questions.
 *
 * @author Connor
 */
public class SimulationDriver {
    /**
     * number of random students to be generated
     */
    private static int NUM_STUDENTS = 3;
    /**
     * number of candidate answers
     */
    private static int NUM_CANDIDATE_ANSWERS = 6;
    /**
     * the percentage that a student will choose any specified answer
     */
    private static int ANSWER_PERCENTAGE = 33;
    /**
     * used to allow students to choose random answers
     */
    private static Random rand;

    /**
     * main function (read class description)
     *
     * @param args does not currently use any string arguments
     */
    public static void main(String args[]){
        // initialize Random variable
        rand = new Random();

        // create the string representing question that is going to be used
        String questionString = new String("Wut?");
        // create an array list of candidate answers
        // [ex: if NUM_CANDIDATE_ANSWERS is 7, we will get {A,B,C,D,E,F,G}]
        ArrayList<String> candidateAnswers = new ArrayList<>();
        for(int i = 0; i < NUM_CANDIDATE_ANSWERS; i++){
            candidateAnswers.add(Character.toString((char)(i + 65)));
        }

        // use the question string and candidateAnswers to create a MultAnsQuestion
        Question multAnsQuestion = new MultAnsQuestion(questionString, candidateAnswers);

        // create an IVoteService that uses that MultAnsQuestion
        IVoteService iVoteService1 = new IVoteService(multAnsQuestion);

        // get random students for multAnsQuestion
        ArrayList<Student> students1 = getMultRandStudents(multAnsQuestion);

        // submit each student to the multAnsQuestion and print results
        System.out.println("------- Multiple Answer Question Test -------");
        for(int i = 0; i < NUM_STUDENTS; i++){
            System.out.println("Submitting Student " + students1.get(i).getStudentID() + ":");
            iVoteService1.submitStudentVote(students1.get(i));
            iVoteService1.printVotes();
        }

        // create a line separation for better separation of tests
        System.out.println();

        // use the same question string and candidateAnswers to create a SingAnsQuestion
        Question singAnsQuestion = new SingAnsQuestion(questionString, candidateAnswers);

        // create an IVoteService that uses that SingAnsQuestion
        IVoteService iVoteService2 = new IVoteService(singAnsQuestion);

        // get random students for singAnsQuestion
        ArrayList<Student> students2 = getMultRandStudents(singAnsQuestion);

        // submit each student to the singAnsQuestion and print results
        System.out.println("------- Single Answer Question Test -------");
        for(int i = 0; i < NUM_STUDENTS; i++){
            System.out.println("Submitting Student " + students2.get(i).getStudentID() + ":");
            iVoteService2.submitStudentVote(students2.get(i));
            iVoteService2.printVotes();
        }
    }

    /**
     * A function that takes a Question and returns NUM_STUDENTS amount of students with
     * random answers corresponding to the Question argument
     * [!!!IMPORTANT!!! The way this function is written uses polymorphism, but is imperfectly
     * random when it comes to SingleAnswer questions. It will favor later questions. (ex: F has a greater
     * likelihood than A)]
     *
     * @param question the Question in which the students will have answers for
     * @return students with randomly generated answers
     */
    private static ArrayList<Student> getMultRandStudents(Question question){
        // array of new students
        ArrayList<Student> students = new ArrayList<Student>();

        // create a NUM_STUDENTS amount of students
        for(int i = 0; i < NUM_STUDENTS; i++){
            // initialize their IDs climbing from 0
            String iStudentID = Integer.toString(i);
            // create an answer for the argument question
            Answer iStudentAnswers = question.createAnswer();

            // for all of the available answers
            for(int j = 0; j < NUM_CANDIDATE_ANSWERS; j++){
                // have the student choose an answer with ANSWER_PERCENTAGE chance
                if(rand.nextInt(100) < ANSWER_PERCENTAGE){
                    iStudentAnswers.put(question.getCandidateAnswers().get(j));
                }
            }
            // choose a random answer if ANSWER_PERCENTAGE lead to none being chosen
            if(iStudentAnswers.isEmpty()){
                iStudentAnswers.put(question.getCandidateAnswers().get(rand.nextInt(NUM_CANDIDATE_ANSWERS)));
            }
            // and student to ArrayList of students
            students.add(new Student(iStudentID, iStudentAnswers));
        }

        // return the random students
        return students;
    }


}
