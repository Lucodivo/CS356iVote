import java.util.HashSet;

/**
 * Created by Connor on 10/15/2016.
 */
public interface VoteService {
    public void submitVote(String userID, Answer answer);
    public void printVotes();
}
