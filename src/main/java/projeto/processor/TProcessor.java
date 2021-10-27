package projeto.processor;

import projeto.Processor;
import projeto.Token;

import java.util.ArrayList;
import java.util.List;

import static projeto.ListHelper.addStack;
import static projeto.ListHelper.useToken;

public class TProcessor implements Processor {
    @Override
    public boolean processor(List<Token> tokenList, List<Token> stack) {
        Token token = tokenList.get(0);;
        List<Token> addStack = new ArrayList<>();
        switch (token) {
            case ID:
            case NUM:
            case MAIS:
                addStack.add(Token.F);
                addStack.add(Token.G);
                System.out.println("Convertendo "+ stack.get(0)  + " em "+ addStack+ " Cadeia:"+tokenList + " Pilha:"+stack);
                stack =addStack(useToken(stack), (addStack));
                return stack.get(0).processor(tokenList, stack);
            default:
                return false;
        }
    }
}
