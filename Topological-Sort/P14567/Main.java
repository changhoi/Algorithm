package P14567;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P14567/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer>[][] list = new ArrayList[n + 1][2];
        for (int i = 1; i <= n; i++) {
            list[i][0] = new ArrayList<>(); // to
            list[i][1] = new ArrayList<>(); // from
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list[second][0].add(first);
            list[first][1].add(second);
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if(list[i][0].size() == 0) queue.add(i);
        }

        LinkedList<Integer> next = new LinkedList<>();
        int semester = 1;
        int[] ans = new int[n + 1];
        while(!queue.isEmpty()) {
            int lecture = queue.poll();
            ans[lecture] = semester;
            for (int nextLecture : list[lecture][1]) {
                list[nextLecture][0].remove((Integer)lecture);
                if(list[nextLecture][0].size() == 0) next.add(nextLecture);
            }

            if (queue.isEmpty()) {
                queue = next;
                next = new LinkedList<>();
                semester++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
