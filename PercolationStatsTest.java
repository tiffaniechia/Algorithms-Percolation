import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PercolationStatsTest {
    PercolationStats percolationStats;
    Percolation percolation;
    
    @Before
    public void setUp() {
        percolationStats = new PercolationStats(10,4);    
    }
    
    @Test
    public void shouldRunOnlyUntilPercolates() {
        int actualRuns = percolationStats.runCount();
        int expectedRuns = 4;
 
        assertEquals(expectedRuns, actualRuns); 
    }

}
