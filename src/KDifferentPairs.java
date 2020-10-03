import java.util.HashMap;
import java.util.Map;

public class KDifferentPairs {

    static int getKDiffPairs(int[] nums, int k){
        int n = nums.length;
        if(nums == null || n == 0)
            return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele: nums)
            map.put(ele, map.getOrDefault(ele, 0) + 1);

        //entry set - 2 conditions - elements appearing more than twice
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(k == 0){
                //find two
                if(entry.getValue() >= 2)
                    count++;
            }
            else{
                //if k is not 0 then (key + k) is what we check for if the map contains
                if(map.containsKey(entry.getKey() + k))
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,4,1,5};
        int k = 2;
        System.out.println(getKDiffPairs(nums, k));
    }
}
