public class LongestCommonPrefix {

    //TC - 2.T(n / 2) + O(m) where m is number of characters
    //SC -  O(m * log(n))
    static String getLongestCommonPrefix(String[] arr){
        String result = "";
        if(arr.length == 0 || arr == null)
            return result;
        return getLongestCommonPrefix(arr, 0, arr.length - 1);
    }

    //Binary search on two - recursive
    static String getLongestCommonPrefix(String[] arr, int l, int r){
        if(l == r)
            return arr[l];
        int mid = (l + r) / 2;
        String leftstr = getLongestCommonPrefix(arr, l, mid);
        String rightstr = getLongestCommonPrefix(arr, mid + 1, r);
        return commonPrefix(leftstr, rightstr);
    }

    //actual check
    static String commonPrefix(String leftstr, String rightstr){
        int min = Math.min(leftstr.length(), rightstr.length());
        for(int i = 0; i < min; i++)
            if(leftstr.charAt(i) != rightstr.charAt(i))
                return leftstr.substring(0 ,i);
        return leftstr.substring(0,min);
    }

    public static void main(String[] args) {
        String[] arr = {"colorado", "color", "cold"};
        System.out.println(getLongestCommonPrefix(arr));
    }
}
