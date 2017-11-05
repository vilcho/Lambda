import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Vilcho on 10/29/2017.
 */
public class MoreEx_p01_ArrayData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputInt = Stream.of(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        String remaining = scanner.nextLine();

        double average = 0;
        int remainingInt = 0;

        average = inputInt.stream().mapToInt(Integer::valueOf).average().getAsDouble();

        for (int i = 0; i < inputInt.size(); i++) {
            if (inputInt.get(i) < average){
                inputInt.remove(i);
                i = i-1;
            }
        }
        switch (remaining){
            case "Min":
                System.out.println(inputInt.stream().mapToInt(Integer::valueOf)
                        .min().getAsInt());
                break;
            case "Max":
                System.out.println(inputInt.stream().mapToInt(Integer::valueOf)
                        .max().getAsInt());
                break;
            case "All":
                System.out.println(inputInt.stream().sorted((a, b) -> {
                    return a - b;
                }).map(String::valueOf).collect(Collectors.joining(" ")));
                break;
        }
    }
}
