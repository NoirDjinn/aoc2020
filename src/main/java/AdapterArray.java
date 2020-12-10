// day 10 of 2020 advent of code
// https://adventofcode.com/2020/day/10

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdapterArray {

  private final List<Long> adapters;

  public AdapterArray() {
    this.adapters = Utils.readInput(10).stream().map(Long::parseLong).collect(Collectors.toList());
    Optional<Long> mx = this.adapters.stream().max(Long::compare);
    this.adapters.add(0L);
    this.adapters.add(mx.orElse(0L) + 3); //your adapter
  }

  public long mapSequence(long seq) {
    if (seq == 2) {
      return 2;
    }
    if (seq == 3) {
      return 4;
    }
    if (seq == 4) {
      return 7;
    }
    return 1;
  }

  public long CountSkips() {
    List<Long> diffs = new ArrayList<>(adapters);
    diffs.sort(Long::compare);

    Map<Long, Long> counter = new HashMap<>();
    Long key;

    for (int i = 1; i < diffs.size(); i++) {
      key = diffs.get(i) - diffs.get(i - 1);
      counter.put(key, counter.getOrDefault(key, 0L) + 1L);
    }

    return counter.get(1L) * counter.get(3L);
  }

  public long CountCombinations() {
    List<Long> diffs = new ArrayList<>(adapters);
    diffs.sort(Long::compare);

    long combinations = 1L;
    long sequence = 0L;
    long key;

    for (int i = 1; i < diffs.size(); i++) {
      key = diffs.get(i) - diffs.get(i - 1);
      if (key == 1) {
        sequence += 1;
      } else {
        combinations *= mapSequence(sequence);
        sequence = 0;
      }
    }

    return combinations;
  }
}
