import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Vilcho on 8/22/2017.
 */
public class Ex_p05_FlattenDictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, String>> ordered = new LinkedHashMap<String, LinkedHashMap<String, String>>();

        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("end")) {

            if (!input[0].equals("flatten")) {
                if (!ordered.keySet().contains(input[0])) {
                    ordered.put(input[0], new LinkedHashMap<String, String>());
                }
                ordered.get(input[0]).put(input[1], input[2]);
            } else {
                for (Map.Entry<String, LinkedHashMap<String, String>> stringLinkedHashMapEntry : ordered.entrySet()) {
                    if (stringLinkedHashMapEntry.getKey().equals(input[1])) {
                        List<String> innerConcat = stringLinkedHashMapEntry.getValue().entrySet().stream()
                                .map((x) -> x.getKey().concat(x.getValue()))
                                .collect(Collectors.toList());

                        for (LinkedHashMap<String, String> stringStringLinkedHashMap : ordered.values()) {
                            ordered.get(input[1]).clear();
                            for (int i = 0; i < innerConcat.size(); i++) {
                                ordered.get(input[1]).put(innerConcat.get(i), "");
                            }
                        }

                    }
                }
            }

            input = scanner.nextLine().split(" ");
        }

        while (!input[0].equals("end")) {

            if (!ordered.keySet().contains(input[0])) {
                ordered.put(input[0], new LinkedHashMap<String, String>());
            }
            ordered.get(input[0]).put(input[1], input[2]);

            input = scanner.nextLine().split(" ");
        }

      //  System.out.println(ordered);

        ordered.entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparingInt(k1 -> k1.getKey().length())))
                .forEach(printOutput());


//        ordered.entrySet().stream()
//                .sorted(Collections.reverseOrder(Comparator.comparingInt(k1 -> k1.getKey().length())))
//                .forEach(x -> System.out.print(x.getKey() + "\n"));
//
//        ordered..values().stream()
//                .sorted(kv -> kv.getKey().length()))
//                .forEach(y -> System.out.println(y));


    }

    static Consumer<? super Map.Entry<String, LinkedHashMap<String, String>>> printOutput() {
        return kv -> {
            System.out.println(kv.getKey());

            final int[] count = {0};
            kv.getValue().entrySet().stream()
                    .filter(r -> r.getValue().length() != 0)
                    .sorted((w1, w2) -> w1.getKey().length() - w2.getKey().length())
                    .forEach(y -> System.out.printf("%d. %s - %s%n", ++count[0], y.getKey(), y.getValue()));

            kv.getValue().entrySet().stream()
                    .filter(r -> r.getValue().length() == 0)
                    .forEach(z -> System.out.printf("%d. %s%n", ++count[0], z.getKey()));


        };
    }
}
