package P9935;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static final String FRULA = "FRULA";
    static char[] str, bomb, stack;
    static int top = 0;

    static boolean isBomb() {
        if (top < bomb.length) return false;

        for (int i = 1; i <= bomb.length; i++) {
            if(stack[top - i] != bomb[bomb.length - i]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P9935/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine().toCharArray();
        bomb = br.readLine().toCharArray();
        stack = new char[str.length];

        for (char c : str) {
            stack[top++] = c;
            if(isBomb()) top -= bomb.length;
        }

        if (top == 0) System.out.println(FRULA);
        else System.out.println(String.valueOf(stack, 0, top));
    }
}
