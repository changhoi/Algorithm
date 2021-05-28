package P2437;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static PriorityQueue<Integer> arr;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2437/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        /**
         * 1 ~ w 까지의 무게를 모두 만들 수 있다고 가정했을 때,
         * 그 다음으로 무거운 추가 k 무게라고 한다면, 1 ~ w, k ~ w + k 까지의 무게를 잴 수 있다.
         * 다만, k가 w + 1보다 크다면, "w+1"을 표현할 수가 없게 된다. 잴 수 있는 무게 중 k ~ k + w가 추가 되는 것이기 때문에
         */

        int max = 0;
        while(!arr.isEmpty()) {
            int n = arr.poll();
            if (n > max + 1) {
                break;
            }
            max += n;
        }

        System.out.println(max + 1);
    }
}
