package problem_solving;

import java.io.*;
import java.util.*;

public class JumpingOnTheClouds {

    static int jumpingOnClouds(int[] clouds) {
        int amountOfJumps = 0;
        for (int i = 0; i < clouds.length - 1;) {
            int smallJump = i + 1;
            int bigJump   = i + 2;
            if (bigJump < clouds.length && clouds[bigJump] == 0) {
                i = bigJump;
            } else {
                i = smallJump;
            }
            amountOfJumps++;
        }
        return amountOfJumps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
