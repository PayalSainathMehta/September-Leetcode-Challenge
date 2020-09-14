public class HouseRobber {

    static int getCount(int[] nums){
        //BASE CASES
        int n = nums.length;
        if(n == 0)
            return 0; //no houses
        if(n == 1)
            return nums[0]; //only one house

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]); //only 2, can only take current or prev

        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]); //always choose between me + two before or the one before as cant take adjacent
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(getCount(nums));
    }
}
