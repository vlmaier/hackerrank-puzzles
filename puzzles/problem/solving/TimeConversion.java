package problem.solving;

import java.io.*;
import java.util.*;


public class TimeConversion {

    static String timeConversion(String s) {
        String hours = s.substring(0, 2);
        String m = s.substring(s.length() - 2);
        String toReturn = s.substring(0, s.length() - 2);
        int hh = Integer.parseInt(hours);
        if (m.equals("AM")) {
            return hh == 12 ? toReturn.replace(hours, "00") : toReturn;
        } else {
            return hh == 12 ? toReturn : toReturn.replace(hours, String.valueOf(hh + 12));
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
