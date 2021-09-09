package P14003;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static int[] arr, path;

    static int upperBound(int val) {
        int r = list.size();
        int l = 0;
        while (l < r) {
            int mid = (r + l) / 2;

            if (val > arr[list.get(mid)]) l = mid + 1;
            else r = mid;
        }

        return r;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P14003/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        path = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int top = 1;
        list.add(0);

        for (int i = 1; i < n; i++) {
            int val = arr[i];

            int idx = upperBound(val);

            if (idx == top) {
                path[i] = list.get(top - 1);
                list.add(i);
                top++;
            } else if (idx == 0) {
                list.set(idx, i);
                path[i] = -1;
            } else {
                path[i] = list.get(idx - 1);
                list.set(idx, i);
            }
        }

        System.out.println(list.size());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = list.get(list.size() - 1);
        stack.push(arr[idx]);

        for (int i = 0; i < list.size() - 1; i++) {
            idx = path[idx];
            stack.push(arr[idx]);
        }

        while(!stack.isEmpty()) sb.append(stack.pop()).append(" ");

        System.out.println(sb.toString().trim());
    }
}
