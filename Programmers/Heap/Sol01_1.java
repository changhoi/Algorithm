package Heap;

import java.util.PriorityQueue;

class Solution01_01 {
    public int solution(int[] scoville, int K) {
        int len = scoville.length;
        PriorityQueue<Integer> h = new PriorityQueue<Integer>(len);

        for (int sc : scoville) {
            h.add(sc);
        }

        int cnt = 0;

        while(true) {
            if (h.peek() == null) return -1;
            if (h.peek() >= K) return cnt;
            if (h.size() < 2) {
                return -1;
            } else {
                cnt++;
                int mix = h.poll() + h.poll() * 2;
                h.add(mix);
            }
        }
    }
}