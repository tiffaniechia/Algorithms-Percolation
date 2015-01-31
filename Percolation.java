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
    };
    
    public int findId(int i, int j) {
        return size-1 * i + j; 
    };
    
    public int findRootOfGrid(int i, int j) {
        int id = findId(i, j);
        return roots[id];  
    };
    
    public void union(int idi, int idj) {
        roots[idi] = idj;    
    }
    
    public int roots(int id) {
        return roots[id];    
    }
         
//    public boolean isFull(int i, int j){};
//    public boolean percolates(){};

    public static void main(String[] args){
    
    };
}