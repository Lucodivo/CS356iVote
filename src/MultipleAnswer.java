import java.util.HashSet;

/**
 * @author Connor
 */
public class MultipleAnswer implements Answer, Cloneable{
    private HashSet<String> answers;

    /**
     *
     */
    public MultipleAnswer(){
        this.answers = new HashSet<String>();
    }

    /**
     *
     * @return
     */
    public HashSet<String> getAnswers() {
        return this.answers;
    }

    /**
     *
     * @param answer
     */
    @Override
    public void put(String answer) {
        this.answers.add(answer);
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return answers.isEmpty();
    }

    /**
     *
     * @return
     */
    public MultipleAnswer clone() {
        try {
            return (MultipleAnswer) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.print("Can't clone MultipleAnswer");
            return this;
        }
    }
}
