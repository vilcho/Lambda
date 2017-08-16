import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Vilcho on 8/2/2017.
 */
public class Lab_p01_SumMinMaxAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> collection = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());

            collection.add(num);
        }

        int sum = collection.stream().mapToInt(Integer::valueOf).sum();
        int min = collection.stream().mapToInt(Integer::valueOf).min().getAsInt();
        //или
        int min1 = collection.stream().min(Integer::compareTo).get();
        int max = collection.stream().max(Integer::compareTo).get();
        double average = collection.stream().mapToInt(Integer::valueOf).average().getAsDouble();

        System.out.println("Sum = " + sum);
        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
        System.out.println("Average = " + average);
    }
}
