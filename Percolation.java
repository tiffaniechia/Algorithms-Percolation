public class Percolation {
    private boolean[][] grid;
    
    public Percolation(int N){
       grid = new boolean[N][N];
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
    
//    public boolean isFull(int i, int j){};
//    public boolean percolates(){};

    public static void main(String[] args){
    
    };
}