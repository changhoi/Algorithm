package BruteForce;

import java.util.Arrays;

class Solution02 {
    static int[] table;
    static void makeTable(int max) {
        table = new int[max + 1];
        table[0] = -1;
        table[1] = -1;

        for (int i = 2; i <= max; i++) {
            if (table[i] == 0) {
                table[i] = 1;

                int k = 2;
                while (true) {
                    int j = i * k;
                    if (j > max) break;

                    table[j] = -1;
                    k++;
                }
            }
        }
    }

    public int solution(String numbers) {
        char[] carr = numbers.toCharArray();
        Arrays.sort(carr);
        StringBuilder sb = new StringBuilder();



        int digits = carr.length;

        for (int i = 1; i <= digits; i++) {
            sb.append(carr[digits - i]);
        }

        int max = Integer.parseInt(sb.toString());

        makeTable(max);

        int answer = 0;

        for (int i = 2; i <= max; i++) {
            if (table[i] != 1) continue;

            String copied = numbers;
            char[] target = Integer.toString(i).toCharArray();
            boolean contain = true;
            for (char c : target) {
                String d = String.valueOf(c);
                if(!copied.contains(d)) {
                    contain = false;
                    break;
                }
                copied = copied.replaceFirst(d, "");
            }

            if (contain) {
                answer++;
            }
        }

        return answer;
    }
}