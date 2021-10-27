package projeto.processor;

import projeto.Processor;
import projeto.Token;

import java.util.ArrayList;
import java.util.List;

import static projeto.ListHelper.addStack;
import static projeto.ListHelper.useToken;

public class FProcessor implements Processor {
    @Override
    public boolean processor(List<Token> tokenList, List<Token> stack) {
        Token token = tokenList.get(0);
        List<Token> addStack = new ArrayList<>();
        switch (token) {
            case ID:
                addStack.add(Token.ID);
                System.out.println("Convertendo "+ stack.get(0)  + " em "+ addStack+ " Cadeia:"+tokenList + " Pilha:"+stack);
                stack =addStack(useToken(stack), (addStack));
                return stack.get(0).processor(tokenList, stack);
            case NUM:
                addStack.add(Token.NUM);
                System.out.println("Convertendo "+ stack.get(0)  + " em "+ addStack+ " Cadeia:"+tokenList + " Pilha:"+stack);
                stack =addStack(useToken(stack), (addStack));
                return stack.get(0).processor(tokenList, stack);
            case ABRIR_PARATESES:
                addStack.add(Token.ABRIR_PARATESES);
                addStack.add(Token.E);
                addStack.add(Token.FECHA_PARETESES);
                System.out.println("Convertendo "+ stack.get(0)  + " em "+ addStack+ " Cadeia:"+tokenList + " Pilha:"+stack);
                stack =addStack(useToken(stack), (addStack));
                return stack.get(0).processor(tokenList, stack);
            default:
                return false;
        }
    }
}
