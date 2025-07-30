public class Letra {
    private final char caractere;
    private final StatusLetra status;

    public Letra(char caractere, StatusLetra status) {
        this.caractere = Character.toUpperCase(caractere);
        this.status = status;
    }

    public char getCaractere() {
        return caractere;
    }

    public StatusLetra getStatus() {
        return status;
    }
}