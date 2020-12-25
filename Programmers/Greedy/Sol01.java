package Greedy;

class Solution01 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] stu = new int[n + 1];
        for (int r : reserve) {
            stu[r - 1]++;
        }

        for (int l : lost) {
            stu[l - 1]--;
        }

        for (int i = 0; i < n; i++) {
            if (stu[i] > 0) {
                //여벌 있는 경우, 오른쪽 친구에게 빌려줌
                if (stu[i + 1] < 0) {
                    stu[i + 1]++;
                    stu[i]--;
                }
            } else if (stu[i] < 0) {
                // 도난 당한 경우 오른쪽애한테 빌려감
                if (stu[i + 1] > 0) {
                    stu[i]++;
                    stu[i + 1]--;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if(stu[i] >= 0) {
                count++;
            }
        }

        return count;
    }
}