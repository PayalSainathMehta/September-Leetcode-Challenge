public class MaximumTime {

    //this is max time given string with ?
    static String giveMaxTime(String time){
        char[] timChar = time.toCharArray();

        if(timChar[0] == '?')
            timChar[0] = (timChar[1] <= '3' || timChar[1] == '?') ? '2' : '1';

        if(timChar[1] == '?')
            timChar[1] = (timChar[0] == '2') ? '3' : '9';

        timChar[3] = (timChar[3] == '?') ? '5' : timChar[3];
        timChar[4] = (timChar[4] == '?') ? '9' : timChar[4];

        return new String(timChar);
    }

    //this is maximum time given 4 digits in array
    //since only 4 digits would be given the complexity is O(4!)
    static String giveMaxTime(int[] a){
        String result = "";
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    if(i == j || j == k || k == i) //no digit can be used more than once.
                        continue;
                    String HH = a[i] + "" + a[j];
                    String MM = a[k] + "" + a[6 - i - j - k];
                    String time = HH + ":" + MM;
                    if(HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && result.compareTo(time) < 0)
                        result = time;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "?3:??";
        int[] a = {1,2,3,4};
        System.out.println(giveMaxTime(a));
        System.out.println(giveMaxTime(input));
    }
}
