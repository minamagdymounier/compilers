package Nodes;

import java.util.Queue;
import syntaxanalyzer.Token;

public class NEW_DASH_PART_I implements RootNode{

    private String LEFT_ROUND_B;
    private String RIGHT_ROUND_B;
    private String COMMA;
    private Identifier identifier;
    private Expression expression;
    private EOL eol;
    
    public NEW_DASH_PART_I() {
        LEFT_ROUND_B = "LEFT_ROUND_B";
        RIGHT_ROUND_B = "RIGHT_ROUND_B";
        COMMA = "COMMA";
    }

    @Override
    public boolean print(Queue<Token> tokens) {
        identifier = new Identifier();
        expression = new Expression();
        eol = new EOL();
        if(tokens.size()>=3)
        {
            if(identifier.print(tokens))
            {
                eol.print(tokens);
                if(tokens.peek().getToken().equals(LEFT_ROUND_B))
                {
                    System.out.print(tokens.poll().getValue()+" ");
                    if(expression.print(tokens))
                    {
                        eol.print(tokens);
                        while(tokens.peek().getToken().equals(COMMA))
                        {
                            System.out.print(tokens.poll().getValue()+" ");
                            eol.print(tokens);
                            expression.print(tokens);
                        }
                    }
                    eol.print(tokens);
                    if(tokens.peek().getToken().equals(RIGHT_ROUND_B))
                    {
                        System.out.print(tokens.poll().getValue()+" ");
                        return true;
                    }
                    
                }
            }
        }
        return false;
    }
    
}
