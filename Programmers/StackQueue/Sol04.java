package StackQueue;

import java.util.LinkedList;
import java.util.Queue;

class Paper {
    int idx;
    int priority;
    int order;

    public Paper(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Paper> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            Paper p = new Paper(i, priorities[i]);
            q.add(p);
        }

        int printed = 0;
        while (!q.isEmpty()) {
            boolean isMVP = true;
            Paper now = q.poll();
            for (Paper p : q) {
                if (p.priority > now.priority) {
                    isMVP = false;
                    break;
                }
            }

            if (isMVP) {
                now.order = ++printed;
                if (now.idx == location) return printed;
            } else {
                q.add(now);
            }
        }

        return answer;
    }
}