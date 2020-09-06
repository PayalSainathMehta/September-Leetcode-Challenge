public class ImageOverlap {
    //TC - O(n ^ 4), where n = length of matrix.
    //SC - constant.

    //This method returns the number of matches, starti and startj are indexes of sliding matrix
    public int getMatchCount(int[][] A, int[][] B, int starti, int startj){
        int count = 0;
        int startbi = 0;
        int startbj = 0;
        int len = A.length;
        for(int i = starti; i < len; i++){
            startbj = 0;
            for(int j = startj; j < len; j++){
                if(A[i][j] == 1 && A[i][j] == B[startbi][startbj])
                    count++;
                startbj++;
            }
            startbi++;
        }
        return count;
    }

    public int getOverlap(int[][] A, int[][] B){
        int maxCount = 0;
        int len = A.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                //A is sliding, B is static ref
                maxCount = Math.max(maxCount, getMatchCount(A, B, i, j));
                //A is static ref, B is sliding
                maxCount = Math.max(maxCount, getMatchCount(B, A, i, j));
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[][] A = {{1,1,0},{0,1,0},{0,1,0}};
        int[][] B = {{0,0,0},{0,1,1},{0,0,1}};
        ImageOverlap obj = new ImageOverlap();
        System.out.println(obj.getOverlap(A, B));
    }
}
