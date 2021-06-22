package P2056;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Work {
    int id, consume;
    List<Integer> pre = new ArrayList<>();
    List<Integer> back = new ArrayList<>();

    public Work(int id) {
        this.id = id;
    }
}

public class Main {
    static Work[] works;
    static Queue<Work> queue = new LinkedList<>();

    static void topologySort() {
        int count = 0;
        List<Work> list = new ArrayList<>();
        while (true) {
            while(!queue.isEmpty()) {
                Work w = queue.poll();
                list.add(w);
            }

            if (list.isEmpty()) break;

            count++;
            List<Work> done = new ArrayList<>();
            for (Work l : list) {
                l.consume--;
                if (l.consume == 0) {
                    done.add(l);
                    for (int b : l.back) {
                        works[b - 1].pre.remove((Integer) l.id);
                        if (works[b - 1].pre.isEmpty()) queue.add(works[b - 1]);
                    }
                }
            }

            list.removeAll(done);
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2056/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        works = new Work[N];

        for (int i = 0; i < N; i++) {
            works[i] = new Work(i + 1);
        }

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int consume = Integer.parseInt(st.nextToken()); // 걸리는 시간
            int pre = Integer.parseInt(st.nextToken()); // 선행 관계 작업 개수
            works[i].consume = consume;
            for (int p = 0; p < pre; p++) {
                int wid = Integer.parseInt(st.nextToken());
                works[i].pre.add(wid);
                works[wid - 1].back.add(i + 1);
            }
        }

        for (Work w : works) {
            if (w.pre.isEmpty()) queue.add(w);
        }

        topologySort();
    }
}
