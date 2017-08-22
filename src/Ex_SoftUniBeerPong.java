import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Vilcho on 8/19/2017.
 */
public class Ex_SoftUniBeerPong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> contestants = new LinkedHashMap<String, LinkedHashMap<String, Integer>>();

        String input = scanner.nextLine();

        while (!input.equals("stop the game")) {
            String[] values = input.split("\\|");
            if (!contestants.keySet().contains(values[1])) {
                contestants.put(values[1], new LinkedHashMap<String, Integer>());
            }
            if (contestants.get(values[1]).keySet().size() < 3) {
                contestants.get(values[1]).put(values[0], Integer.valueOf(values[2]));
            }
            input = scanner.nextLine();
        }


        Comparator<Map.Entry<String, LinkedHashMap<String, Integer>>> teamComparator = new Comparator<Map.Entry<String, LinkedHashMap<String, Integer>>>() {

            @Override
            public int compare(Map.Entry<String, LinkedHashMap<String, Integer>> e1, Map.Entry<String, LinkedHashMap<String, Integer>> e2) {

                Integer v1 = e1.getValue().values().stream().mapToInt(Integer::valueOf).sum();
                Integer v2 = e2.getValue().values().stream().mapToInt(Integer::valueOf).sum();
                return v2.compareTo(v1);
            }
        };

        Comparator<Map.Entry<String, Integer>> personComparator = new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                Integer w1 = e1.getValue();
                Integer w2 = e2.getValue();
                return w2 - w1;
            }
        };

        int count = 0;

        LinkedHashMap<String, LinkedHashMap<String, Integer>> sortedTeams = contestants.entrySet().stream()
                .filter(n -> n.getValue().size() == 3)
                .sorted(teamComparator)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
               // .sorted(contestants.values(Comparator.comparing(personComparator)))
//                .forEach(n -> System.out.println(count + n.getKey() + "; Players:"));
                //.forEach(n -> System.out.printf("%d. %s; Players: %n###%s: %n", count, n.getKey(), n.getValue().entrySet()));

        for (Map.Entry<String, LinkedHashMap<String, Integer>> kvp : sortedTeams.entrySet()) {
            System.out.printf("%d. %s; Players: %n",++count, kvp.getKey());

            kvp.getValue().entrySet().stream()
                    .sorted(personComparator)
                    .forEach(v-> System.out.println("###" + v.getKey() + ": " + v.getValue()));
//                    .forEach(v -> System.out.printf("###%s: %%n"), kvp.getKey(), kvp.getValue());
        }
    }
}
