import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        long res = rr.GetStarFishCoin();
        assertEquals(138688160, res);
    }
}
