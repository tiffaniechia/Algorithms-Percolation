import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PercolationTest{
    Percolation percolation;
    
    @Before
    public void setUp() {
        percolation = new Percolation(2);    
    }
    
    @Test
    public void ensurePercolationInitializesWithNByNGrid() {
        boolean[][] actualIndex = percolation.grid();
        boolean[][] expectedIndex = new boolean[2][2];
        
        assertArrayEquals(expectedIndex, actualIndex);    
    }
    
    @Test
    public void squareOpensWhenCalled() {
        percolation.open(0,0);
        
        assertTrue(percolation.isOpen(0,0));
        assertFalse(percolation.isOpen(1,1));
    }
    
    @Test
    public void shouldOnlyRecognizeOpenNeighbours() {
        //count as an intermediary test method to curate logic
        percolation.open(0,1);
        int actualNumberOfNeighbours = percolation.findNeighbours(0,0);
        int expectedNumberOfNeighbours = 1;
        
        assertEquals(expectedNumberOfNeighbours,actualNumberOfNeighbours);
    }
    
    @Test
    public void shouldknowIdOfSqaure() {
       int actualId = percolation.findId(1,1);
       int expectedId = 2;
       
       assertEquals(expectedId, actualId);
    }
    
}
