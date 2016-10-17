/**
 * @author Connor
 */
public interface Answer {

    /**
     * @param answer
     */
    public void put(String answer);

    /**
     * @return boolean to help avoid null pointer exceptions and empty answers
     */
    public boolean isEmpty();

}