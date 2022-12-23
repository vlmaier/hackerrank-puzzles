package problem.solving;

import java.io.*;
import java.util.*;


public class RepeatedString {

    static long repeatedString(String s, long n) {
        long countAsInSingleString = countAs(s, 0, s.length());
        long countAsInConcatString = n / s.length() * countAsInSingleString;
        long rest = n % s.length();
        return countAsInConcatString + countAs(s, 0, (int) rest);
    }

    static long countAs(String s, int fromIndex, int toIndex) {
        return s.substring(fromIndex, toIndex).chars().filter(c -> c == 'a').count();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
