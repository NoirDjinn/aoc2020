// day 7 of 2020 advent of code
// https://adventofcode.com/2020/day/7

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandyHaversacks {

  private final Map<String, Map<String, Integer>> rules = new HashMap<>();
  private final static String targetColor = "shiny gold";
  private final static String outerRegex = "^(.+) bags contain (.+)\\.$";
  private final static String innerRegex = "^(\\d+) (.+) bags?$";


  public HandyHaversacks() {
    List<String> data = Utils.readInput(7);

    for (String line : data) {
      Matcher matcher = Pattern.compile(outerRegex).matcher(line);

      if (matcher.find()) {
        Map<String, Integer> innerMap = rules
            .computeIfAbsent(matcher.group(1), s -> new HashMap<>());

        for (String element : matcher.group(2).split(", ")) {
          matcher = Pattern.compile(innerRegex).matcher(element);

          if (matcher.find()) {
            innerMap.put(matcher.group(2), Integer.parseInt(matcher.group(1)));
          }
        }
      }
    }
  }

  private static boolean containsGold(Map<String, Map<String, Integer>> rules, String bagColor) {
    return bagColor.equals(targetColor) || rules.getOrDefault(bagColor, Map.of()).keySet().stream()
        .anyMatch(b -> containsGold(rules, b));
  }

  private static int nestedCount(Map<String, Map<String, Integer>> rules, String bagColor) {
    return 1 + rules.getOrDefault(bagColor, Map.of()).entrySet().stream()
        .mapToInt(e -> e.getValue() * nestedCount(rules, e.getKey()))
        .sum();
  }


  public long CountGold() {
    return rules.keySet().stream().filter(color -> containsGold(rules, color)).count() - 1;
  }

  public long CountNested() {
    return nestedCount(this.rules, targetColor) - 1;
  }

}
