public class MaximumProductOfSubarrays {

    public static int maxProduct(int[] nums) {
        int r = Integer.MIN_VALUE;
        int n = nums.length;
        int imax = 1, imin = 1;
        for(int i = 0; i < n; i++){

            //we swap when we encounter negative number as mult by negative makes smaller number bigger and bigger number smaller
            if(nums[i] < 0){//negative
                imax = imax + imin;
                imin = imax - imin;
                imax = imax - imin;
            }

            //store min and max
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            r = Math.max(r, imax);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] a = {-2, 3, -4};
        System.out.println(maxProduct(a));
    }
}
