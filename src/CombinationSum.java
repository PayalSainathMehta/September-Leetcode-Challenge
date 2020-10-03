import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    static List<List<Integer>> getCombinations(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, result, new ArrayList<Integer>());
        return result;
    }

    static void backtrack(int[] nums, int remaining, int start, List<List<Integer>> result, List<Integer> temp){
        if(remaining < 0) //invalid
            return;
        if(remaining == 0){ //all done
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(nums, remaining - nums[i], i, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        System.out.println(getCombinations(nums, target).toString());
    }
}
