package QueastionsAndAnswers;

import java.util.HashSet;

/**
 * A class that uses the QueastionsAndAnswers.Answer interface to develop an QueastionsAndAnswers.Answer form
 * for questions that allow multiple answers
 *
 * @author Connor
 */
public class MultipleAnswer implements Answer, Cloneable{
    /**
     * a HashSet of chosen answers
     */
    private HashSet<String> answers;

    /**
     * Constructor
     * initializes an empty HashSet of answers
     */
    protected MultipleAnswer(){
        this.answers = new HashSet<String>();
    }

    /**
     * Add an answer to the list of chosen answers
     *
     * @param answer a chosen answer
     */
    @Override
    public void put(String answer) {
        this.answers.add(answer);
    }

    /**
     * Remove an answer from the current list of chosen answers
     *
     * @param answer an answer to be removed
     */
    public boolean remove(String answer) {
        return this.answers.remove(answer);
    }

    /**
     * User to check null pointer exception and ensure the user has at least one answer
     *
     * @return a boolean representing that the user has no answers
     */
    @Override
    public boolean isEmpty() {
        return answers.isEmpty();
    }

    /**
     * Getter
     *
     * @return the HashSet of chosen answers
     */
    public HashSet<String> getAnswers() {
        return this.answers;
    }

    /**
     * A function that will clone the current answer
     *
     * @return a new QueastionsAndAnswers.MultipleAnswer object with same data values (unique reference)
     */
    public MultipleAnswer clone() {
        // try to return a cloned version of the current object
        try {
            return (MultipleAnswer) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.print("Can't clone QueastionsAndAnswers.MultipleAnswer");
            return this;
        }
    }
}
