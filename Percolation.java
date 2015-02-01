public class Percolation {
    private boolean[][] grid;
    private int size;
    private int[] roots;
    
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
       loveThyNeighbours(row,col);
    };
    
    public boolean isOpen(int row, int col){
       return grid[row][col];  
    };
    
    private void loveThyNeighbours(int row,int col){;
       int selfId = findId(row,col);
       if (row-1>=0 && isOpen(row-1,col)) { 
           int topNeighbourId = findId(row-1,col);
           union(selfId,topNeighbourId);
       };
       if (col+1<size && isOpen(row,col+1)) {
           int rightNeighbourId = findId(row,col+1);
           union(selfId,rightNeighbourId);
       };
       if (row+1<size && isOpen(row+1,col)) { 
           int bottomNeighbourId = findId(row+1,col);
           union(selfId,bottomNeighbourId);
       };
       if (col-1>=0 && isOpen(row,col-1)) { 
           int leftNeighbourId = findId(row,col-1);
           union(selfId,leftNeighbourId);
       };    
    };
    
    public int findId(int row, int col) {
        return (size) * row + col; 
    };
    
    public void union(int idi, int idj) {
       if(forestSize(idi) >= forestSize(idj)) {
            roots[findRoot(idj)] = roots[findRoot(idi)];
        } else {
           roots[findRoot(idi)] = roots[findRoot(idj)];
        }    
    }
    
    private int findRoot(int id) {
        int idRoot = roots[id];
        while ( idRoot != id ) {
            id = roots[id];
            idRoot = roots[roots[idRoot]];
        };
        return idRoot;  
    }  
 
    public int forestSize(int id) {
        int counter=0;
        int root = findRoot(id);
        for(int i=0;i<size*size;i++) {
            if(findRoot(i) == root) {
                counter++;
            }    
        }
        return counter;
    }
         
    public boolean isFull(int row, int col) {
        int id = findId(row,col);
        return forestSize(id) > 1;
    };
    
//    public boolean percolates(){};

}