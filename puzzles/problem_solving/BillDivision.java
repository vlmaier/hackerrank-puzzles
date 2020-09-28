package problem_solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class BillDivision {

    static void bonAppetit(List<Integer> bill, int k, int b) {
        bill.remove(k);
        int sum = bill.stream().mapToInt(Integer::intValue).sum();
        int splitCosts = sum / 2;
        if (splitCosts == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - splitCosts);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine()
                .replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
