package lib.GBSeminarsStudy;

import controller.Solution;

import java.util.ArrayList;
import java.util.List;

public class AlgoritmsCollectionLibrary {

    ArrayList<Solution> tc = new ArrayList<>();

//    public void run(String idTask) {
//        switch (idTask) {
//            case "1.1":
//                Program01();
//                break;
//            case "1.2":
//                Program02();
//                break;
//            default: break;
//        }
//    }

    private double pow(double a, double b) {
        double res = 1;
        // a^0 = 1, 0^b = 0, 1^b = 1, a^1 = a
        if (a == 1 || b == 0) {
            return 1;
        }

        if (a == 0) {
            return 0;
        }

        if (b < 0) {
            a = 1 / a;
            b = -b;
        }

        for (int i = 0; i < b; i++) {
            res *= a;
        }

        return res;
    }

    public static void change(int a, int b, int c, int d, String s) {
        if (c == 0 || c == 1)
            return;
        if (d == 0)
            return;
        if (a > b)
            return;
        if (a == b)
            System.out.println(s);

        change(a * c, b, c, d, s + "*" + c);
        change(a + d, b, c, d, s + "+" + d);
    }

    public static void change2(int n, int k, StringBuilder sb) {
        if (n == 0) {
            System.out.println(sb);
            sb.setLength(sb.length() - 1);
            return;
        }
        for (int i = 0; i < k; i++) {
            sb.append(i);
            change2(n - 1, k, sb);
        }
        if (!sb.isEmpty()) sb.setLength(sb.length() - 1);
    }

    // 1) Напишите метод, который принимает на вход строку (String) и определяет
    // является ли строка палиндромом (возвращает boolean значение)
    public static boolean isPalidrome(String str) {
        int last = str.length();
        int mid = last / 2;
        for (int i = 0; i < mid; i++) {
            if (str.charAt(i) != str.charAt(last - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    //  2) Напишите метод, который сжимает строку. Пример: вход aaaabbbcdd, результат - a4b3cd2
    public static String RCA(String str) {
        StringBuilder sb = new StringBuilder();
        char t = str.charAt(0);
        int counter = 1;
        for (int i = 1; i < str.length(); i++) {
            if (t != str.charAt(i)) {
                sb.append(t);
                if (counter != 1)
                    sb.append(counter);
                t = str.charAt(i);
                counter = 0;
            }
            counter++;
        }
        sb.append(String.format("%c%d", t, counter));
        return sb.toString();
    }

    // Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
    // например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
    // Предложить хотя бы одно решение или сообщить, что его нет.
    public static void restore(String str) {
        List<Integer> questionFind = new ArrayList<>();
        char[] elemOfExpr = str.replace(" ", "").toCharArray();
        for (int i = 0; i < elemOfExpr.length; i++) {
            if (elemOfExpr[i] == '+' || elemOfExpr[i] == '=') {
                elemOfExpr[i] = '-';
            }
            if (elemOfExpr[i] == '?') {
                questionFind.add(i);
            }
        }

        List<List<Integer>> combL = combinationIterative1(9, questionFind.size());

        for (int i = 0; i < combL.size(); i++) {

            List<Integer> tmp = combL.get(i);
            for (int j = 0; j < questionFind.size(); j++) {
                elemOfExpr[questionFind.get(j)] = (char) (tmp.get(j) + 48);
            }

            StringBuilder sb = new StringBuilder();
            List<Integer> tmpLi = new ArrayList<>();
            for (int j = 0; j < elemOfExpr.length; j++) {
                if (elemOfExpr[j] == '-') {
                    tmpLi.add(Integer.valueOf(String.valueOf(sb)));
                    sb = new StringBuilder();
                } else
                    sb.append(elemOfExpr[j]);
            }
            tmpLi.add(Integer.valueOf(String.valueOf(sb)));

            int firstN = tmpLi.get(0);
            int secondN = tmpLi.get(1);
            int resultN = tmpLi.get(2);

            if (firstN + secondN == resultN) {
                System.out.printf("%s + %s = %s\n", firstN, secondN, resultN);
            }
        }
    }

    public void combinationRecursion3(int n, int k, ArrayList<Integer> l) {
        if (k == 0) return;
        else {
            for (int i = n - 1; i >= 0; i--) {
                l.add(i);
                combinationRecursion3(i, k - 1, l);
                l.remove(l.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationIterative1(int n, int k) {
        List<List<Integer>> l = new ArrayList<>();
        int[] a = new int[k];
        int i = k - 1;
        while (i >= 0) {
            if (a[i] >= n) {
                a[i] = 0;
                i--;
            } else {
                a[i]++;
                if (i != k - 1) {
                    i = k - 1;
                }

                List<Integer> ll = new ArrayList<Integer>();
                for (int x : a)
                    ll.add(x);

                l.add(ll);
            }
        }
        return l;
    }

    public List<List<Integer>> combinationIterative3(int n, int k) {
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l = new ArrayList<Integer>();
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                l.add(i);
                ll.add(new ArrayList<>(l));
                l.clear();
            }
            return ll;
        }

        if (k == n) {
            for (int i = 1; i <= n; i++) {
                l.add(i);
            }
            ll.add(new ArrayList<>(l));
            return ll;
        }

        for (int i = 0; i < k; i++) l.add(0);

        for (int i = 0; i >= 0; i--) {
            l.set(i, l.get(i) + 1);
            if (l.get(i) + 1 != l.get(i + 1)) {
                while (k - 1 > i) {
                    l.set(i + 1, l.get(i) + 1);
                    i++;
                }
                for (int x = l.get(i); x <= n; x++) {
                    l.set(i, x);
                    System.out.println(l.toString());
                    ll.add(new ArrayList<>(l));
                }
            } else {
                System.out.println(l.toString());
            }
        }
        return ll;
    }
}


