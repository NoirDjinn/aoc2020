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
    String map = new Scanner(TobogganTrajectory.class.getResourceAsStream("day3_input.txt"),
        StandardCharsets.UTF_8).useDelimiter("\\A").next();
    this.data = Arrays.stream(map.split("\n")).collect(Collectors.toList());
    this.downSteps = d;
    this.rightSteps = r;
  }

  public long CountTrees() {
    int width = this.data.get(0).length();
    long treeNumber = 0;
    int currentWidth = 0;

    for (int i = 0; i < this.data.size(); i = i + this.downSteps) {
      if (this.data.get(i).charAt(currentWidth % width) == '#') {
        treeNumber += 1;
      }
      currentWidth += this.rightSteps;
    }
    return treeNumber;
  }
}
