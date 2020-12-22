package BruteForce;

import java.util.ArrayList;

class Solution01 {
    public int[] solution(int[] answers) {
        int[] stu1 = {1,2,3,4,5};
        int[] stu2 = {2,1,2,3,2,4,2,5};
        int[] stu3 = {3,3,1,1,2,2,4,4,5,5};

        ArrayList<Integer> answer = new ArrayList<Integer>();

        int[] score = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            int ans = answers[i];
            if (ans == stu1[i % stu1.length]) score[0]++;
            if (ans == stu2[i % stu2.length]) score[1]++;
            if (ans == stu3[i % stu3.length]) score[2]++;
        }

        int max = Math.max(Math.max(score[0], score[1]), score[2]);

        for (int i = 0; i < score.length; i++) {
            if (max == score[i]) answer.add(i + 1);
        }

        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}
