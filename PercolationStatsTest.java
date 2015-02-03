import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PercolationStatsTest {
    
    @Test
    public void shouldRunTNumberOfTimes() {
    PercolationStats percolationStats = new PercolationStats(10,10);
    int actualRuns = percolationStats.runCount();
    int expectedRuns = 10;
    
    assertEquals(expectedRuns, actualRuns);
    }
    
}
