package VoteServices;

import QueastionsAndAnswers.Answer;
import QueastionsAndAnswers.Question;

/**
 * This class currently holds a single question and handles submissions
 * of answers to the question. It will also display the current answers
 * in a neat format.
 *
 * @author Connor
 */
public class IVoteService implements VoteService {
    /**
     * the single QueastionsAndAnswers.Question used by VoteServices.IVoteService class
     */
    private Question question;

    /**
     * Constructor
     * set's private question to argument
     *
     * @param question QueastionsAndAnswers.Question object that will be accepting answers through
     *                 the VoteServices.IVoteService
     */
    public IVoteService (Question question) {
        this.question = question;
    }

    /**
     * User-friendly version of the submitVote function.
     *
     * @param student student who has answers to be (re)submitted
     */
    public void submitStudentVote(Student student){
        submitVote(student.getStudentID(), student.getAnswer());
    }

    /**
     * Submits a vote to the private QueastionsAndAnswers.Question object using a userID as
     * a HashMap key and QueastionsAndAnswers.Answer as the value
     *
     * @param userID a unique String to used to hash the user's votes
     * @param answer an QueastionsAndAnswers.Answer object to submit to the question
     */
    public void submitVote(String userID, Answer answer) {
        this.question.submitVote(userID, answer);
    }

    /**
     *  Prints the answers and amount of votes for the private
     *  QueastionsAndAnswers.Question object
     */
    public void printVotes(){
        // get the vote count from question object
        int [] voteCount = question.getVoteCount();
        // print out all candidate answers and their vote count
        for(int i = 0; i < voteCount.length; i++){
            System.out.println(question.getCandidateAnswers().get(i) + " - " + voteCount[i]);
        }
    }
}
