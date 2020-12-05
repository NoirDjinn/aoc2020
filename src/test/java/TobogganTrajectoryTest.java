import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TobogganTrajectoryTest {

  @Test
  void day3_part1_test() {
    TobogganTrajectory tt = new TobogganTrajectory(3, 1);
    long res = tt.CountTrees();
    assertEquals(200, res);
  }

  @Test
  void day3_part2_test() {
    TobogganTrajectory tt31 = new TobogganTrajectory(3, 1);
    TobogganTrajectory tt11 = new TobogganTrajectory(1, 1);
    TobogganTrajectory tt51 = new TobogganTrajectory(5, 1);
    TobogganTrajectory tt71 = new TobogganTrajectory(7, 1);
    TobogganTrajectory tt12 = new TobogganTrajectory(1, 2);
    long res = tt31.CountTrees() * tt11.CountTrees() * tt51.CountTrees() * tt71.CountTrees() * tt12
        .CountTrees();
    assertEquals(3737923200L, res);
  }
}
