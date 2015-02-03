import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PercolationStatsTest {
    PercolationStats percolationStats;
    
    @Before
    public void setUp() {
        percolationStats = new PercolationStats(10,4);    
    }
    
//    @Test
//    public void shouldRunOnlyUntilPercolates() {
//        double actualRuns = percolationStats.runCount();
//        double expectedRuns = 4; 
//        
//        assertEquals(expectedRuns, actualRuns, 0.001); 
//    }

}
