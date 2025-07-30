import java.util.Scanner;

public class Console {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarBoasVindas() {
        System.out.println("\n");
        System.out.println("Adivinhe o TERMO! Você possui 5 tentativas.");
        System.out.println("");
        System.out.println(CorTexto.verde("Verde: ") + "Letra pertence à palavra e está na posição correta");
        System.out.println(CorTexto.azul("Azul: ") + "Letra pertence à palavra, mas não está na posição correta");
        System.out.println("Branco: Letra não pertence à palavra");
        System.out.println("\n");
    }

    public void mostrarTentativas(Letra[][] tentativas) {
        for (Letra[] linha : tentativas) {
            for (Letra letra : linha) {
                if (letra == null) {
                    System.out.print("*");
                } else {
                    String letraFormatada = switch (letra.getStatus()) {
                        case CORRETA -> CorTexto.verde(String.valueOf(letra.getCaractere()));
                        case POSICAO_ERRADA -> CorTexto.azul(String.valueOf(letra.getCaractere()));
                        default -> String.valueOf(letra.getCaractere());
                    };
                    System.out.print(letraFormatada);
                }
            }
            System.out.println();
        }
    }

    public String lerTentativa() {
        System.out.print("\nDigite o termo: ");
        return scanner.nextLine().toUpperCase();
    }

    public void mostrarVitoria(String palavra) {
        System.out.println("\nParabéns. Você venceu!");
        System.out.println("O termo era " + palavra + "\n");
    }

    public void mostrarDerrota(String palavra) {
        System.out.println("\nVocê perdeu! O termo era " + palavra + "\n");
    }

    public void fechar() {
        scanner.close();
    }
}
