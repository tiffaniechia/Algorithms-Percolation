import junit.framework.TestCase;
import static org.junit.Assert.*;

public class PercolationTest extends TestCase {
    
    public void testPercolationInitializesWithNByNGrid() {
        Percolation percolation = new Percolation(2);
        boolean[][] actualIndex = percolation.grid();
        boolean[][] expectedIndex = new boolean[2][2];
        
        assertArrayEquals(expectedIndex, actualIndex);    
    }
    
    public void testOpeningGrid() {
        Percolation percolation = new Percolation(2);
        percolation.open(0,0);
        
        assertTrue(percolation.isOpen(0,0));
        assertFalse(percolation.isOpen(1,1));
    }
}
