import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Vilcho on 8/22/2017.
 */
public class Ex_p05_FlattenDictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, String>> ordered = new LinkedHashMap<String, LinkedHashMap<String, String>>();

        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("flatten")){

            if (!ordered.keySet().contains(input[0])){
                ordered.put(input[0], new LinkedHashMap<String, String>());
            }
            ordered.get(input[0]).put(input[1], input[2]);

            input = scanner.nextLine().split(" ");
        }

        ordered.entrySet().stream()
                .filter()
    }
}
