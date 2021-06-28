package P2812;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2812/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] str = br.readLine().toCharArray();

        Stack<Integer> stack = new Stack<>();
        stack.add(str[0] - '0');

        for (int i = 1; i < N; i++) {
            while (K > 0 && !stack.isEmpty() && stack.peek() < str[i] - '0') {
                stack.pop();
                K--;
            }
            stack.add(str[i] - '0');
        }

        while (K-- > 0) stack.pop();


        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        System.out.println(sb);
    }
}