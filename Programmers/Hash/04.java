package Hash;

import java.util.*;

class Solution04 {
    Map<String, ArrayList<Integer>> genreAndSong = new HashMap<>();
    Map<String, Integer> genreAndPlay = new TreeMap<>();

    private void updateGenreAndSong(String g, int idx) {
        ArrayList<Integer> songs = genreAndSong.getOrDefault(g, new ArrayList<Integer>());
        songs.add(idx);
        genreAndSong.put(g, songs);
    }

    private void updateGenreAndPlay(String g, int play) {
        int count = genreAndPlay.getOrDefault(g, 0);
        count += play;
        genreAndPlay.put(g, count);
    }

    private List<String> getSortedGenreList() {
        Map<String, Integer> m = this.genreAndPlay;
        List<String> list = new ArrayList<>(m.keySet());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int p1 = m.get(o1);
                int p2 = m.get(o2);
                if (p1 < p2) return 1;
                else return -1;
            }
        });

        return list;
    }

    public int[] solution(String[] genres, int[] plays) {

        int len = genres.length;
        for (int i = 0; i < len; i++) {
            String g = genres[i];
            int p = plays[i];
            this.updateGenreAndPlay(g, p);
            this.updateGenreAndSong(g, i);
        }

        List<String> sortedGenreList = this.getSortedGenreList();

        List<Integer> answer = new ArrayList<Integer>();

        for (String g : sortedGenreList) {
            ArrayList<Integer> songs = this.genreAndSong.get(g);
            songs.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer idx1, Integer idx2) {
                    if (plays[idx1] > plays[idx2]) return -1;
                    else if (plays[idx1] < plays[idx2]) return 1;
                    else if (idx1 < idx2) return -1;
                    else return 1;
                }
            });

            int count = 0;
            for (int s : songs) {
                if (count >= 2) break;
                count++;
                answer.add(s);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}