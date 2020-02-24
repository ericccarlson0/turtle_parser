package ParserModel.Commands;

import ParserModel.ParserNode;

public class TowardsNode extends ParserNode {
    private ParserNode myXNode;
    private ParserNode myYNode;

    public TowardsNode(){
        super();
    }

    @Override
    public void addNode(ParserNode node) {
        if(myXNode == null){
            myXNode = node;
        } else if(myYNode == null){
            myYNode = node;
        } else{
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public double execute() {
        double myXTowards = myXNode.execute();
        double myYTowards = myYNode.execute();
        System.out.println(toString());
        //TODO
        return 0; //FIXME
    }

    @Override
    public boolean isComplete() {
        return myYNode != null;
    }

    @Override
    public String toString(){
        return "Towards" + myXNode + " " + myYNode;
    }
}
