package problem.solving;

import java.util.Arrays;
import java.util.Scanner;


public class MiniMaxSum {

    static void miniMaxSum(int[] arr) {
        long[] origin = Arrays.stream(arr).mapToLong(i -> i).toArray();
        long minValue = Arrays.stream(origin).min().orElse(0);
        long maxValue = Arrays.stream(origin).max().orElse(0);
        long sum = Arrays.stream(origin).sum();
        System.out.printf("%d %d%n", sum - maxValue, sum - minValue);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
