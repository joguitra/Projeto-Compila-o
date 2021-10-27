package projeto;

import projeto.processor.*;

import java.util.List;
import java.util.stream.Stream;

public enum Token {
    E("E",1,new EProcessor()),
    T("T",2,new TProcessor()),
    S("S",3,new SProcessor()),
    G("G",4,new GProcessor()),
    F("F",5,new FProcessor()),
    MAIS("+",6,new MaisProcessor()),
    MENOS("-",7,new MenosProcessor()),
    VEZES("*",8,new VezesProcessor()),
    DIVIDIDO("/",9,new DivididoProcessor()),
    ABRIR_PARATESES("(",10,new AbrirParetesesProcessor()),
    FECHA_PARETESES(")",11,new FecharParetesesProcessor()),
    ID("id",12,new IdProcessor()),
    NUM("num",13,new NumProcessor()),
    SIFRAO("$",14,new SifraoProcessor()),
    UNKNOWN("",15,null);

    private final String tokenString;
    private final Integer value;
    private final Processor processor;

    public boolean processor(List<Token> chain, List<Token> stack) {
        return processor.processor(chain,stack);
    }

    public String getTokenString() {
        return tokenString;
    }

    public Integer getValue() {
        return value;
    }

    public static Token getFromToken(String token) {
        return (Token) Stream.of(values()).filter((e) -> {
            return e.tokenString.equals(token);
        }).findFirst().orElse(UNKNOWN);
    }

    public static Token getFromValue(int value) {
        return (Token)Stream.of(values()).filter((e) -> {
            return e.value == value;
        }).findFirst().orElse(UNKNOWN);
    }

    private Token(String tokenString, Integer value,Processor processor){
        this.tokenString = tokenString;
        this.value = value;
        this.processor = processor;
    }
}
