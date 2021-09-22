package P2342;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] directions = {
            {0, 2, 2, 2, 2},
            {0, 1, 3, 4, 3},
            {0, 3, 1, 3, 4},
            {0, 4, 3, 1, 3},
            {0, 3, 4, 3, 1},
    };

    static int[][][] cache;
    static int size = 0;
    static List<Integer> commands = new ArrayList<>();

    static int getMin(int idx, int l, int r) {
        if (idx == size) return 0;
        if (cache[idx][l][r] != 0) return cache[idx][l][r];

        int min = Integer.MAX_VALUE;
        int step = commands.get(idx);

        if (step != r) min = Math.min(min, getMin(idx + 1, step, r) + directions[l][step]);
        if (step != l) min = Math.min(min, getMin(idx + 1, l, step) + directions[r][step]);
        return cache[idx][l][r] = min;
    }

    static void solution() {
        size = commands.size();
        cache = new int[size][5][5];
        System.out.println(getMin(0, 0, 0));
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2342/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        while (true) {
            int step = Integer.parseInt(st.nextToken());
            if (step == 0) break;
            commands.add(step);
        }

        solution();
    }
}
