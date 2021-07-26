package P15652;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static class Stack {
        int cap, top = 0;
        int[] arr;

        public Stack(int cap) {
            this.cap = cap;
            arr = new int[cap];
        }

        void push(int x) {
            arr[top++] = x;
        }

        void pop() {
            top--;
        }

        void print() {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) sb.append(i).append(" ");
            System.out.println(sb.toString().trim());
        }
    }

    static void search(int idx, int cnt, Stack stack) {
        if (cnt == M) {
            stack.print();
            return;
        }

        for (int i = idx; i <= N; i++) {
            stack.push(i);
            search(i, cnt + 1, stack);
            stack.pop();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        search(1, 0, new Stack(M));
    }
}
