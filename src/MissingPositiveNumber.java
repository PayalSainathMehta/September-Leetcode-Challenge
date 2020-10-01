public class MissingPositiveNumber {

    static int find(int[] nums){
        int n = nums.length;
        //replace the irrelevant ones
        if(n == 0)
            return 1;
        for(int i = 0; i < n; i++){
            if(nums[i] <= 0 || nums[i] > n)
                nums[i] = n + 1;
        }

        //hop make negative
        for(int i = 0; i < n; i++){
            int ele = Math.abs(nums[i]);
            if(ele > n)
                continue;
            int idx = ele - 1;
            if(nums[idx] > 0)
                nums[idx] *= -1;
        }

        //find first positive no
        for(int i = 0; i < n; i++)
            if(nums[i] > 0)
                return i + 1;

        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,0,4};
        System.out.println(find(nums));
    }
}
