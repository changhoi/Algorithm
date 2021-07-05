package P1713;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1713/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int voteCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] on = new int[100];
        int[] votes = new int[100];

        for (int i = 1; i <= voteCount; i++) {
            int stu = Integer.parseInt(st.nextToken()) - 1;
            if (on[stu] != 0) {
                votes[stu]++;
                continue;
            }

            if (N > 0) {
                on[stu] = i;
                votes[stu] = 1;
                N--;
            } else {
                int min = Integer.MAX_VALUE;
                int minIdx = 0;
                for (int j = 0; j < 100; j++) {
                    if (on[j] != 0) {
                        if (votes[j] < min || (votes[j] == min && on[j] < on[minIdx])) {
                            min = votes[j];
                            minIdx = j;
                        }
                    }
                }

                votes[minIdx] = 0;
                on[minIdx] = 0;

                on[stu] = i;
                votes[stu] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            if (on[i] != 0) sb.append(i + 1).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
