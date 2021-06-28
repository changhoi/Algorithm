package P1874;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static StringBuilder answer = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();

    static void push(int n) {
        answer.append("+\n");
        stack.add(n);
    }

    static int pop() {
        answer.append("-\n");
        return stack.pop();
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1874/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        boolean success = true;
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            while (count < val) {
                push(++count);
            }

            if (stack.peek() == val) pop();
            else {
                success = false;
                break;
            }
        }

        if (!success) System.out.println("NO");
        else System.out.print(answer.toString());
    }
}
