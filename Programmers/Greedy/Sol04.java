package Greedy;

import java.util.Arrays;

class Solution04 {
    public int solution(int[] people, int limit) {
        int l = 0, r = people.length - 1;
        Arrays.sort(people);

        int boat = 0;
        while(l < r) {
            if (people[l] + people[r] <= limit) {
                l++;
                r--;
                boat++;
            } else {
                r--;
                boat++;
            }
        }

        if (l == r) boat++;

        return boat;
    }
}