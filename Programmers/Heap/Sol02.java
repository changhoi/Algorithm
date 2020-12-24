package Heap;

import java.util.*;

class Job {
    int requestAt;
    int time;

    public Job(int requestAt, int time) {
        this.requestAt = requestAt;
        this.time = time;
    }

    @Override
    public String toString() {
        return "{requestAt: " + this.requestAt + ", time: " + this.time + "}";
    }
}

class Solution02 {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> requestQueue = new PriorityQueue<Job>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return Integer.compare(o1.requestAt, o2.requestAt);
            }
        });

        PriorityQueue<Job> taskQueue = new PriorityQueue<Job>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return Integer.compare(o1.time, o2.time);
            }
        });

        for (int[] j : jobs) {
            requestQueue.add(new Job(j[0], j[1]));
        }

        int jobsCount = jobs.length;
        int time = 0;
        int sum = 0;

        while(true) {
            if (jobsCount <= 0) break;

            while(true) {
                if (requestQueue.isEmpty()) break;
                if (requestQueue.peek().requestAt > time) break;

                taskQueue.add(requestQueue.poll());
            }


            if(taskQueue.isEmpty()) {
                time++;
            } else {
                Job currentJob = taskQueue.poll();
                time += currentJob.time;
                sum += time - currentJob.requestAt;
                jobsCount--;
            }
        }



        return sum / jobs.length;
    }
}

