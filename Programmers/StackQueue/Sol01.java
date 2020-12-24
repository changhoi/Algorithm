package StackQueue;

class Node {
    int val;
    int index;
    int count = 0;

    public Node(int val, int index) {
        this.val = val;
        this.index = index;
    }


}

class NodeStack {
    private int cap;
    private Node[] nodes;
    int top = 0;

    public NodeStack(int cap) {
        this.cap = cap;
        this.nodes = new Node[cap];
    }

    void push(int val, int index) {
        Node node = new Node(val, index);
        this.nodes[this.top++] = node;
    }

    Node pop() {
        Node node = this.nodes[--this.top];
        this.nodes[this.top] = null;
        return node;
    }

    void addCount() {
        for (int i = 0; i < this.top; i++) {
            this.nodes[i].count++;
        }
    }

    int peek() {
        return this.nodes[this.top - 1].val;
    }
}

class Solution01 {
    public int[] solution(int[] prices) {
        int len = prices.length;
        NodeStack ns = new NodeStack(len);
        ns.push(prices[0], 0);

        int [] answer = new int[len];

        for (int i = 1; i < len; i++) {
            // 1초 지남
            ns.addCount();

            // Stack의 Top보다 작은 수가 오면 pop해주고 answer에 담는다.
            int pc = ns.top - 1;
            for (int j = pc; j >= 0; j--) {
                if (ns.peek() <= prices[i]) break;

                Node n = ns.pop();
                answer[n.index] = n.count;
            }

            // Stack에 push
            ns.push(prices[i], i);
        }

        // Stack에 남아있는 노드를 답에 넣어줌
        int popCount = ns.top;
        for (int i = 0 ; i < popCount; i++) {
            Node n = ns.pop();
            answer[n.index] = n.count;
        }

        return answer;
    }
}