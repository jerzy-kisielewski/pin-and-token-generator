import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Pin {
    private String pin = "";
    public Pin(int numberOfDigits) {
        if(numberOfDigits > 0){
            if(numberOfDigits == 4){
                pin = generate4DigitsPin();
            } else if(numberOfDigits == 6){
                pin = generate6DigitsPin();
            } else {
                System.out.println("Wrong number of digits");
            }
        } else {
            System.out.println("Unexpected number of digits");
        }
    }

    private static String generate4DigitsPin(){
        String tmpPin = "";
        Random random = new Random();
        String pinValues = "0123456789";
        for(int i = 0; i < 4; i++){
            tmpPin += pinValues.charAt(random.nextInt(pinValues.length()-1));
        }
        return tmpPin;
    }

    private static String generate6DigitsPin(){
        String tmpPin = "";
        Random random = new Random();
        String pinValues = "0123456789";
        for(int i = 0; i < 6; i++){
            tmpPin += pinValues.charAt(random.nextInt(pinValues.length()-1));
        }
        return tmpPin;
    }

    public void showPin(){
        if(this.pin.length() == 4 || this.pin.length() == 6)
            System.out.println(this.pin);
    }

    public void savePin(){
        if(this.pin.length() == 4 || this.pin.length() == 6){
            try {
                FileWriter fileWriter = new FileWriter("pin.txt");
                fileWriter.write(this.pin);
                fileWriter.close();
                System.out.println("Pin saved to file pin.txt");
            } catch (IOException e) {
                System.out.println("Unexpected error while saving pin: " + e.getMessage());
            }
        }
    }
}
