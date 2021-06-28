package P2493;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Pair {
    int val;
    int idx;
    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2493/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Pair> stack = new Stack<>();


         int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int val = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek().val <= val) {
                    stack.pop();
                } else break;
            }

            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            } else {
                sb.append(stack.peek().idx).append(" ");
            }

            stack.push(new Pair(val, i));
        }

        System.out.println(sb.toString().trim());
    }
}