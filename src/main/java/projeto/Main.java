package projeto;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static projeto.ListHelper.createStack;
import static projeto.Token.*;

public class Main {

    public static void main(String [] args){
        String chain = startRead();
        List<Token> tokens = identifier(chain);
        boolean process = startProcessor(tokens);
        if(!process){
            System.out.println("ERROR");
        }
        System.out.println("PROCESSAMENTO FINALIZADO");
    }

    private static String startRead(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(System.getProperty("user.dir") + File.separator + "src/main/resources/leitura.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("valor");
    }

    private static List<Token> identifier(String tokens){
        List<Token> list = new ArrayList<>();
    String stringTokens = "";

        for(int i=0;i <= tokens.length()-1;i++){
            stringTokens += (String.valueOf(tokens.charAt(i)));
            Token token = Token.getFromToken(stringTokens);
            if(token != UNKNOWN){
                list.add(token);
                stringTokens = "";
            }
        }
        return list;
    }

    private static boolean startProcessor(List<Token> tokens){
      Token token = tokens.get(0);
      switch (token){
          case ID:
          case NUM:
          case ABRIR_PARATESES:
              return E.processor(tokens,createStack(E));
          case MAIS:
          case MENOS:
              return S.processor(tokens,createStack(S));
          case VEZES:
          case DIVIDIDO:
              return G.processor(tokens,createStack(G));
          default:
              return false;
      }
    }



}
