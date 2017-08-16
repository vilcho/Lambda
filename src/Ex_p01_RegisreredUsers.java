import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;

/**
 * Created by Vilcho on 8/3/2017.
 */
public class Ex_p01_RegisreredUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" -> ");

        LinkedHashMap<String, Date> userRegistry = new LinkedHashMap<String, Date>();

        Date theDate = new Date();
        while (!input[0].equals("end")) {

            theDate = getDateFromString(input[1], theDate);

            userRegistry.put(input[0], theDate);

            input = scanner.nextLine().split(" -> ");
        }

        LinkedHashMap<String, Date> afterReverse = new LinkedHashMap<String, Date>();

        List<String> reversedKeys = new ArrayList<String>(userRegistry.keySet());
        for (int i = reversedKeys.size() - 1; i >= 0 ; i--) {
            afterReverse.put(reversedKeys.get(i), userRegistry.get(reversedKeys.get(i)));
        }

        LinkedHashMap<String, Date> after1Sort = new LinkedHashMap<String, Date>();

        after1Sort = afterReverse.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

        LinkedHashMap<String, Date> result = new LinkedHashMap<String, Date>();
        result = after1Sort.entrySet().stream()
                .limit(5)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

        for (Map.Entry<String, Date> kvp : result.entrySet()) {
            System.out.println(kvp.getKey());
        }

//        int oldest5Dates = findIntOfOldDates(alltheDates);
//
//        String[] result = new String[5];

//        LinkedHashMap<String, Date> result = new LinkedHashMap<>();
//
//        userRegistry.entrySet().stream()
//                .sorted(userRegistry.values().stream()
//                        .sorted(getSortByAscendingDatesComparator(userRegistry.values())))
//                .limit(oldest5Dates)
//                .forEach(uR -> result.put(uR.getKey(), uR.getValue()));
//
//        LinkedHashMap<String, Integer> entOrdofRes= new LinkedHashMap<>();
//        int index = 0;
//        for (String name : result.keySet()) {
//            entOrdofRes.put(name, index++);
//        }
//
//        List<String> finalResult = new ArrayList<>();


        }

//    static Comparator<? super LinkedHashMap<Integer,Date>> getSortByAscendingDatesComparator(Collection<LinkedHashMap<Integer, Date>> values) {
//        return values;
//    }

//
//    static int findIntOfOldDates(List<Date> alltheDates) {
//        int coutDates = 5;
//        alltheDates = alltheDates.stream().sorted().collect(Collectors.toList());
//        for (int i = 5; i < alltheDates.size(); i++) {
//            if (alltheDates.get(i).equals(alltheDates.get(i-1))){
//                coutDates++;
//            } else {
//                break;
//            }
//        }
//
//        return coutDates;
//    }





    static Date getDateFromString(String dateAsString, Date someDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            someDate = formatter.parse(dateAsString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return someDate;
    }
}
