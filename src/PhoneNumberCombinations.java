import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCombinations {

    static final int MAX_PHONE_LENGTH = 7;
    static final int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};

    static List<String> phoneCombinations(int[][] board, int sr, int sc){
        List<String> result = new ArrayList<>();
        if(isNull(board) || !isSafe(board, sr, sc))
            return result;
        StringBuilder phone = new StringBuilder(MAX_PHONE_LENGTH);
        phone.append(board[sr][sc]);
        phoneCombinations(board, phone, result, sr, sc);
        return result;
    }

    static void phoneCombinations(int[][] board, StringBuilder phone, List<String> result, int sr, int sc){
        if(phone.length() == MAX_PHONE_LENGTH){
            result.add(phone.toString());
            return;
        }
        for(int[] dir: dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];

            if(isSafe(board, nr, nc)){
                phone.append(board[nr][nc]);
                phoneCombinations(board, phone, result, nr, nc);
                phone.setLength(phone.length() - 1);
            }
        }
    }

    static boolean isNull(int[][] board){
        return board.length == 0 || board == null;
    }

    static boolean isSafe(int[][] board, int r, int c){
        return r < board.length - 1 && r >= 0 && c >= 0 && c < board[0].length - 1;
    }

    public static void main(String[] args) {
        int[][] board = {{1,2,3},{4,5,6},{7,8,9}};
        int sr = 1;
        int sc = 0;
        System.out.println(phoneCombinations(board, sr, sc).toString());
    }
}
