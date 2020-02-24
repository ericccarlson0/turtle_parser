package ParserModel;

public class MoveAction extends ParserNode{
    private ParserNode myLength;

    public MoveAction(){

    }

    @Override
    public double execute() {
        System.out.println(toString());
        return 0; //FIXME
    }

    @Override
    public int numberOfNodes() {
        return 1;
    }

    @Override
    public void addNode(ParserNode node) {
        myLength = node;
    }

    @Override
    public String toString(){
        return "Moving forward " + myLength.execute();
    }
}
