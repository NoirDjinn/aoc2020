import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PasswordPhilosophyTest {

  private static PasswordPhilosophy pp;

  public PasswordPhilosophyTest() {
    pp = new PasswordPhilosophy();
  }

  @Test
  void day2_part1_test() {
    long res = pp.countCorrectPasswords();
    assertEquals(416, res);
  }

  @Test
  void day2_part2_test() {
    long res = pp.countValidPasswords();
    assertEquals(688, res);
  }
}
