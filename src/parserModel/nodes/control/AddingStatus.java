package parserModel.nodes.control;

public enum AddingStatus {
    FETCH_HEADER_OPEN_BRACKET,
    FETCH_VARIABLE,
    FETCH_HEADER_NODES,
    FETCH_HEADER_CLOSE_BRACKET,
    FETCH_BODY_OPEN_BRACKET,
    FETCH_BODY;
}
