package P1918;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int priority(char c) {
        if(c == '*' || c == '/') return 2;
        else if (c == '+' || c == '-') return 1;
        else return 0;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1918/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c: str ) {
            if (c == '(') stack.add(c);
            else if (c == ')') {
                while (true) {
                    char top = stack.pop();
                    if (top == '(') break;
                    sb.append(top);
                }
            } else if (c == '*' || c == '/' || c == '+' || c == '-') {
                while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                    char op = stack.pop();
                    sb.append(op);
                }
                stack.push(c);
            } else {
                sb.append(c);
            }
        }

        while(!stack.isEmpty()) sb.append(stack.pop());

        System.out.println(sb);
    }
}
