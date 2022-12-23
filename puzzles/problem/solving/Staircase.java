package problem.solving;

import java.util.*;


public class Staircase {

    static void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            // Java 8 solution
            String whitespace = String.join("", Collections.nCopies(n - i, " "));
            String hash = String.join("", Collections.nCopies(i, "#"));
            System.out.println(whitespace + hash);
            // Java 11 solution
            // System.out.println(" ".repeat(n - i) + "#".repeat(i));
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
