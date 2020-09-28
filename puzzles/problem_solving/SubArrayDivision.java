package problem_solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class SubArrayDivision {

    static int birthday(List<Integer> s, int d, int m) {
        if (m > s.size()) {
            return 0;
        }
        if (m == 1 && !s.contains(d)) {
            return 0;
        }
        int sum = s.stream().mapToInt(Integer::intValue).sum();
        if (d > sum) {
            return 0;
        }
        int counter = 0;
        for (int i = 0; i < s.size(); i++) {
            int partSum = 0;
            for (int j = i; j < m + i && j < s.size(); j++) {
                partSum += s.get(j);
            }
            if (partSum == d) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine()
                .replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String[] dm = bufferedReader.readLine()
                .replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);
        int m = Integer.parseInt(dm[1]);
        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
