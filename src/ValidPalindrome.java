public class ValidPalindrome {

    public static boolean isValid(String s){
        if(s.length() == 0 || s == null)
            return true;
        
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int n = s.length();
        for(int i = 0; i <= n / 2; i++)
            if(s.charAt(i) != s.charAt(n - i - 1))
                return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama.";
        System.out.println(isValid(s));
    }
}
