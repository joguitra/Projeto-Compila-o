package projeto.processor;

import projeto.Processor;
import projeto.Token;

import java.util.List;

import static projeto.ListHelper.useToken;

public class MenosProcessor implements Processor {
    @Override
    public boolean processor(List<Token> tokenList, List<Token> stack) {
        Token token = tokenList.get(0);
        switch (token) {
            case MENOS:
                stack = useToken(stack);
                System.out.println("Consumindo "+ token+ " Cadeia:"+tokenList + " Pilha:"+stack);
                return stack.get(0).processor(useToken(tokenList), stack);
            default:
                return false;
        }
    }
}
