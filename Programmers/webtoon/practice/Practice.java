package webtoon.practice;

import java.util.Arrays;

public class Practice {
    static int max(int[] v) {
        int max = Integer.MIN_VALUE;
        for (int val : v) {
            max = Math.max(val, max);
        }

        return max;
    }

    static int min(int[] v) {
        int min = Integer.MAX_VALUE;
        for (int val : v) {
            min = Math.min(val, min);
        }

        return min;
    }

    public static int[] solution(int[][] v) {
        int[] p1 = v[0];
        int[] p2 = v[1];
        int[] p3 = v[2];

        int[] ld = new int[]{
                min(new int[]{p1[0], p2[0], p3[0]}),
                min(new int[]{p1[1], p2[1], p3[1]})
        };

        int[] ru = new int[]{
                max(new int[]{p1[0], p2[0], p3[0]}),
                max(new int[]{p1[1], p2[1], p3[1]})
        };

        int[][] must = new int[][]{
                ld,
                ru,
                new int[]{ld[0], ru[1]},
                new int[]{ru[0], ld[1]}
        };

        for (int[] p : must) {
            boolean exist = false;
            for (int[] e : v) {
                if (p[0] == e[0] && p[1] == e[1]) {
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                return p;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[][] tc1 = new int[][]{
                {1, 4},
                {3, 4},
                {3, 10}
        };
        int[][] tc2 = new int[][]{
                {1, 1},
                {2, 2},
                {1, 2}
        };

        System.out.println(Arrays.toString(solution(tc1)));
        System.out.println(Arrays.toString(solution(tc2)));
    }
}
