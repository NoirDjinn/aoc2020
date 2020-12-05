import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinaryBoardingTest {

  @Test
  void day5_part1_test() {
    BinaryBoarding bb = new BinaryBoarding();
    long res = bb.GetMaxID();
    assertEquals(894, res);
  }

  @Test
  void day5_part2_test() {
    BinaryBoarding bb = new BinaryBoarding();
    long res = bb.FindMissingID();
    assertEquals(579, res);
  }
}
