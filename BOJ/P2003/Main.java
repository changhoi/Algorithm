package DAY02.P2003;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY02/P2003/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(N + ", " + M);

        nums = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.toString(nums));

        int low = 0, high = 0, count = 0;
        int sum = nums[0];// nums[low ~ high] 의 합
        while (true) {
            // sum == M -> sum에서 nums[low]를 빼고 low를 우측으로 한칸 이동.
            if (sum == M) {
                count++;
                sum -= nums[low++];
            }
            // sum > M -> sum에서 nums[low]를 빼고 low를 우측으로 한칸 이동.
            else if (sum > M) {
                sum -= nums[low++];
            }
            // sum < M -> high를 우측으로 한칸 이동 하고 sum에 nums[high] 더한다.
            else {
                sum += nums[++high];
            }

            if (high == N) {
                break;
            }
        }

        System.out.println(count);
    }

}