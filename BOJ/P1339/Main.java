package P1339;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

class Char implements Comparable<Char> {
    int score = 0;
    char c;

    public Char(char c) {
        this.c = c;
    }

    void updateScore(int digit) {
        score += digit;
    }

    @Override
    public int compareTo(Char o) {
        return Integer.compare(o.score, this.score);
    }

    @Override
    public String toString() {
        return "Char{" +
                "score=" + score +
                ", c=" + c +
                '}';
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1339/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] arr = new char[N][];
        HashMap<Character, Char> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
            for (int j = 0; j < arr[i].length; j++) {
                int pow = (int) Math.pow(10, arr[i].length - j - 1);
                char c = arr[i][j];
                if (map.containsKey(c)) {
                    Char val = map.get(c);
                    val.updateScore(pow);
                } else {
                    Char val = new Char(c);
                    val.updateScore(pow);
                    map.put(c, val);
                }
            }
        }

        PriorityQueue<Char> q = new PriorityQueue<>(map.values());

        int sum = 0;
        int digit = 9;
        while (!q.isEmpty()) {
            Char c = q.poll();
            sum += c.score * digit--;
        }
        System.out.println(sum);
    }
}
