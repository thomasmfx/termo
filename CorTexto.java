public class CorTexto {
    public static final String resetarCor = "\u001B[0m";
    public static final String verde = "\u001B[32m";
    public static final String azul = "\u001B[34m";

    public static String azul(String texto) {
        return azul + texto + resetarCor;
    }

    public static String verde(String texto) {
        return verde + texto + resetarCor;
    }
}
