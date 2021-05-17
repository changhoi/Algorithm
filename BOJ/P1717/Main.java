package P1717;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] parent;

    static void union (int a, int b) {
        if (parent[a] != -1) {
            union(parent[a], b);
            return;
        }
        if (parent[b] != -1) {
            union(a, parent[b]);
            return;
        }

        if (a == b) return;

        parent[a] = b;
    };

    static int getRoot (int a) {
        if (parent[a] == -1) return a;
        else return parent[a] = getRoot(parent[a]);
    }

    static boolean find(int a, int b) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);
        return aRoot == bRoot;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1717/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            String[] commands = br.readLine().split(" ");
            int a = Integer.parseInt(commands[1]);
            int b = Integer.parseInt(commands[2]);
            if (Objects.equals(commands[0], "0")) {
                union(a, b);
            } else {
                String output = find(a, b) ? "YES" : "NO";
                System.out.println(output);
            }
        }
    }
}
