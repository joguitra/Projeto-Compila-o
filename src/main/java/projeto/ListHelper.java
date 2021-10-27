package projeto;

import java.util.ArrayList;
import  java.util.List;
import java.util.Stack;

public class ListHelper {

    public static List<Token> useToken(List<Token> tokenList){
        if(tokenList.size()< 2){
            return new ArrayList<>();
        }
        return tokenList.subList(1,tokenList.size());
    }

    public static List<Token> addStack(List<Token> tokenList,List<Token> add){
        add.addAll(tokenList);
        return add;
    }

    public static List<Token> createStack(Token token){
        List<Token> stack = new ArrayList<>();
        stack.add(token);
        stack.add(Token.SIFRAO);
        return stack;
    }
}
