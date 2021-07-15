package P64064;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> ans = new HashSet<>();
    String[] userIds, bannedIds;
    boolean[] visited;

    void makeAnswer() {
        int val = 0;
        int len = visited.length;
        for (int i = len - 1; i >= 0; i--) {
            if (visited[i]) val += 1;
            val <<= 1;
        }
        ans.add(val);
    }

    boolean isMatched(String a, String b) {
        if (a.length() != b.length()) return false;
        int len = a.length();
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) == '*') continue;
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    void dfs(int idx) {
        if (idx >= bannedIds.length) {
            makeAnswer();
            return;
        }
        String bid = bannedIds[idx];
        for (int i = 0; i < userIds.length; i++) {
            if (visited[i]) continue;
            if (!isMatched(bid, userIds[i])) continue;
            visited[i] = true;
            dfs(idx + 1);
            visited[i] = false;
        }
    }


    public int solution(String[] user_id, String[] banned_id) {
        userIds = Arrays.copyOf(user_id, user_id.length);
        bannedIds = Arrays.copyOf(banned_id, banned_id.length);
        visited = new boolean[user_id.length];
        dfs(0);

        return ans.size();
    }
}

