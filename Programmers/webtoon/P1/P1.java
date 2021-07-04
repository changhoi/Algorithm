package webtoon.P1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P1 {
    public int solution(int[] prices, int[] discounts) {
        PriorityQueue<Integer> priceQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> discountQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int p : prices) priceQueue.add(p);
        for (int d : discounts) discountQueue.add(d);

        int answer = 0;
        while(!discountQueue.isEmpty() && !priceQueue.isEmpty()) {
            int dis = discountQueue.poll();
            int pri = priceQueue.poll();
            answer += (1 - (dis / 100.0)) * pri;
        }

        while(!priceQueue.isEmpty()) {
            answer += priceQueue.poll();
        }

        return answer;
    }
}
