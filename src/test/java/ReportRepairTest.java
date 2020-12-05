import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReportRepairTest {

  private static ReportRepair rr;

  public ReportRepairTest() {
    rr = new ReportRepair();
  }

  @Test
  void day1_part1_test() {
    long res = rr.FindEntries();
    assertEquals(445536, res);
  }

  @Test
  void day1_part2_test() {
    long res = rr.GetStarfishCoin();
    assertEquals(138688160, res);
  }
}
