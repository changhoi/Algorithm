package P5639;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Node {
    static Node root = null;
    Node l = null, r = null;
    int val;

    public Node(int val) {
        this.val = val;
    }

    void print() {
        if (this.l != null) this.l.print();
        if (this.r != null) this.r.print();
        System.out.println(val);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P5639/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                Node n = new Node(Integer.parseInt(br.readLine()));
                if (Node.root == null) Node.root = n;
                else {
                    Node c = Node.root;
                    Node p = null;
                    while (c != null) {
                        p = c;
                        c = c.val < n.val ? c.r : c.l;
                    }

                    if (p.val > n.val) p.l = n;
                    else p.r = n;
                }
            }
        } catch (Exception ignored) {
            Node.root.print();
        }

    }
}
