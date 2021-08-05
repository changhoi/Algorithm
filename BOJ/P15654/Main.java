package P15654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static class Stack {
        int[] arr;
        int cap, top = 0;

        public Stack(int cap) {
            this.cap = cap;
            arr = new int[cap];
        }

        void push(int x) {
            this.arr[top++] = x;
        }

        void pop() {
            top--;
        }

        void print() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < top; i++) {
                sb.append(arr[i]).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }

    static void choose(int k, boolean[] visited, Stack stack) {
        if (k == M) stack.print();
        else {
            for (int i = 0; i < N; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                stack.push(arr[i]);
                choose(k + 1, visited, stack);
                stack.pop();
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        choose(0, new boolean[N], new Stack(N));
    }
}
