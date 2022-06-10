package lib.GBSeminarsStudy.seminars;

public class HanoiTower {
    public static void main() {
        doHanoi("1", "2", "3", 3);
    }
    private static void doHanoi(String initial, String middle, String last, int count) {
        if(count > 1) doHanoi(initial, last, middle, count-1);
        System.out.printf("%s -> %s\n", initial, last);
        if(count > 1) doHanoi(middle, initial, last, count-1);
    }
}
