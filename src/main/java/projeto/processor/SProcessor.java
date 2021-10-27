package projeto.processor;

import projeto.Processor;
import projeto.Token;

import java.util.ArrayList;
import java.util.List;

import static projeto.ListHelper.addStack;
import static projeto.ListHelper.useToken;

public class SProcessor implements Processor {
    @Override
    public boolean processor(List<Token> tokenList, List<Token> stack) {
        Token token = tokenList.get(0);
        List<Token> addStack = new ArrayList<>();
        switch (token) {
            case MAIS:
                addStack.add(Token.MAIS);
                addStack.add(Token.T);
                addStack.add(Token.S);
                System.out.println("Convertendo "+ stack.get(0)  + " em "+ addStack + " Cadeia:"+tokenList + " Pilha:"+stack);
                stack =  addStack(useToken(stack),(addStack));
                return stack.get(0).processor(tokenList, stack);
            case ABRIR_PARATESES:
                addStack.add(Token.MENOS);
                addStack.add(Token.T);
                addStack.add(Token.S);
                System.out.println("Convertendo "+ stack.get(0)  + " em "+ addStack+ " Cadeia:"+tokenList + " Pilha:"+stack);
                stack =  addStack(useToken(stack),(addStack));
                return stack.get(0).processor(tokenList, stack);
            default:
                System.out.println("Convertendo "+ stack.get(0) + " em Vazio" + " Cadeia:"+tokenList + " Pilha:"+stack);
                stack = useToken(stack);
                return stack.get(0).processor(tokenList, (stack));
        }
    }

}
