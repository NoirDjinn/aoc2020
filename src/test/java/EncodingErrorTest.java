import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EncodingErrorTest {

  @Test
  void day9_part1_test() {
    EncodingError ee = new EncodingError();
    long res = ee.FindFirstNotSum();
    assertEquals(23278925, res);
  }

  @Test
  void day9_part2_test() {
    EncodingError ee = new EncodingError();
    long res = ee.FindEncryptionWeakness();
    assertEquals(4011064, res);
  }
}
