package parserModel;

import parserModel.nodes.CommandFactory;
import parserModel.nodes.ParserNode;
import parserModel.nodes.SpecialCharacters;
import parserModel.nodes.control.GroupNode;
import parserModel.nodes.leafNodes.VariableNode;
import parserModel.nodes.leafNodes.ConstantNode;

public enum TokenType {
    Comment {
        @Override
        public ParserNode renderNode(String identifier, TurtleContext context) {
            return null;
        }
    },
    Constant {
        @Override
        public ParserNode renderNode(String identifier, TurtleContext context) {
            return new ConstantNode(Double.parseDouble(identifier));
        }
    },
    Variable {
        @Override
        public ParserNode renderNode(String identifier, TurtleContext context) {
            return new VariableNode(identifier);
        }
    },
    Command {
        @Override
        public ParserNode renderNode(String identifier, TurtleContext context) {
            return new CommandFactory().createCommand(identifier, context);
        }
    },
    ListStart {
        @Override
        public ParserNode renderNode(String identifier, TurtleContext context) {
            return SpecialCharacters.OPEN_BRACKET;
        }
    },
    ListEnd {
        @Override
        public ParserNode renderNode(String identifier, TurtleContext context) {
            return SpecialCharacters.CLOSE_BRACKET;
        }
    },
    GroupStart {
        @Override
        public ParserNode renderNode(String identifier, TurtleContext context) {
            return new GroupNode();
        }
    },
    GroupEnd {
        @Override
        public ParserNode renderNode(String identifier, TurtleContext context) {
            return SpecialCharacters.GROUP_END;
        }
    };

    public abstract ParserNode renderNode(String identifier, TurtleContext context);
}
