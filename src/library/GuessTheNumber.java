package library;

import controller.Input;

public class GuessTheNumber {
    int gn;
    int inputN;
    int attempts;

    public GuessTheNumber(int range, int attempts) {
        gn = (int) (Math.random() * range);
        this.attempts = attempts;
    }

    public void start() {
        System.out.println("Добро пожаловать в игру!");
        mainGame();
        System.out.println("До свидания!");
    }

    private void mainGame() {
        while(attempts >= 1) {
            System.out.printf("У вас осталось %d попыток\n", attempts--);
            inputN = Input.inputNumber("Введите число:");
            if (inputN < gn) {
                System.out.println("Число меньше загаданного");
            } else if (inputN > gn) {
                System.out.println("Число больше загаданного");
            } else {
                System.out.println("Вы выиграли!");
                attempts = 0;
            }
        }
    }
}
