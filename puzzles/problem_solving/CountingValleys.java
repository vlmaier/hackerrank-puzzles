package problem_solving;

import java.io.*;
import java.util.*;


public class CountingValleys {

    static int countingValleys(int n, String s) {
        int seaLevel = 0;
        int valleyCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'D') {
                seaLevel--;
            }
            if (s.charAt(i) == 'U') {
                seaLevel++;
            }
            if (seaLevel == 0 && s.charAt(i) == 'U') {
                valleyCount++;
            }
        }
        return valleyCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}