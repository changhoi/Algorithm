package DAY03.P1202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static Jewelry[] jewelries;
    static int[] bags;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewelries = new Jewelry[N];
        bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Jewelry> pq = new PriorityQueue<>(Comparator.comparingInt(Jewelry::getValue).reversed());

        Arrays.sort(jewelries, Comparator.comparingInt(Jewelry::getWeight));
        Arrays.sort(bags);

        int jIndex = 0;
        long result = 0;
        for (int i = 0; i < K; i++) {
            while (jIndex < N && jewelries[jIndex].weight <= bags[i]) {
                pq.add(jewelries[jIndex++]);
            }

            if (!pq.isEmpty()) {
                result += pq.poll().value;
            }
        }
        System.out.println(result);
    }
}

class Jewelry {
    int weight;
    int value;

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public Jewelry(int weight, int value) {
        super();
        this.weight = weight;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Jewelry [weight=" + weight + ", value=" + value + "]";
    }

}