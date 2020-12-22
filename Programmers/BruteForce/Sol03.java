package BruteForce;

class Solution {
    public int[] solution(int brown, int yellow) {
        /**
         * x + y = (brown + 4) / 2;
         * x * y = yellow + brown;
         */

        int edgeMax = brown / 2 - 1;


        for (int i = 3; i <= edgeMax; i++) {
            for (int j = 3; j <= edgeMax; j++) {
                if ((i + j) * 2 - 4 == brown) {
                    if (i * j == brown + yellow) {
                        int x = Math.max(i, j);
                        int y = Math.min(i, j);
                        return new int[]{x, y};
                    }
                }
            }
        }

        return new int[]{};
    }
}