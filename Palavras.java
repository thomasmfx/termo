import java.util.Random;

public class Palavras {
    private static final String[] PALAVRAS = {
        "TERMO", "CINCO", "SOLTO", "CORDA", "MASSA",
        "TESTE", "SAUDE", "CESTA", "JOGAR", "LIVRO"  
    };

    private final Random gerador = new Random();

    public String sortear() {
        int index = gerador.nextInt(PALAVRAS.length);
        return PALAVRAS[index];
    }
}
