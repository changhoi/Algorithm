package P1157;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int cnt;
    char c;

    public Pair(int cnt, char c) {
        this.cnt = cnt;
        this.c = c;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(o.cnt, this.cnt);
    }
}

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toLowerCase().toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : word) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            queue.add(new Pair(e.getValue(), e.getKey()));
        }

        Pair ans = queue.poll();


        if (!queue.isEmpty() && queue.peek().cnt == ans.cnt) System.out.println("?");
        else System.out.println(String.valueOf(ans.c).toUpperCase());
    }
}
