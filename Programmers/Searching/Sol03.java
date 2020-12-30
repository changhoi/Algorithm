package Searching;

import java.util.Arrays;

class Solution03 {
    static int[][] edges;
    static int wordLen;
    static boolean[] visited;
    static String[] arr;

    boolean changeable(int i, int j) {
        char[] ac = arr[i].toCharArray();
        char[] bc = arr[j].toCharArray();
        int cnt = 0;
        for (int idx = 0; idx < wordLen; idx++) {
            if (ac[idx] != bc[idx]) cnt++;
            if (cnt > 1) {
                edges[i][j] = edges[j][i] = -1;
                return false;
            }
        }

        if (cnt == 1) {
            edges[i][j] = edges[j][i] = 1;
            return true;
        } else {
            edges[i][j] = edges[j][i] = -1;
            return false;
        }
    }

    int dfs (int idx, int depth, String target) {
        if (arr[idx].equals(target)) return depth;
        visited[idx] = true;
        int ret = arr.length;
        for (int i = 0; i < arr.length; i++) {
            boolean isChangeable = edges[idx][i] == 0 ? changeable(i, idx) : edges[idx][i] == 1;
            if (!visited[i] && isChangeable) {
                ret = Math.min(ret, dfs(i, depth + 1, target));
            }
        }
        return ret;
    }

    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;

        wordLen = begin.length();
        int len = words.length;
        arr = new String[len + 1];
        arr[0] = begin;
        System.arraycopy(words, 0, arr, 1, len);

        edges = new int[len + 1][len + 1];
        visited = new boolean[len + 1];

        int ret = 0;
        for (int i = 1; i < len + 1; i++) {
            visited = new boolean[len + 1];
            visited[0] = true;
            boolean isChangeable = edges[0][i] == 0 ? changeable(0, i) : edges[0][i] == 1;
            if (isChangeable) ret += dfs(i, 1, target);
        }

        return ret;
    }
}