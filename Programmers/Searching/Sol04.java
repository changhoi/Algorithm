package Searching;

import java.util.ArrayList;
import java.util.Comparator;

class Solution04 {
    boolean[] visited;
    String[][] arr;
    String[] answer;
    int len;

    void setAnswer(String[] s) {
        if (answer == null) answer = s;
        else {
            ArrayList<String> candidate = new ArrayList<>();
            candidate.add(String.join(" ", answer));
            candidate.add(String.join(" ", s));
            candidate.sort(Comparator.naturalOrder());
            answer = candidate.get(0).split(" ");
        }
    }

    boolean reachable(String[] from, String[] to) {
        return from[from.length - 1].equals(to[0]);
    }

    void dfs (int depth, String[] path) {
        if (depth == len) setAnswer(path);
        else {
            for (int i = 0; i < len; i++) {
                if (!visited[i] && reachable(path, arr[i])) {
                    visited[i] = true;
                    String[] next = new String[path.length + 1];
                    System.arraycopy(path, 0, next, 0, path.length);

                    next[path.length] = arr[i][1];
                    dfs(depth + 1, next);
                    visited[i] = false;
                };
            }
        }
    }

    public String[] solution(String[][] tickets) {
        arr = tickets;
        len = tickets.length;
        answer = null;

        for (int i = 0; i < len; i++) {
            if (arr[i][0].equals("ICN")) {
                visited = new boolean[len];
                visited[i] = true;
                dfs(1, arr[i]);
            }
        }

        return answer;
    }
}