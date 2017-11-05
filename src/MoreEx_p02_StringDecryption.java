import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Vilcho on 11/4/2017.
 */
public class MoreEx_p02_StringDecryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] skipTake = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        List<Integer> input = Stream.of(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());

//        String result =
                input.stream()
                .filter(n -> n >= 65 && n <= 90)
                .skip(skipTake[0])
                .limit(skipTake[1])
                .mapToInt(Integer::valueOf)
                .forEach(s -> System.out.print((char)s));


//                .mapToObj(Integer::toString)
//                .map(Object::toString)
//                .collect(Collectors.joining(""));

        //System.out.println(result);

    }
}
