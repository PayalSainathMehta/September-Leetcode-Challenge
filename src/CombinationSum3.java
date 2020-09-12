import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    //return list of all unique combinations of k numbers which add upto n
    static List<List<Integer>> getCombinations(int k, int n){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), k, n, 1); //as digits 1 - 9
        return result;
    }

    static void backtrack(List<List<Integer>> result, List<Integer> temp, int k, int n, int start){
        if(temp.size() == k && n == 0){//we found it
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i <= 9; i++){
            temp.add(i);
            backtrack(result, temp, k, n - i, i + 1);
            temp.remove(temp.size() - 1); //backtrack
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        System.out.println(getCombinations(k, n).toString());
    }
}
