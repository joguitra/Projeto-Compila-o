package projeto.processor;

import projeto.Processor;
import projeto.Token;

import java.util.ArrayList;
import java.util.List;

import static projeto.ListHelper.addStack;
import static projeto.ListHelper.useToken;

public class EProcessor implements Processor {
    @Override
    public boolean processor(List<Token> tokenList, List<Token> stack) {
        Token token = tokenList.get(0);
        switch (token) {
            case ID:
            case NUM:
            case ABRIR_PARATESES:
                List<Token> addStack = new ArrayList<>();
                addStack.add(Token.T);
                addStack.add(Token.S);
                System.out.println("Convertendo "+ stack.get(0)  + " em "+ addStack+ " Cadeia:"+tokenList + " Pilha:"+stack);
                stack = addStack(useToken(stack), (addStack));
                return stack.get(0).processor(tokenList,stack);
            default:
                return false;
        }
    }
}
