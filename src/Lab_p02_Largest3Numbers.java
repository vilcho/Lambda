import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Vilcho on 8/3/2017.
 */
public class Lab_p02_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));

        System.out.println(nums.stream().sorted((a, b) -> {
            return b - a;
        }).limit(3).map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
