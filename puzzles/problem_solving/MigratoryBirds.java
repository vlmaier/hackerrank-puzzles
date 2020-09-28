package problem_solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class MigratoryBirds {

    static int migratoryBirds(List<Integer> birdIds) {
        HashMap<Integer, Integer> sightedBirds = new HashMap<>();
        for (Integer id : birdIds) {
            if (sightedBirds.containsKey(id)) {
                Integer counter = sightedBirds.get(id) + 1;
                sightedBirds.put(id, counter);
            } else {
                sightedBirds.put(id, 1);
            }
        }
        return Collections.max(sightedBirds.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine()
                .replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
