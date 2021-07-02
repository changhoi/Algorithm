package P14499;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int UPSIDE = 1;
    static final int DOWNSIDE = 6;

    // {1, 2, 3, 4} -> 동 서 북 남
    static int N,M,K;
    static int[] point = new int[2];
    static int[] dice = new int[7];
    static int[][] map;

    public static void roll(int c) {
        int[] temp = Arrays.copyOf(dice, 7);
        switch(c) {
            case 1:
                if (point[1] + 1 >= M) return;
                point[1] +=1 ;
                dice[1] = temp[4];
                dice[4] = temp[6];
                dice[3] = temp[1];
                dice[6] = temp[3];
                break;
            case 2:
                if (point[1] - 1 < 0) return;
                point[1] -= 1;
                dice[4] = temp[1];
                dice[1] = temp[3];
                dice[3] = temp[6];
                dice[6] = temp[4];
                break;
            case 3:
                if (point[0] - 1 < 0) return;
                point[0] -= 1;
                dice[2] = temp[1];
                dice[1] = temp[5];
                dice[5] = temp[6];
                dice[6] = temp[2];
                break;
            case 4:
                if (point[0] + 1 >= N) return;
                point[0] += 1;
                dice[2] = temp[6];
                dice[1] = temp[2];
                dice[5] = temp[1];
                dice[6] = temp[5];
                break;
        }

        int n = point[0]; int m = point[1];

        if (map[n][m] == 0) {
            map[n][m] = dice[DOWNSIDE];
        } else {
            dice[DOWNSIDE] = map[n][m];
            map[n][m] = 0;
        }
        System.out.println(dice[UPSIDE]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        point[0] = Integer.parseInt(st.nextToken());
        point[1] = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int c = Integer.parseInt(st.nextToken());
            roll(c);
        }
    }
}
