import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Vilcho on 8/13/2017.
 */
public class Ex_p03_ShoppingSpree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());

        LinkedHashMap<String, Double> productPrice = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("end")) {
            String product = "";
            Double prPrice = Double.valueOf(input[input.length-1]);
                for (int i = 0; i < input.length-1; i++) {
                    product = product + " " +(input[i]);
                }

            if (!productPrice.keySet().equals(product)) {
                productPrice.put(product, prPrice);
            } else {
                if (prPrice < productPrice.get(product)) {
                    productPrice.put(product, prPrice);
                }
            }
            input = scanner.nextLine().split(" ");
        }

//        LinkedHashMap<String, Double> sorted = new LinkedHashMap<>();

        double sum = productPrice.values().stream()
                .mapToDouble(Double::valueOf).sum();

        if (sum > budget) {
            System.out.println("Need more money... Just buy banichka");
        } else {

//http://www.java67.com/2015/01/how-to-sort-hashmap-in-java-based-on.html
            Comparator<Map.Entry<String, Double>> valueComparator = new Comparator<Map.Entry<String, Double>>() {

                @Override
                public int compare(Map.Entry<String, Double> e1, Map.Entry<String, Double> e2) {
                    Double v1 = e1.getValue();
                    Double v2 = e2.getValue();
                    return v2.compareTo(v1);
                }
            };
            Comparator<Map.Entry<String, Double>> keyLengthComparator = new Comparator<Map.Entry<String, Double>>() {
                @Override
                public int compare(Map.Entry<String, Double> e1, Map.Entry<String, Double> e2) {
                    String k1 = e1.getKey();
                    String k2 = e2.getKey();
                    return k1.length() - k2.length();
                }
            };

//            List<Map.Entry<String, Double>> listOfEntries = new ArrayList<Map.Entry<String, Double>>(productPrice.entrySet());

            productPrice.entrySet().stream().sorted(valueComparator.thenComparing(keyLengthComparator))
            .forEach(e -> System.out.printf("%s costs %.2f%n", e.getKey(), e.getValue()));
            //става и с
//            listOfEntries.sort(valueComparator.thenComparing(keyLengthComparator));
//
//            for (Map.Entry<String, Double> entry: listOfEntries) {
//                System.out.printf("%s costs %.2f%n", entry.getKey(), entry.getValue());
//            }



//            sorted =
//                    productPrice.entrySet().stream()
//                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//             //и после как да направя thenCompare...?
//                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
//            System.out.println(sorted);


        }


    }
}
