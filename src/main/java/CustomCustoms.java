// day 6 of 2020 advent of code
// https://adventofcode.com/2020/day/6

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomCustoms {

  private final List<String> answers = new ArrayList<>();

  public CustomCustoms() {
    List<String> data = Utils.readInput(6);
    data.add("\n");

    StringBuilder currentGroup = new StringBuilder();
    String currentAnswer;

    for (String line : data) {
      currentAnswer = line.strip().replace("\n", "");
      if (currentAnswer.equals("")) {
        answers.add(currentGroup.toString());
        currentGroup.setLength(0);
      } else {
        currentGroup.append(currentAnswer);
        currentGroup.append("#");
      }
    }
  }

  public long CountSum() {
    return answers.stream().map(t -> t.chars().distinct().count() - 1).reduce(0L, Long::sum);
  }

  public long CountAll() {
    long res = 0;
    String[] t;
    char[] ch;
    HashMap<Character, Integer> seen;
    int groupCount;

    for (String ans : answers) {
      t = ans.split("#");
      groupCount = t.length;
      seen = new HashMap<>();

      for (int i = 0; i < groupCount; i++) {
        ch = t[i].replace("#", "").toCharArray();
        for (Character c : ch) {
          if (seen.containsKey(c)) {
            seen.put(c, seen.get(c) + 1);
          } else {
            seen.put(c, 1);
          }
        }
      }

      for (Map.Entry<Character, Integer> entry : seen.entrySet()) {
        if (entry.getValue().equals(groupCount)) {
          res += 1;
        }
      }

    }

    return res;
  }
}
