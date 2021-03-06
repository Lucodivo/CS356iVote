package QueastionsAndAnswers;

/**
 * Interface for QueastionsAndAnswers.Answer classes
 * Main objective is to hold String(s) that represent user's answers
 *
 * @author Connor
 */
public interface Answer {

    /**
     * This method places a String into the answer
     *
     * @param answer a user's chosen answer
     */
    public void put(String answer);

    /**
     * This method is used to help null pointer exceptions and to
     * ensure that the user has input at least one answer
     *
     * @return true if the user currently has an answer
     */
    public boolean isEmpty();

}