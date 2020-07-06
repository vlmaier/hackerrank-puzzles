package problem_solving;

import java.io.*;
import java.util.*;


public class Kangaroo {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        int limit = Integer.MAX_VALUE - 1;
        boolean doKangaroosMeet = false;
        int difference = Integer.MAX_VALUE;
        for (int i = x1, j = x2; i <= limit && j <= limit; i = i + v1, j = j + v2) {
            if (i == j) {
                doKangaroosMeet = true;
            }
            if (i == j || j - i > difference) {
                break;
            } else {
                difference = j - i;
            }
        }
        return doKangaroosMeet ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);
        int v1 = Integer.parseInt(x1V1X2V2[1]);
        int x2 = Integer.parseInt(x1V1X2V2[2]);
        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
