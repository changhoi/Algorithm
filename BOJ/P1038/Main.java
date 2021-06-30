package P1038;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1038/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Long> list = new ArrayList<>();

        for (int i = 1; i <= 1023; i++) {
            int temp = i;
            long num = 0;

            for (int j = 9; j >= 0; j--) {
                if (temp % 2 == 1) num = 10 * num + j;
                temp /= 2;
                if (temp == 0) break;
            }

            list.add(num);
        }
        list.sort(Long::compareTo);

        int N = Integer.parseInt(br.readLine());
        if (N >= 1023) System.out.println(-1);
        else System.out.println(list.get(N));
    }
}
