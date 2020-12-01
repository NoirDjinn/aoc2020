// day 1 of 2020 advent of code
// https://adventofcode.com/2020/day/1

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class ReportRepair {

    private final List<Integer> data;
    private final int idealSum = 2020;

    public ReportRepair() {
        String report = new Scanner(ReportRepair.class.getResourceAsStream("day1_input.txt"), StandardCharsets.UTF_8).useDelimiter("\\A").next();
        data = Arrays.stream(report.split("\n")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public long FindEntries() {
        Set<Integer> remainders = new HashSet<>();
        int rem;

        for (Integer num : data) {
            rem = Math.abs(idealSum - num);
            if (remainders.size() > 0 && remainders.contains(rem)) {
                return num * rem;
            } else {
                remainders.add(num);
            }
        }
        return 0;
    }

    public long GetStarFishCoin() {
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.size(); j++) {
                for (int k = 0; k < data.size(); k++) {
                    if (k != i && k != j && i != j && (data.get(i) + data.get(j) + data.get(k)) == idealSum) {
                        return data.get(i) * data.get(j) * data.get(k);
                    }
                }
            }
        }
        return 0;
    }
}
