import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CustomCustomsTest {

  @Test
  void day6_part1_test() {
    CustomCustoms cc = new CustomCustoms();
    long res = cc.CountSum();
    assertEquals(6809, res);
  }

  @Test
  void day6_part2_test() {
    CustomCustoms cc = new CustomCustoms();
    long res = cc.CountAll();
    assertEquals(3394, res);
  }
}
