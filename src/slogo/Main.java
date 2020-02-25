package slogo;

import parserModel.CommandParserNode;
import parserModel.TreeParser;

import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner kbReader = new Scanner(System.in);
        TreeParser parser = new TreeParser(new ArrayList<>());
        while(true){
            CommandParserNode node = parser.parseString(kbReader.nextLine());
            node.execute();
        }


    }
}
