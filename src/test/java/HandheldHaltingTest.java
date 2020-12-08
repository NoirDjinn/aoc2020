import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HandheldHaltingTest {

  @Test
  void day8_part1_test() {
    HandheldHalting hh = new HandheldHalting();
    long res = hh.part1();
    assertEquals(1949, res);
  }

  @Test
  void day8_part2_test() {
    HandheldHalting hh = new HandheldHalting();
    long res = hh.part2();
    assertEquals(2092, res);
  }
}
