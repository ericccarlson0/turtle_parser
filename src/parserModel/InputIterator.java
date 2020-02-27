package parserModel;

import parserModel.exceptions.CommandMissingListStartException;
import parserModel.exceptions.UnexpectedEndOfCommandException;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class InputIterator implements Iterator<String> {
    private List<String> myElements;
    private int index;

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
        return myElements.get(index++);
    }
}
