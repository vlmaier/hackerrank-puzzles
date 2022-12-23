package problem.solving;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class GradingStudents {

    static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> resultGrades = new ArrayList<>();
        grades.forEach(grade -> {
            if (grade < 38) {
                resultGrades.add(grade);
            } else if (grade % 5 >= 3) {
                resultGrades.add(grade + (5 - grade % 5));
            } else {
                resultGrades.add(grade);
            }
        });
        return resultGrades;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(toList());

        List<Integer> result = gradingStudents(grades);

        bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
