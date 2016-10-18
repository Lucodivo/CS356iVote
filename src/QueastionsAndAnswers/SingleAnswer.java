package QueastionsAndAnswers;

/**
 * A class that uses the QueastionsAndAnswers.Answer interface to develop an QueastionsAndAnswers.Answer form
 * for question that only allow one answer.
 *
 * @author Connor
 */
public class SingleAnswer implements Answer {
    /**
     * the only selected answer
     */
    private String answer;

    /**
     * Empty Constructor
     * returns a new QueastionsAndAnswers.SingleAnswer w/ empty String
     */
    protected SingleAnswer() {
        //initialize answer variable to avoid null pointer exception
        answer = new String();
    }

    /**
     * Copy Constructor
     * returns a new clone of the QueastionsAndAnswers.SingleAnswer argument
     *
     * @param sA the object to be cloned
     */
    public SingleAnswer(SingleAnswer sA) {
        this.answer = sA.answer;
    }

    /**
     * Getter
     *
     * @return users single answer
     */
    public String getAnswer(){
        return this.answer;
    }

    /**
     * replaces the old answer with the String argument
     *
     * @param answer the new chosen answer
     */
    @Override
    public void put(String answer) {
        this.answer = answer;
    }

    /**
     * check if a string has been put into this SingAnswer object
     * [used to prevent null pointer exceptions and ensure there is a single answer]
     *
     * @return true if the current answer String is empty
     */
    @Override
    public boolean isEmpty() {
        return answer.isEmpty();
    }
}
