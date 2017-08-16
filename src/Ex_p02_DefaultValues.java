import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Vilcho on 8/4/2017.
 */
public class Ex_p02_DefaultValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> kvp = new LinkedHashMap<String, String>();

        String[] input = scanner.nextLine().split(" -> ");

        while (!input[0].equals("end")){

            kvp.put(input[0], input[1]);

            input = scanner.nextLine().split(" -> ");
        }

        String dv = scanner.nextLine();

        LinkedHashMap<String, String> changed = new LinkedHashMap<String, String>();

        for (Map.Entry<String, String> stringStringEntry : kvp.entrySet()) {
            if (stringStringEntry.getValue().equals("null")){
                changed.put(stringStringEntry.getKey(), stringStringEntry.getValue().replaceAll("null", dv));
            }
        }

//        LinkedHashMap<String, String> unchanged = kvp.entrySet().stream()
//                .filter(v -> !(v.getValue().equals("null")))
//                .sorted(Collections.reverseOrder(Comparator.comparingInt(v -> v.getValue().length())))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
//        System.out.println(unchanged);

        kvp.entrySet().stream()
                .filter(v -> !(v.getValue().equals("null")))
                .sorted(Collections.reverseOrder(Comparator.comparingInt(v1 -> v1.getValue().length())))
                .forEach(v -> System.out.println(v.getKey() + " <-> " + v.getValue()));


        changed.entrySet().stream()
                .forEach(v -> System.out.println(v.getKey() + " <-> " + v.getValue()));

    }
}
