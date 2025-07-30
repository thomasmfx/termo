public class Termo {
    private static final int MAX_TENTATIVAS = 6;
    private static final int TAMANHO_PALAVRA = 5;

    private final String palavraSecreta;
    private final Letra[][] tentativas;
    private int tentativaAtual;
    private final Console console;

    public Termo() {
        this.console = new Console();
        Palavras palavras = new Palavras();
        this.palavraSecreta = palavras.sortear();
        this.tentativas = new Letra[MAX_TENTATIVAS][TAMANHO_PALAVRA];
        this.tentativaAtual = 0;
    }

    public void jogar() {
        console.mostrarBoasVindas();

        while (tentativaAtual < MAX_TENTATIVAS) {
            console.mostrarTentativas(tentativas);
            String palpite = console.lerTentativa();
            System.out.println("\n");

            if (palpite.length() != TAMANHO_PALAVRA) {
                System.out.println("Palavra deve ter 5 letras. Tente novamente.");
                continue;
            }

            avaliar(palpite);

            if (isVitoria(palpite)) {
                console.mostrarTentativas(tentativas);
                console.mostrarVitoria(palavraSecreta);
                console.fechar();
                return;
            }

            tentativaAtual++;
        }

        console.mostrarTentativas(tentativas);
        console.mostrarDerrota(palavraSecreta);
        console.fechar();
    }

    private void avaliar(String palpite) {
        for (int i = 0; i < TAMANHO_PALAVRA; i++) {
            char letraPalpite = palpite.charAt(i);
            StatusLetra status;

            if (letraPalpite == palavraSecreta.charAt(i)) {
                status = StatusLetra.CORRETA;
            } else if (palavraSecreta.contains(String.valueOf(letraPalpite))) {
                status = StatusLetra.POSICAO_ERRADA;
            } else {
                status = StatusLetra.INEXISTENTE;
            }
            tentativas[tentativaAtual][i] = new Letra(letraPalpite, status);
        }
    }

    private boolean isVitoria(String palpite) {
        return palpite.equals(palavraSecreta);
    }
}