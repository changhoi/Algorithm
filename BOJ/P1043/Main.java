package P1043;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Person {
    boolean known = false;
    Set<Person> party = new HashSet<>();

    void update() {
        for (Person p : party) {
            if (p.known) continue;

            p.known = true;
            p.update();
        }
    }
}

public class Main {
    public static void main (String[] args) throws IOException {
        System.setIn(new FileInputStream("src/P1043/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        Person[] people = new Person[N];
        for (int i = 0; i < N; i++) {
            people[i] = new Person();
        }

        int[][] parties = new int[M][];

        String[] line = br.readLine().split(" ");

        int[] known = new int[line.length - 1];
        for (int i = 1; i < line.length; i++) {
            known[i - 1] = Integer.parseInt(line[i]) - 1;
        }

        for (int i = 0; i < M; i++) {
            String[] round = br.readLine().split(" ");
            List<Person> partyPeople = new ArrayList<>();
            parties[i] = new int[round.length - 1];

            for (int j = 1; j < round.length; j ++) {
                int person = Integer.parseInt(round[j]) - 1;
                parties[i][j - 1] = person;
                partyPeople.add(people[person]);
            }

            for (Person p : partyPeople) {
                p.party.addAll(partyPeople);
            }
        }

        for (int k: known) {
            people[k].known = true;
            people[k].update();
        }

        int count = 0;

        for (int[] party : parties) {
            boolean hasKnown = false;
            for (int idx : party) {
                if (people[idx].known) {
                    hasKnown = true;
                    break;
                }
            }

            if (hasKnown) continue;

            count++;
        }

        System.out.println(count);
    }
}
