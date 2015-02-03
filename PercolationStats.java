import java.util.Random;

public class PercolationStats {
    Random rand = new Random();
    Percolation percolation;
    public int runCount = 0;
    public int randomRow;
    public int randomCol;
    public int gridSize;
    
    public PercolationStats(int N, int T) {
        percolation = new Percolation(N);
        gridSize = N*N;
        for(int i=0; i<T; i++){
            while(!percolation.percolates()) {
                randomRow = rand.nextInt(N);
                randomCol = rand.nextInt(N);
                percolation.open(randomRow,randomCol);
                
            }
            runCount++; 
        }
    };
    
    public int runCount() {
         return runCount;
    }
    
//    public double mean() {
//        runCount/gridSize;    
//    }                     
//   public double stddev()                    
//   public double confidenceLo()              
//   public double confidenceHi()              
   
}