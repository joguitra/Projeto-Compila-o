package projeto.processor;

import projeto.Processor;
import projeto.Token;

import java.util.ArrayList;
import java.util.List;

import static projeto.ListHelper.addStack;
import static projeto.ListHelper.useToken;

public class DivididoProcessor implements Processor {
    @Override
    public boolean processor(List<Token> tokenList, List<Token> stack) {
        Token token = tokenList.get(0);
        switch (token) {
            case DIVIDIDO:
                System.out.println("Consumindo "+ token+ " Cadeia:"+tokenList + " Pilha:"+stack);
                stack = useToken(stack);
                return stack.get(0).processor(useToken(tokenList), stack);
            default:
                return false;
        }
    }
}

