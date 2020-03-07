package parserModel;

import parserModel.nodes.CommandFactory;
import parserModel.nodes.ParserNode;
import parserModel.nodes.leafNodes.SpecialCharacters;
import parserModel.nodes.control.GroupNode;
import parserModel.nodes.leafNodes.VariableNode;
import parserModel.nodes.leafNodes.ConstantNode;

/**
 * An enum of generic types of tokens that render different ParserNodes, based on the
 * TokenType that is found from the token
 *
 * @author Mariusz Derezinski-Choo
 */
public enum TokenType {
    Comment {
        @Override
        public ParserNode renderNode(String identifier, String textEntered, TurtleContext context) {
            return null;
        }
    },
    Constant {
        @Override
        public ParserNode renderNode(String identifier, String textEntered,  TurtleContext context) {
            return new ConstantNode(Double.parseDouble(identifier));
        }
    },
    Variable {
        @Override
        public ParserNode renderNode(String identifier, String textEntered,  TurtleContext context) {
            return new VariableNode(identifier);
        }
    },
    Command {
        @Override
        public ParserNode renderNode(String identifier, String textEntered,  TurtleContext context) {
            return new CommandFactory().createCommand(identifier, textEntered, context);
        }
    },
    ListStart {
        @Override
        public ParserNode renderNode(String identifier, String textEntered,  TurtleContext context) {
            return SpecialCharacters.OPEN_BRACKET;
        }
    },
    ListEnd {
        @Override
        public ParserNode renderNode(String identifier, String textEntered,  TurtleContext context) {
            return SpecialCharacters.CLOSE_BRACKET;
        }
    },
    GroupStart {
        @Override
        public ParserNode renderNode(String identifier, String textEntered,  TurtleContext context) {
            return new GroupNode();
        }
    },
    GroupEnd {
        @Override
        public ParserNode renderNode(String identifier, String textEntered,  TurtleContext context) {
            return SpecialCharacters.GROUP_END;
        }
    };

    /**
     * render a node from the given enum based on the identifying string that the TokenAnalyzer fetched
     * @param identifier the identifier that is found using regexs
     * @param textEntered the literal text entered by the user
     * @param context the context that this Parser is operating within
     * @return a ParserNode generated from the identifier
     */
    public abstract ParserNode renderNode(String identifier, String textEntered,  TurtleContext context);
}
