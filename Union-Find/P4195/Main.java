package P4195;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Person {
    Person root;
    int count = 1;
    String name;

    public Person(String name) {
        this.name = name;
        this.root = this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "root=" + root.name +
                ", count=" + count +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Main {
    static HashMap<String, Person> people = new HashMap<>();

    static Person getPerson(String name) {
        if (people.containsKey(name)) {
            return people.get(name);
        }

        Person p = new Person(name);
        people.put(name, p);
        return p;
    }

    static boolean isRoot(Person p) {
        return p.name.equals(p.root.name);
    }

    static Person find(Person p) {
        if (isRoot(p)) return p;
        return p.root = find(p.root);
    }

    static void union(Person p1, Person p2) {
        Person r1 = find(p1);
        Person r2 = find(p2);

        if (r1.name.equals(r2.name)) {
            System.out.println(r1.count);
            return;
        }

        r1.count += r2.count;
        r2.count = 0;
        r2.root = r1;
        System.out.println(r1.count);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P4195/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            people = new HashMap<>();
            int f = Integer.parseInt(br.readLine());
            for (int j = 0; j < f; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();

                Person p1 = getPerson(f1);
                Person p2 = getPerson(f2);
                union(p1, p2);
            }
        }
    }
}
