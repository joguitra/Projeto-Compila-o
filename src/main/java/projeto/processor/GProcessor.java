package projeto.processor;

import projeto.Processor;
import projeto.Token;

import java.util.ArrayList;
import java.util.List;

import static projeto.ListHelper.addStack;
import static projeto.ListHelper.useToken;

public class GProcessor implements Processor {
    @Override
    public boolean processor(List<Token> tokenList, List<Token> stack) {
        Token token = tokenList.get(0);
        List<Token> addStack = new ArrayList<>();
        switch (token) {
            case VEZES:
                addStack.add(Token.VEZES);
                addStack.add(Token.F);
                addStack.add(Token.G);
                System.out.println("Convertendo "+ stack.get(0)  + " em "+ addStack+ " Cadeia:"+tokenList + " Pilha:"+stack);
                stack =  addStack(useToken(stack),(addStack));
                return stack.get(0).processor(tokenList, stack);
            case DIVIDIDO:
                addStack.add(Token.DIVIDIDO);
                addStack.add(Token.F);
                addStack.add(Token.G);
                System.out.println("Convertendo "+ stack.get(0)  + " em "+ addStack+ " Cadeia:"+tokenList + " Pilha:"+stack);
                stack =  addStack(useToken(stack),(addStack));
                return stack.get(0).processor(tokenList, stack);
            default:
                System.out.println("Convertendo "+ stack.get(0)  + " em Vazio"+ " Cadeia:"+tokenList + " Pilha:"+stack);
                stack = useToken(stack);
                return stack.get(0).processor(tokenList, (stack));
        }
    }
}


