import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Token {
    private String token = "";
    private final static String TOKEN_VAULES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public Token(int numberOfChars){
        if(numberOfChars > 0){
            if(numberOfChars == 12){
                token = generate12CharToken();
            } else if(numberOfChars == 16){
                token = generate16CharToken();
            } else {
                System.out.println("Wrong number of characters");
            }
        } else {
            System.out.println("Unexpected number of characters");
        }
    }

    private static String generate12CharToken(){
        Random random = new Random();
        String tmpToken = "";
        for(int i = 0; i < 12; i++){
            tmpToken += TOKEN_VAULES.charAt(random.nextInt(TOKEN_VAULES.length()-1));
        }
        return tmpToken;
    }

    private static String generate16CharToken(){
        Random random = new Random();
        String tmpToken = "";
        for(int i = 0; i < 16; i++){
            tmpToken += TOKEN_VAULES.charAt(random.nextInt(TOKEN_VAULES.length()-1));
        }
        return tmpToken;
    }

    public void showToken(){
        if(this.token.length() == 12 || this.token.length() == 16)
            System.out.println(this.token);
    }

    public void saveToken(){
        if(this.token.length() == 12 || this.token.length() == 16){
            try {
                FileWriter fileWriter = new FileWriter("token.txt");
                fileWriter.write(token);
                fileWriter.close();
                System.out.println("Token saved to file token.txt");
            } catch (IOException e) {
                System.out.println("Unexpected error while saving token: " + e.getMessage());
            }
        }
    }
}
