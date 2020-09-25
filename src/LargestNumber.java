import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static String largestNumber(int[] nums) {
        //custom comparator for string value of int in nums
        if(nums.length == 0 || nums == null)
            return "";

        int n = nums.length;
        String[] snums = new String[n];
        for(int i = 0; i < n; i++)
            snums[i] = String.valueOf(nums[i]);

        //custom comparator
        Comparator<String> comp = new Comparator<>(){
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1); //descending
            }
        };

        Arrays.sort(snums, comp);

        if(snums[0].charAt(0) == '0')
            return "0"; //for input [0,0]
        StringBuilder sb = new StringBuilder();
        for(String s: snums)
            sb.append(s);

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {10, 2};
        System.out.println(largestNumber(nums));
    }
}
