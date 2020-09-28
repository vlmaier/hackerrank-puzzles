package problem_solving;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;


public class DrawingBook {

    static int pageCount(int n, int p) {
        // check for penultimate page
        if (n - p == 1 && n % 2 == 0 && p != 1) {
            return 1;
        }
        // open the book at the beginning
        if (p <= n / 2) {
            return p / 2;
        // open the book at the end
        } else {
            return (n - p) / 2;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
