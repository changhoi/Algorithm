package P9252;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P9252/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        stack.add(0);
        int max = 0;
        for (int i = 1; i < n; i++) {
            int val = arr[i];

            while (!stack.isEmpty() && arr[stack.peek()] > val) {
                int x = stack.pop();
                int len = i;
                if (!stack.isEmpty()) {
                    len -= stack.peek() + 1;
                }
                max = Math.max(max, len * arr[x]);
            }

            stack.add(i);
        }

        while (!stack.isEmpty()) {
            int x = stack.pop();
            int len = n;
            if (!stack.isEmpty()) len -= stack.peek() + 1;
            max = Math.max(max, len * arr[x]);
        }

        System.out.println(max);
    }
}
