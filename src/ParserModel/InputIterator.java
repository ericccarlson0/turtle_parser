package ParserModel;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class InputIterator implements Iterator<String>{
    private List<String> myInputs;
    private int index;

    public InputIterator(List<String> inputs){
        myInputs = inputs;
    }

    @Override
    public boolean hasNext() {
        return index < myInputs.size();
    }

    @Override
    public String next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        return myInputs.get(index++);
    }
}
