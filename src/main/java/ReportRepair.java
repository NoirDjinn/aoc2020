// day 1 of 2020 advent of code
// https://adventofcode.com/2020/day/1

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportRepair {

  private final List<Integer> data;
  private final int idealSum = 2020;

  public ReportRepair() {
    data = Utils.readInput(1).stream().map(Integer::parseInt).collect(Collectors.toList());
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

  public long GetStarfishCoin() {
    for (int i = 0; i < data.size() - 2; i++) {
      for (int j = i + 1; j < data.size() - 1; j++) {
        for (int k = j + 1; k < data.size(); k++) {
          if (data.get(i) + data.get(j) + data.get(k) == idealSum) {
            return data.get(i) * data.get(j) * data.get(k);
          }
        }
      }
    }
    return 0;
  }
}
