import java.util.TreeSet;

public class ContainsNearby {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //since we want implement a self-balancing binary search tree, we use treeset
        //TC - O(n * log(min(n , k))
        //SC - O(min(n , k))
        TreeSet<Long> treeSet = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            //we take maximum value smaller than current value
            Long floor = treeSet.floor((long) nums[i]);
            if(floor != null && nums[i] - floor <= t)
                return true;
            //we take minimum value greater than current value
            Long ceiling = treeSet.ceiling((long) nums[i]);
            if(ceiling != null && ceiling - nums[i] <= t)
                return true;
            //if neither add it to the TreeSet
            treeSet.add((long) nums[i]);
            //if size exceeds simply remove oldest element
            if(treeSet.size() > k)
                treeSet.remove((long) nums[i - k]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        int t = 0;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }
}
