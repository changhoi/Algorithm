package P2504;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Character> stack = new Stack<>();
    static char[] arr;
    static int [] values;

    static void pop(int val) {
        stack.pop();
        int depth = stack.size();

        if (values[depth + 1] != 0) {
            values[depth] += val * values[depth + 1];
            values[depth + 1] = 0;
        } else {
            values[depth] += val;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2504/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = br.readLine().toCharArray();
        values = new int[arr.length];

        for (char a: arr) {
            if (a == '(' || a == '[') stack.push(a);
            else {
                if (stack.isEmpty()) {
                    values[0] = 0;
                    break;
                } else if (stack.peek() == '(' && a == ')') pop(2);
                else if (stack.peek() == '[' && a == ']') pop(3);
                else {
                    values[0] = 0;
                    break;
                }
            }
        }

        System.out.println(values[0]);
    }
}
