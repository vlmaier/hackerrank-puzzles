package problem.solving;

import java.io.*;
import java.util.*;


public class BreakingTheRecords {

    static int[] breakingRecords(int[] scores) {
        if (scores.length == 0) {
            return new int[]{0, 0};
        }
        int highScore = scores[0];
        int lowScore = scores[0];
        int highScoreBeaten = 0;
        int lowScoreBeaten = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > highScore) {
                highScore = scores[i];
                highScoreBeaten++;
            }
            if (scores[i] < lowScore) {
                lowScore = scores[i];
                lowScoreBeaten++;
            }
        }
        return new int[]{highScoreBeaten, lowScoreBeaten};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
