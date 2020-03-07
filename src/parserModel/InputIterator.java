package parserModel;

import parserModel.exceptions.UnexpectedEndOfCommandException;
import java.util.Iterator;
import java.util.List;

/**
 * An iterator class that allows the user to iterate through all of the tokens in the input
 *
 * @author Mariusz Derezinski-Choo
 */
public class InputIterator implements Iterator<String> {
    private List<String> myElements;
    private int index;

    /**
     * Construct an InputIterator object
     * @param inputs a list of inputs that we want to iterate through
     */
    public InputIterator(List<String> inputs){
        myElements = List.copyOf(inputs);
    }

    @Override
    public boolean hasNext() {
        return index < myElements.size();
    }

    @Override
    public String next() {
        if (! hasNext()){
            throw new UnexpectedEndOfCommandException();
        }
        String ret = myElements.get(index);
        index++;
        return ret;
    }
}
