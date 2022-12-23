package problem.solving;

import java.util.*;


public class PlusMinus {

    static void plusMinus(int[] arr) {
        int cntPositives = 0;
        int cntNegatives = 0;
        int cntZeros = 0;
        for (int i : arr) {
            if (i > 0) {
                cntPositives++;
            } else if (i < 0) {
                cntNegatives++;
            } else {
                cntZeros++;
            }
        }
        double length = arr.length;
        print(cntPositives / length);
        print(cntNegatives / length);
        print(cntZeros / length);
    }

    static void print(double value) {
        System.out.printf("%.6f%n", value);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
