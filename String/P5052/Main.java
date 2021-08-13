package P5052;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class Trie {
        Node root = new Node();

        void insert(String s) {
            Node n = this.root;

            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - '0';
                if (n.children[idx] == null) n.children[idx] = new Node();
                n = n.children[idx];
            }
            n.terminal = true;
        }

        boolean find(String s) {
            Node n = this.root;

            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - '0';
                if (n.children[idx] == null) return false;
                n = n.children[idx];
                if (n.terminal) return true;
            }
            return true;
        }
    }

    static class Node {
        boolean terminal = false;
        Node[] children = new Node[10];
    }

    static void solution(String[] nums) {
        Trie t = new Trie();
        for (String s : nums) {
            if (t.find(s)) {
                System.out.println("NO");
                return;
            } else t.insert(s);
        }
        System.out.println("YES");
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P5052/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int j = 0; j < n; j++) {
                arr[j] = br.readLine();
            }
            Arrays.sort(arr, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
            solution(arr);
        }
    }
}
