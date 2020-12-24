package StackQueue;

import java.util.ArrayList;

class Task {
    int priority;
    int progress;
    int speed;
    int time;

    public Task(int progress, int speed, int priority) {
        this.progress = progress;
        this.priority = priority;
        this.speed = speed;

        this.time = (int)Math.ceil((100.0 - progress) / speed);
    }
}

class Queue {
    int front = 0;
    int rear = 0;
    int cap;
    Task[] tasks;

    public Queue(int cap) {
        this.cap = cap;
        this.tasks = new Task[cap];
    }

    void queue(int progress, int speed, int priority) {
        Task t = new Task(progress, speed, priority);
        this.tasks[rear++] = t;
    }

    int groupDequeue() {
        int scope = 1; // 뺄 수 있는 범위
        int standard = this.tasks[this.front].time; // 기준 시간

        for (int i = this.front + 1; i < this.rear; i++) {
            // 기준 시간 보다 작은 경우, 뺄 수 있음.
            if (this.tasks[i].time <= standard) scope++;
            else break;
        }

        // 범위만큼 Dequeue
        for (int i = 0; i < scope; i++) {
            this.dequeue();
        }

        return scope;
    }

    Task dequeue() {
        Task t = this.tasks[front];
        this.tasks[front++] = null;
        return t;
    }
}

class Solution02 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        int cap = progresses.length;
        Queue q = new Queue(cap);

        // Queue에 작업들을 넣어둠
        for (int i = 0; i < cap; i++) {
            q.queue(progresses[i], speeds[i], i);
        }

        // 묶음 단위로 빼고, 빠진 수를 받아서 answer에 담음
        while(q.front < q.rear) {
            int count = q.groupDequeue();
            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}