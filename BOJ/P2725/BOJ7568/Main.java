package BOJ.BOJ7568;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int WEIGHT = 0;
    static int HEIGHT = 1;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BOJ/BOJ7568/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][WEIGHT] = Integer.parseInt(st.nextToken());
            arr[i][HEIGHT] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            answer[i]++;
            int[] wh = arr[i];
            for (int j = i + 1; j < N; j++) {
                int[] other = arr[j];
                if (wh[WEIGHT] > other[WEIGHT] && wh[HEIGHT] > other[HEIGHT]) answer[j]++;
                else if (wh[WEIGHT] < other[WEIGHT] && wh[HEIGHT] < other[HEIGHT]) answer[i]++;
            }
        }

        for (int i : answer) {
            System.out.print(Integer.toString(i) + ' ');
        }
    }
}
