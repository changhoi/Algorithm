package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution01 {
    public int[] solution(int[] array, int[][] commands) {


        List<Integer> answer = new ArrayList<Integer>();
        for (int[] command : commands) {
            int from = command[0] - 1;
            int to = command[1];
            int kIndex = command[2] - 1;

            int[] cloned = Arrays.stream(Arrays.copyOfRange(array, from, to)).sorted().toArray();
            answer.add(cloned[kIndex]);
        }


        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}