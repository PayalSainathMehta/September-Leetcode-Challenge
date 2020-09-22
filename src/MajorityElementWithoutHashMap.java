import java.util.ArrayList;
import java.util.List;

/*
we are trying to find all elements that occur more than n/3 times

To remember:-
atmost 1 element that occurs more than n / 2 times
atmost 2 elements that occurs more than n / 3 times
atmost 3 elements that occurs more than n / 4 times

 */
public class MajorityElementWithoutHashMap {

    static List<Integer> findElement(int[] nums){
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0 || nums == null)
            return result;
        //1st pass - we find two potential candidates and counts of both
        Integer candidate1 = null;
        Integer candidate2 = null;
        int count1 = 0;
        int count2 = 0;
        for(int ele: nums){
            if(candidate1 != null && candidate1 == ele)
                count1++;
            else if(candidate2 != null && candidate2 == ele)
                count2++;
            else if(count1 == 0){
                candidate1 = ele;
                count1++;
            }
            else if(count2 == 0){
                candidate2 = ele;
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        //2nd pass - we verify
        count1 = 0;
        count2 = 0;
        int n = nums.length;
        for(int ele: nums){
            if(candidate1 != null && candidate1 == ele)
                count1++;
            if(candidate2 != null && candidate2 == ele)
                count2++;
        }

        if(count1 > n / 3)
            result.add(candidate1);
        if(count2 > n / 3)
            result.add(candidate2);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,2,2,2};
        System.out.println(findElement(nums).toString());
    }
}
