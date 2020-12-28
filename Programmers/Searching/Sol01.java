package Searching;

class Solution01 {
    int[] nums;

    int dfs(int idx, int target) {
        if (nums.length == idx) {
            if (target == 0) return 1;
            else return 0;
        } else {
            int s1 = target - nums[idx];
            int s2 = target + nums[idx];

            int ret = 0;

            ret += dfs(idx + 1, s1);
            ret += dfs(idx + 1, s2);

            return ret;
        }
    }

    public int solution(int[] numbers, int target) {
        nums = numbers;

        return dfs(0, target);
    }
}