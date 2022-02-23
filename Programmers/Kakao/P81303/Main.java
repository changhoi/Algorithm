package P81303;

import java.util.*;

class Node {
    boolean isDeleted;
    Node left, right;


    Node(Node left, Node right) {
        this.left = left;
        this.right = right;
        this.isDeleted = false;
    }
}

class Solution {
    Stack<Node> log = new Stack<>();
    Node current;

    void U(int x) {
        for(int i = 0; i < x; i++) {
            if (current.left == null) {
                return;
            }

            current = current.left;
        }
    }

    void D(int x) {
        for (int i = 0; i < x; i++) {
            if (current.right == null) {
                return;
            }

            current = current.right;
        }
    }

    void C() {
        log.push(current);
        current.isDeleted = true;

        Node left = current.left;
        Node right = current.right;

        if (left != null) {
            left.right = right;
        }

        if (right != null) {
            right.left = left;
            current = right;
        } else {
            current = left;
        }
    }

    void Z() {
        Node removed = log.pop();
        removed.isDeleted = false;
        Node left = removed.left;
        Node right = removed.right;
        if (left != null) {
            left.right = removed;
        }

        if (right != null) {
            right.left = removed;
        }
    }

    public String solution(int n, int k, String[] cmd) {
        Node[] nodes = new Node[n];
        Node prev = new Node(null, null);
        nodes[0] = prev;
        for (int i = 1; i < n; i++) {
            nodes[i] = new Node(prev, null);
            prev.right = nodes[i];
            prev = nodes[i];
        }

        current = nodes[k];

        for (String c : cmd) {
            StringTokenizer st = new StringTokenizer(c);
            String command = st.nextToken();
            switch(command) {
                case "D":
                    int d = Integer.parseInt(st.nextToken());
                    D(d);
                    break;
                case "U":
                    int u = Integer.parseInt(st.nextToken());
                    U(u);
                    break;
                case "C":
                    C();
                    break;
                case "Z":
                    Z();
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Node node = nodes[i];
            if (node.isDeleted) {
                sb.append("X");
            } else {
                sb.append("O");
            }
        }

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println((sol.solution(8,	2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"})));
    }
}