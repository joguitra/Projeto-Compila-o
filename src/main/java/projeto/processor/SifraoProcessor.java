package projeto.processor;

import projeto.Processor;
import projeto.Token;

import java.util.List;

import static projeto.ListHelper.useToken;

public class SifraoProcessor implements Processor {
    @Override
    public boolean processor(List<Token> tokenList, List<Token> stack) {
        Token token = tokenList.get(0);
        switch (token) {
            case SIFRAO:
                System.out.println("Consumindo "+ token + " Cadeia:"+tokenList + " Pilha:"+stack);
                return true;
            default:
                return false;
        }
    }
}
