// day 3 of 2020 advent of code
// https://adventofcode.com/2020/day/3

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TobogganTrajectory {

  private final List<String> data;
  private final int downSteps;
  private final int rightSteps;

  public TobogganTrajectory(int r, int d) {
    String report = new Scanner(ReportRepair.class.getResourceAsStream("day3_input.txt"),
        StandardCharsets.UTF_8).useDelimiter("\\A").next();
    data = Arrays.stream(report.split("\n")).collect(Collectors.toList());
    downSteps = d;
    rightSteps = r;
  }

  public long CountTrees() {
    int width = data.get(0).length();
    long treeNumber = 0;
    int currentWidth = 0;

    for (int i = 0; i < data.size(); i = i + downSteps) {
      if (data.get(i).charAt(currentWidth % width) == '#') {
        treeNumber += 1;
      }
      currentWidth += rightSteps;
    }
    return treeNumber;
  }
}
