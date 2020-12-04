import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Utils {

  public static int parseInt(String input, int defaultValue) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  public static List<String> readInput(int day) {
    String fileName = "day" + day + "_input.txt";
    String map = new Scanner(Utils.class.getResourceAsStream(fileName),
        StandardCharsets.UTF_8).useDelimiter("\\A").next();
    return Arrays.stream(map.split("\n")).collect(Collectors.toList());
  }
}
