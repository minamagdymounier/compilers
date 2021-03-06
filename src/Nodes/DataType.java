package Nodes;

import static java.lang.System.exit;
import java.util.Queue;
import syntaxanalyzer.Token;

public class DataType implements RootNode{
    private String dataType;
    private String[] types = new String[]{"INT" , "FLOAT" , "CHAR" , "BOOLEAN" , "STRING"};
    private EOL eol;
    
    public DataType() {
    }
    
    private boolean checkType(String type)
    {
        for(int i=0 ; i<this.types.length ; i++){
            if(type.equals(this.types[i])){ 
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean print(Queue<Token> tokens) {
        eol = new EOL();
        eol.print(tokens);
        dataType = tokens.peek().getToken();
        if(checkType(dataType))
        {
            System.out.print(tokens.poll().getValue()+" ");
            return true;
        }
        return false;
    }
   
}
