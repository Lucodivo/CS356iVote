/**
 * VoteService interface that allows for users to submit and print votes
 *
 * @author Connor
 */
public interface VoteService {

    /**
     * Submit a vote to question
     *
     * @param userID key to identify user
     * @param answer value of the user's answer
     */
    public void submitVote(String userID, Answer answer);

    /**
     * display the vote counts for the question
     */
    public void printVotes();

}
