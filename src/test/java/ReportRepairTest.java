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
        assertEquals(res, 445536);
    }

    @Test
    void day1_part2_test() {
        long res = rr.GetStarFishCoin();
        assertEquals(res, 1337);
    }
}
