package Greedy;

class Solution03 {
    public String solution(String number, int k) {
        char[] chars = number.toCharArray();

        int len = chars.length;
        int digits = len - k;

        int []nums = new int[len];
        for (int i = 0 ; i < len; i++) {
            nums[i] = Integer.parseInt(String.valueOf(chars[i]));
        }

        int[] answer = new int[digits];

        int count = 0;
        int startAt = 0;
        while (count < digits) {
            int available = len - digits + count;
            int maxIdx = startAt;
            for (int i = startAt + 1; i <= available; i++) {
                if (nums[i] > nums[maxIdx]) maxIdx = i;
            }

            startAt = maxIdx + 1;
            answer[count] = nums[maxIdx];
            count++;
        }

        StringBuilder sb = new StringBuilder();
        for (int a : answer) {
            sb.append(a);
        }

        return sb.toString();
    }
}