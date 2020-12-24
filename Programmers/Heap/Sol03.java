package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class DoubleQueue {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    int size = 0;

    public DoubleQueue() {
        min = new PriorityQueue<Integer>();
        max = new PriorityQueue<Integer>(Comparator.reverseOrder());
    }

    void queue(int n) {
        this.size++;
        this.max.add(n);
        this.min.add(n);
    }

    private void clear() {
        this.max.clear();
        this.min.clear();
    }

    int dequeueMax() {
        if (max.isEmpty()) return -1;
        int ret = this.max.poll();
        if (--size == 0) clear();

        return ret;
    }

    int dequeueMin() {
        if (min.isEmpty()) return -1;
        int ret = this.min.poll();
        if (--size == 0) clear();
        return ret;
    }

    int[] maxMin() {
        if (size == 0) return new int[]{0, 0};

        int minVal = min.peek();
        int maxVal = max.peek();
        return new int[]{maxVal, minVal};
    }
}


class Solution03 {
    public int[] solution(String[] operations) {
        DoubleQueue dq = new DoubleQueue();

        for (String s : operations) {
            String[] op = s.split(" ");

            switch (op[0]) {
                case "I":
                    dq.queue(Integer.parseInt(op[1]));
                    break;
                case "D":
                    if (op[1].equals("1")) dq.dequeueMax();
                    else dq.dequeueMin();
                    break;
            }
        }

        return dq.maxMin();
    }
}