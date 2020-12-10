import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AdapterArrayTest {

  @Test
  void day10_part1_test() {
    AdapterArray aa = new AdapterArray();
    long res = aa.CountSkips();
    assertEquals(2376, res);
  }

  @Test
  void day10_part2_test() {
    AdapterArray aa = new AdapterArray();
    long res = aa.CountCombinations();
    assertEquals(129586085429248L, res);
  }
}
