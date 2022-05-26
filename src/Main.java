import controller.Input;
import library.GuessTheNumber;

public class Main {
    public static void main(String[] args) {
        GuessTheNumber gn = new GuessTheNumber(10, 7);
        gn.start();
    }
}
