package P1644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static boolean[] notPrime;
    static List<Integer> prime = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        notPrime = new boolean[N + 1];
        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (notPrime[i]) continue;
            for (int j = 2; i * j <= N; j++) {
                notPrime[i * j] = true;
            }
        }

        for (int i = 2; i <= N; i++) {
            if (!notPrime[i]) prime.add(i);
        }

        int cnt = 0;
        for (int i = 0; i < prime.size(); i++) {
            int sum = 0;
            for (int j = i; j < prime.size(); j++) {
                sum += prime.get(j);
                if (sum == N) cnt++;
                if (sum > N) break;
            }
        }

        System.out.println(cnt);
    }
}
