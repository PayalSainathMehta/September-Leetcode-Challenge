import java.util.HashSet;
import java.util.Set;

public class RepeatedSubstring {
    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if(n < 2) //only one character
            return false;
        if(n == 2) //only 2 chars then they both should be same
            return s.charAt(0) == s.charAt(1);
        //since we need to check only till half of substring to find repeat
        for(int i = n / 2; i >= 1; i--){
            if(n % i == 0){ //this gives us divisibility
                int num_repeats = n / i; //this gives us how many substrings
                String sub = s.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < num_repeats; j++) //keep doing this for num_repeats
                    sb.append(sub);  //keep appending
                if(sb.toString().equals(s)) //if our formed sb matches s
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern(s));
    }
}
