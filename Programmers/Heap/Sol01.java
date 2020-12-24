package Heap;

class MinHeap {
    int cap;
    int current = 1;
    private int[] nodes;
    private int ROOT = 1;

    private int leftIndex(int n) {
        return 2 * n;
    }

    private int rightIndex(int n) {
        return 2 * n + 1;
    }

    private int parentIndex(int n) {
        return n / 2;
    }

    private void swap (int n, int m) {
        int temp = nodes[n];
        nodes[n] = nodes[m];
        nodes[m] = temp;
    }

    public MinHeap(int cap) {
        this.cap = cap;
        this.nodes = new int[cap + 1];
    }

    int peek() {
        return nodes[ROOT];
    }

    void queue(int n) {
        int seat = current++;
        nodes[seat] = n;

        while (seat > ROOT) {
            int parent = parentIndex(current);
            if (nodes[parent] > n) {
                swap(parent, seat);
                seat = parent;
            } else break;
        }
    }

    void heapify(int pos) {
        if (pos >= (current / 2) && pos < current) return;

        int lidx = leftIndex(pos);
        int ridx = rightIndex(pos);

        if (nodes[pos] > nodes[lidx] || nodes[pos] > nodes[ridx]) {
            if (nodes[lidx] < nodes[ridx]) {
                swap(pos, lidx);
                heapify(lidx);
            } else {
                swap(pos, ridx);
                heapify(ridx);
            }
        }

    }

    int dequeue() {
        if (current == 1) return -1;

        int ret = nodes[ROOT];
        int n = nodes[--current];
        nodes[ROOT] = n;
        nodes[current] = -1;
        heapify(ROOT);

        return ret;
    }
}

class Solution01 {
    public int solution(int[] scoville, int K) {
        /**
         * MinHeap 구현에서 실패함 - 테스트케이스만 맞음
         *
         * 아이디어는 맞음
         * 최소 힙 -> 루트 값이 K보다 커지도록 만든다.
         * 루트가 최소 값보다 작다면 dequeue + dequeue * 2; 후 다시 queue
         * 위를 반복함
         */

        int len = scoville.length;
        MinHeap mh = new MinHeap(len);

        for (int scov : scoville) {
            mh.queue(scov);
        }


        int count = 0;
        while (true) {
            if (mh.peek() < K) {
                int first = mh.dequeue();
                int second = mh.dequeue();
                int mix = first + 2 * second;
                mh.queue(mix);
                count++;
            } else break;
        }

        return count;
    }
}