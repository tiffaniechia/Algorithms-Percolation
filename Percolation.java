public class Percolation {
    private boolean[][] grid;
    private int size;
    
    public Percolation(int N){
       grid = new boolean[N][N];
       size = N;
    };
    
    public boolean[][] grid(){
      return grid;  
    }
    
    public void open(int i, int j){
       grid[i][j] = true;        
    };
    
    public boolean isOpen(int i, int j){
       return grid[i][j];  
    };
    
    public int findNeighbours(int i,int j){
       int count = 0 ;
       if (i-1>=0 && isOpen(i-1,j)) { 
           count++; 
          //wqf grid[i-1][j];
       };
       if (j+1<size && isOpen(i,j+1)) {
           count++; 
           //wqf grid[i][j+1];
       };
       if (i+1<size && isOpen(i+1,j)) { 
           count++; 
          //wqf grid[i+1][j];
       };
       if (j-1>=0 && isOpen(i,j-1)) { 
           count++; 
           //wqf grid[i][j-1];
       };
       return count;     
    }
    
    public int findId(int i, int j) {
        return size-1 * i + j; 
    }
    
       
//    public boolean isFull(int i, int j){};
//    public boolean percolates(){};

    public static void main(String[] args){
    
    };
}