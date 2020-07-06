package problem_solving;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;


public class BetweenTwoSets {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        Integer lcm = lcm(a);
        Integer gcd = gcd(b);
        int count = 0;
        for (int i = lcm, factor = 2; i <= gcd; i = lcm * factor, factor++) {
            // find amount of multiples of LCM evenly divided by GCD
            if (gcd % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static Integer gcd(Integer a, Integer b) {
        if (b == 0) {
            return a;
        } else {
            return (gcd(b, a % b));
        }
    }

    public static Integer gcd(List<Integer> input) {
        Integer result = input.get(0);
        for(Integer i : input) {
            result = gcd(result, i);
        }
        return result;
    }

    public static Integer lcm(Integer a, Integer b) {
        return a * (b / gcd(a, b));
    }

    public static Integer lcm(List<Integer> input) {
        Integer result = input.get(0);
        for(Integer i : input) {
            result = lcm(result, i);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt).collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt).collect(toList());

        int total = getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
