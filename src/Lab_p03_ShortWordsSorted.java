import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Vilcho on 8/3/2017.
 */
public class Lab_p03_ShortWordsSorted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String separator = "[.,:;()\\[\\]\"'\\/!? ]";
        String[] words = scanner.nextLine().toLowerCase().split(separator);

        System.out.println(Arrays.stream(words).distinct().filter(w -> w.length() < 5).filter(w -> !w.isEmpty()).sorted(Comparator.naturalOrder()).map(Object::toString).collect(Collectors.joining(", ")));
    }
}
