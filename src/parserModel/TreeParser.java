package parserModel;

import execution.Executable;
import javafx.collections.ObservableList;
import parserModel.exceptions.ParsingException;
import parserModel.nodes.ParserNode;
import parserModel.nodes.leafNodes.VariableNode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TreeParser {
    private TokenAnalyzer myTokenAnalyzer;
    private TurtleContext myContext;

    public TreeParser() {
        myContext = new TurtleContext();
        myContext.setWorkingTurtle(0);
        myTokenAnalyzer = new TokenAnalyzer();
    }

    public ObservableList<Double> getActiveTurtles(){
        return  myContext.myActiveTurtles();
    }

    public Iterator<Executable> saveFile(String input, String filePath){
        try {
            FileWriter out = new FileWriter(filePath);
            out.write(input);
            out.close();
        } catch (IOException e) {
            //TODO
        }
        return null;
    }

    public ObservableList<String> observableVariables(){
        return myContext.getData().observableVariableList();
    }
    public ObservableList<String> observableCommands() {
        return myContext.getData().observableCommandList();
    }

    public void setLanguage(String language) {
        myTokenAnalyzer.setLanguage(language);
    }

    public List<Double> getTurtleSummary (double id) {
        return myContext.getData().turtleData(id).getSummaryList();
    }

    public Iterator<Executable> parseString(String input) throws ParsingException {
        String[] inputLines = input.split("\n");
        List<String> inputElements = new ArrayList<>();
        for (String line : inputLines){
            int poundIndex;
            if ((poundIndex = line.indexOf('#')) != -1) {
                line = line.substring(0, poundIndex);
            }
            inputElements.addAll(Arrays.asList(line.split(" ")));
        }
        for (int i = 0; i < inputElements.size(); i++) {
            if (inputElements.get(i).equals("")) {
                inputElements.remove(i);
                i--;
            }
        }
        parseList(inputElements);
        Iterator<Executable> result = myContext.getExecutables();
        myContext.resetQueue();
        return result;
    }

    private void parseList(List<String> input) {
        InputIterator iterator = new InputIterator(input);
        try {
            while (iterator.hasNext()) {
                ParserNode returner = getParserNode(iterator);
                returner.execute(myContext);
            }
        } catch (ParsingException e){
            e.renderNode().execute(myContext);
        }
    }

    private ParserNode getParserNode(InputIterator iterator) {
        String nextElement = iterator.next();
        ParserNode root = myTokenAnalyzer.fetchNode(nextElement, myContext);
        while (!root.isComplete()) {
            ParserNode next = getParserNode(iterator);
            if (next instanceof VariableNode) {
                root.addVariable((VariableNode) next);
            } else {
                root.addNode(next);
            }
        }
        return root;
    }


}
