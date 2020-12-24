package StackQueue;

import java.util.LinkedList;
import java.util.Queue;

class Truck {
    int startAt;
    int weight;

    public Truck(int startAt, int weight) {
        this.startAt = startAt;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{startAt: " + startAt + ", weight: " + weight + "}";
    }
}

class Solution03 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();

        for (int w : truck_weights) {
            q.add(w);
        }

        int time = 0;
        int limit = weight;

        while(true) {
            if (q.isEmpty() && bridge.isEmpty()) break;
            time++;

            if (bridge.peek() != null && time - bridge.peek().startAt == bridge_length) {
                // 다리에서 트럭 제거
                Truck t = bridge.poll();
                limit += t.weight;
            }

            if (q.peek() != null && q.peek() <= limit) {
                // 다리에 트럭 추가
                int w = q.poll();
                Truck t = new Truck(time, w);
                limit -= w;
                bridge.add(t);
            }
        }

        return time;
    }
}