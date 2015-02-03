import java.util.Random;

public class PercolationStats {
    Random rand = new Random();
    Percolation percolation;
    public int runCount = 0;
    public int randomRow;
    public int randomCol;
    
    public PercolationStats(int N, int T) {
        percolation = new Percolation(N); 

        while(!percolation.percolates() && runCount < T) {
            randomRow = rand.nextInt(N);
            randomCol = rand.nextInt(N);
            percolation.open(randomRow,randomCol);
            runCount++; 
        }
        
    };
    
    public int runCount() {
         return runCount;
    }
    
//   public double mean()                     
//   public double stddev()                    
//   public double confidenceLo()              
//   public double confidenceHi()              
   
}