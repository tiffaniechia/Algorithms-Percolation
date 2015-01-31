public class Percolation {
    private boolean[][] grid;
    private int size;
    public int[] roots; 
    
    public Percolation(int N){
       grid = new boolean[N][N];
       size = N;
       roots = new int[N*N];
       for (int i=0;i<N*N;i++){roots[i]=i;};
    };
    
    public boolean[][] grid(){
      return grid;  
    }
    
    public int roots(int id) {
        return roots[id];    
    }
    
    public void open(int row, int col){
       grid[row][col] = true;        
    };
    
    public boolean isOpen(int row, int col){
       return grid[row][col];  
    };
    
    public int findNeighbours(int row,int col){
       int count = 0 ;
       if (row-1>=0 && isOpen(row-1,col)) { 
           count++; 
          //wqf grid[i-1][j];
       };
       if (col+1<size && isOpen(row,col+1)) {
           count++; 
           //wqf grid[i][j+1];
       };
       if (row+1<size && isOpen(row+1,col)) { 
           count++; 
          //wqf grid[i+1][j];
       };
       if (col-1>=0 && isOpen(row,col-1)) { 
           count++; 
           //wqf grid[i][j-1];
       };
       return count;     
    };
    
    public int findId(int row, int col) {
        return size-1 * row + col; 
    };
    
    public int findRootOfGrid(int row, int col) {
        int id = findId(row, col);
        return roots[id];  
    };
    
    public void union(int idi, int idj) {
        roots[idj] = roots[idi];    
    }
         
//    public boolean isFull(int i, int j){};
//    public boolean percolates(){};

    public static void main(String[] args){
    
    };
}