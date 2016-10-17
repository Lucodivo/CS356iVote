/**
 * @author Connor
 */
public class SingleAnswer implements Answer {
    private String answer;

    /**
     *
     */
    public SingleAnswer() {
        answer = new String();
    }

    /**
     *
     * @param a
     */
    public SingleAnswer(SingleAnswer a) {
        this.answer = a.answer;
    }

    /**
     *
     * @return
     */
    public String getAnswer(){
        return this.answer;
    }

    /**
     *
     * @param answer
     */
    @Override
    public void put(String answer) {
        this.answer = answer;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return answer.isEmpty();
    }
}
