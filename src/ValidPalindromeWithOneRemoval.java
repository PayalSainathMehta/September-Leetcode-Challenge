public class ValidPalindromeWithOneRemoval {

    public static boolean validPalindrome(String s) {
        int l = -1, r = s.length();
        //first check first and last char, then second and second last...so on
        while(++l < --r)
            if(s.charAt(l) != s.charAt(r))//first mismatch - for given string at l = 0, r = 5   'a' - 'b'
                //call with l = 0, r = 6 //second call on second eval with l = -1 and r = 5
                return (isPalindrome(s, l, r + 1) || isPalindrome(s, l - 1, r)); //first part is false//second part we need to evaluate as OR condition
        return true;
    }

    public static boolean isPalindrome(String s, int l, int r){
        while(++l < --r) //l now is 1 and r is 5 //l = 2, r = 4 , l = 0, r = 5
            if(s.charAt(l) != s.charAt(r)) // b = b // c!=a
                return false; // returns twice
        return true;
    }

    public static void main(String[] args) {
        String s = "abccab"; //length = 6
        System.out.println(validPalindrome(s));
    }
}
