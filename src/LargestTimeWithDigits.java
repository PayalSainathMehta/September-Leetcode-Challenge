public class LargestTimeWithDigits {
    /*
    return HH:MM largest time.
     */
    static String largestTime(int[] a){
        String result = "";
        //since we know that the array will have only 4 digits,
        //the total time complexity would be O(4!) ~ O(24)
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    //we can't reuse the index, here i, j, k represents indices
                    if (i == j || j == k || i == k)
                        continue;
                    String HH = a[i] + "" + a[j];
                    String MM = a[k] + "" + a[6 - i - j - k]; //why 6? because indices 0 + 1 + 2 + 3 = 6
                    String time = HH + ":" + MM;
                    if (HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && result.compareTo(time) < 0)
                        result = time;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(largestTime(a));
    }
}
