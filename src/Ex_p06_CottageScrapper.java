import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Vilcho on 8/26/2017.
 */
public class Ex_p06_CottageScrapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, ArrayList<Integer>> stock = new LinkedHashMap<String, ArrayList<Integer>>();

        String input = scanner.nextLine();

        while (!input.equals("chop chop")) {
            String[] inputElements = input.split(" -> ");
            String type = inputElements[0];
            int length = Integer.parseInt(inputElements[1]);
            if (!stock.keySet().contains(type)) {
                stock.put(type, new ArrayList<Integer>());
            }
            stock.get(type).add(length);

            input = scanner.nextLine();
        }
        String refType = scanner.nextLine();
        int minL = Integer.parseInt(scanner.nextLine());

        System.out.println(stock);


        ArrayList<Integer> selectMaterial = new ArrayList<>();
        //selectMaterial =
        stock.entrySet().stream()
                .filter(x -> x.getKey().equals(refType))
                .forEach(r -> r.getValue().stream().map(Integer::valueOf).filter(z -> z >= 12)
                        .forEach(t -> selectMaterial.add(t)));

        System.out.println(selectMaterial);

//        ArrayList<Integer> test = new ArrayList<>();
//        test.add(4);
//        test.add(45);
//        test.add(11);
//        test.add(25);
//
//        System.out.println(test);
//
//        test.remove((Integer) 11);
//        System.out.println(test);

//        ArrayList<Integer> shortOfSelectedType = new ArrayList<>();
//        stock.entrySet().stream()
//                .filter(x -> x.getKey().equals(refType))
//                .forEach(r -> r.getValue().stream().map(Integer::valueOf).filter(z -> z >= 12)
//                        .forEach(p -> stock.get(refType).remove(p)));
////последния ред май само не работи...
//        System.out.println(stock);


    }
}

