import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PercolationTest{
    Percolation percolation;
    Percolation bigPercolation;
    
    @Before
    public void setUp() {
        percolation = new Percolation(2);
        bigPercolation = new Percolation(4);
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
    public void shouldknowIdOfSquare() {
        int actualId = percolation.findId(1,1);
        int expectedId = 2;
       
        assertEquals(expectedId, actualId);
    }
    
    @Test
    public void idShouldKnowItsRoot() {
        int actualId = percolation.findRootOfGrid(1,1);
        int expectedId = 2;
       
        assertEquals(expectedId, actualId);
    }
    
    @Test 
    public void unionShouldChangeRootiToRootJ() {
        percolation.union(0,1);
        int actualRootOfi = percolation.roots(1);
        int expectedRootOfi = 0;
        
        assertEquals(expectedRootOfi, actualRootOfi);
    }
    
    @Test
    public void shouldOnlyChangeRootOf() {
        bigPercolation.union(4,5);
        bigPercolation.union(2,1);
        bigPercolation.union(5,1);
        
        int actualRootOf2 = bigPercolation.roots(2);
        int expectedRootOf2 = 4;
        int actualRootOf1 = bigPercolation.roots(1);
        int expectedRootOf1 = 2;
        int actualRootOf5 = bigPercolation.roots(5);
        int expectedRootOf5 = 4;
        
        assertEquals(expectedRootOf2, actualRootOf2);
        assertEquals(expectedRootOf1, actualRootOf1);
        assertEquals(expectedRootOf5, actualRootOf5);
    }
    
    @Test
    public void directionOfUnionShouldBeWeighted() {
        bigPercolation.union(4,5);
        bigPercolation.union(2,1);
        bigPercolation.union(5,1);
        bigPercolation.union(3,5);
        
        int actualRootOf3 = bigPercolation.roots(3);
        int expectedRootOf3 = 4;
        int actualRootOf4 = bigPercolation.roots(4);
        int expectedRootOf4 = 4;
        
        assertEquals(expectedRootOf3, actualRootOf3);
        assertEquals(expectedRootOf4, actualRootOf4);
    }
}
