import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Vilcho on 8/3/2017.
 */
public class Lab_p04_FoldAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));

        int k = input.size() / 4;

        List<Integer> leftPart = input.stream().limit(k).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(leftPart);
        List<Integer> rightPart = input.stream().skip(3*k).collect(Collectors.toList());
        Collections.reverse(rightPart);
        leftPart.addAll(rightPart);

        List<Integer> downPart = input.stream().skip(k).limit(2*k).collect(Collectors.toList());

        List<Integer> sumList = new ArrayList<>();

        for (int i = 0; i < downPart.size(); i++) {
            sumList.add(leftPart.get(i) + downPart.get(i));
        }

        System.out.println(sumList.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
