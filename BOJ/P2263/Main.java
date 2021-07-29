package P2263;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] post, in, inIdx;

    static void builder(int inStart, int inEnd, int postStart, int postEnd, StringBuilder sb) {
        if (inStart > inEnd || postEnd < 0) return;
        int root = post[postEnd];
        sb.append(root).append(" ");

        int idx = inIdx[root];
        builder(inStart, idx - 1, postStart, postEnd - (inEnd - idx) - 1, sb);
        builder(idx + 1, inEnd, postStart + (idx - inStart), postEnd - 1, sb);
    }

    static void pre() {
        StringBuilder sb = new StringBuilder();
        builder(0, n - 1, 0, n - 1, sb);
        System.out.println(sb.toString().trim());
    }


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2263/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        in = new int[n];
        post = new int[n];
        inIdx = new int[n + 1];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st1.nextToken());
            post[i] = Integer.parseInt(st2.nextToken());
            inIdx[in[i]] = i;
        }


        pre();
    }
}