public class Main {

    private static String token = "";
    private String pin = "";

    public static void main(String[] args) {
        Token token = new Token(12);
        Pin pin = new Pin(4);
        token.showToken();
        token.saveToken();
        pin.showPin();
        pin.savePin();
    }
}