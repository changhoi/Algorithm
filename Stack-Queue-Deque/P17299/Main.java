package P17299;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P17299/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int [] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (map.containsKey(arr[i])) {
                int val = map.get(arr[i]);
                map.put(arr[i], val + 1);
            } else map.put(arr[i], 1);
        }

        Stack<Integer> stack = new Stack<>();
        int[]answer = new int[N];
        for (int i = N - 1 ; i >= 0; i--) {
            while (!stack.isEmpty() && map.get(stack.peek()) <= map.get(arr[i])) stack.pop();
            int ans = stack.isEmpty() ? -1 : stack.peek();
            answer[i] = ans;
            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int ans : answer) {
            sb.append(ans).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
