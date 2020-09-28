package problem_solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class DayOfTheProgrammer {

    static String dayOfProgrammer(int year) {
        // Julian Calendar
        if (year >= 1700 && year <= 1917) {
            return "1" + (year % 4 == 0 ? "2" : "3") + ".09." + year;
        // Transition Year (14th Feb. is the 32nd day)
        } else if (year == 1918) {
            // 13 days offset
            return "26.09.1918";
        // Gregorian Calendar
        } else {
            return "1" + ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? "2" : "3") + ".09." + year;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
