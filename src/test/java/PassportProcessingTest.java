import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassportProcessingTest {

  @Test
  void day4_part1_test() {
    PassportProcessing pp = new PassportProcessing();
    long res = pp.CountValidPassports();
    assertEquals(250, res);
  }

  @Test
  void day4_part2_test() {
    PassportProcessing pp = new PassportProcessing();
    long res = pp.CountValidPassportData();
    assertEquals(158, res);
  }
}