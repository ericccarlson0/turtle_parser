package ParserModel;

public class RepeatParserNode extends ParserNode {
    private ParserNode myTimesNode;
    private ParserNode executeNode;
    private int mytimes;

    @Override
    public void addNode(ParserNode node) {
        //System.out.println("adding node" + node);
        if(myTimesNode == null){
            myTimesNode = node;
        } else if(executeNode == null){
            executeNode = node;
        }
        //FIXME: throw exception
    }

    @Override
    public double execute() {
        while(mytimes < myTimesNode.execute()){
            executeNode.execute();
            mytimes ++;
        }
        return 0;
    }

    @Override
    public int numberOfNodes() {
        return 2;
    }
}
