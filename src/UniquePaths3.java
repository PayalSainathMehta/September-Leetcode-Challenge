public class UniquePaths3 {

    static int count = 0;
    static int empty = 1; //atleast one cell which we can walk on
    public static int uniquePathsIII(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int starti = 0;
        int startj = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0)
                    empty++;
                else if(grid[i][j] == 1)
                {
                    starti = i;
                    startj = j;
                }
            }
        }
        dfs(grid, starti, startj);
        return count;
    }

     static void dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] < 0)
            return; //all invalid cells
        if(grid[i][j] == 2)
        {
            if(empty == 0) //that means all empty cells traversed
                count++;
            return;
        }

        grid[i][j] = -2; //mark visited
        empty--; //as one covered

        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);

        grid[i][j] = 0; //backtrack
        empty++;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        System.out.println(uniquePathsIII(grid));
    }
}
