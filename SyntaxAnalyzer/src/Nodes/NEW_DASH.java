package Nodes;

import java.util.Queue;
import syntaxanalyzer.Token;

public class NEW_DASH implements RootNode{

    @Override
    public boolean print(Queue<Token> tokens) {
        return false;
    }
    
}
