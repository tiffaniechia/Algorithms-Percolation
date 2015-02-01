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
        return (size-1)* row + col; 
    };
    
    public int findRootOfGrid(int row, int col) {
        int id = findId(row, col);
        return roots[id];  
    };
    
    public void union(int idi, int idj) {
       if(sizeOfForest(idi) >= sizeOfForest(idj)) {
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
    
    private int sizeOfForest(int id) {
        int nodes = 1;
        int idRoot = roots[id];
        while ( idRoot != id ) {
            id = roots[id];
            idRoot = roots[roots[idRoot]];
            nodes++;
        };
        
        return nodes;
        //needs to take into account from tip
        //needs to take into account other branches
    }
    
    private boolean isRoot(int id) {
        return roots[roots[id]] == id;
    }
    
    private boolean isLastChild(int id) {
        Boolean isLast = false;
        for(int i = 0; i < size*size; i++) {
            if( (roots[i] == id) && (i != id)) { 
                isLast = false;
                break;
            } 
        }
        return isLast;
    }   
         
    private int findLastChildOfForest(int id) {
        while ( !isLastChild(id) ) { 
            for (int i = 0; i < size*size; i++) {
                id = i;                
            }    
        }
        return id;
    }
    
    private boolean isParentOfABranch(int id) {
        int count = 0;
        for (int i = 0; i < size*size; i++) {
            if(roots[i] == id && !isRoot(id)) {
                count++;
            }                    
        }
        return count > 1;
    }
    
    
         
//    public boolean isFull(int i, int j){};
    
//    public boolean percolates(){};

    public static void main(String[] args){
    
    };
}