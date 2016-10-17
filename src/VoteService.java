import java.util.HashSet;

/**
 * @author Connor
 */
public interface VoteService {

    /**
     *
     * @param userID
     * @param answer
     */
    public void submitVote(String userID, Answer answer);

    /**
     *
     */
    public void printVotes();

}
