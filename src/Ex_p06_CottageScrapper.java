import java.math.RoundingMode;
import java.text.DecimalFormat;
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

//        System.out.println(stock);

        int sumOfAllLogs = 0;
        double pricePerMeter = 0.0;

        for (ArrayList<Integer> arrayOfValues : stock.values()) {
            sumOfAllLogs += arrayOfValues.stream().mapToInt(Integer::valueOf).sum();
        }
//        System.out.println(sumOfAllLogs);

        int logCountTotal = 0;
        for (ArrayList<Integer> valueArr : stock.values()) {
            logCountTotal += valueArr.size();
        }
        // System.out.println(logCountTotal);

//        втори вариант за смятанане на общия брой дърва
//        int totalLogs = stock.values().stream().mapToInt(List::size).sum();
//        System.out.println(totalLogs);

        DecimalFormat df = new DecimalFormat("###################.00");
        pricePerMeter = (double) sumOfAllLogs / logCountTotal;
        double pricePerMeterRounded = Double.valueOf(df.format(pricePerMeter));
//        System.out.println(pricePerMeterRounded);

//                df.setRoundingMode(RoundingMode.CEILING);
        System.out.printf("Price per meter: $%.2f%n", pricePerMeterRounded);

        ArrayList<Integer> selectMaterial = new ArrayList<>();
        //selectMaterial =
        stock.entrySet().stream()
                .filter(x -> x.getKey().equals(refType))
                .forEach(r -> r.getValue().stream().map(Integer::valueOf).filter(z -> z >= minL)
                        .forEach(t -> selectMaterial.add(t)));

//        System.out.println(selectMaterial);

        for (int i = 0; i < stock.get(refType).size(); i++) {
            if (stock.get(refType).get(i) >= minL) {
                stock.get(refType).remove(i);
                i=i-1;
            }
        }

//        System.out.println(stock);
//        System.out.println(selectMaterial);

        double usedLogsPrice = 0.0;
        usedLogsPrice = (selectMaterial.stream().mapToInt(Integer::valueOf).sum())*pricePerMeterRounded;
        double usedLogsPriceRounded = (Math.round(usedLogsPrice*100)) / 100.0;
        System.out.printf("Used logs price: $%.2f%n", usedLogsPriceRounded);

        int sumOfAllUnusedLogs = 0;
        for (ArrayList<Integer> arrayOfUnusedLogsValues : stock.values()) {
            sumOfAllUnusedLogs += arrayOfUnusedLogsValues.stream().mapToInt(Integer::valueOf).sum();
        }
        double unusedLogsPrice = 0;
        unusedLogsPrice = sumOfAllUnusedLogs*pricePerMeterRounded*0.25;
        System.out.printf("Unused logs price: $%.2f%n", unusedLogsPrice);

        double subtotal = 0;
        subtotal = usedLogsPriceRounded + unusedLogsPrice;
        System.out.printf("CottageScraper subtotal: $%.2f", subtotal);
    }
}

