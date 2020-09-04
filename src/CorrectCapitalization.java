public class CorrectCapitalization {
    // TC - O(n)
    static boolean isCorrectCapital(String s){
        //base case
        if(s.length() == 0 || s == null)
            return false;
        int n = s.length();
        //if only one character, then for sure valid.
        if(n == 1)
            return true;
        //if both first and second are uppercase, then all consecutive has to be
        if(Character.isUpperCase(s.charAt(0)) && Character.isUpperCase(s.charAt(1)))
        {
            for(int i = 2; i < n; i++) // O(n)
                if(Character.isLowerCase(s.charAt(i)))
                    return false;
        }
        //either first or second or both are not capital
        //if control is here that means
        // case1: 0th char is lower case - which means subsequent must be lowercase
        // case2: 1st char is lower case - 0th is upper case - which means subsequent must be lowercase
        // case3: both 0th and 1st are lower case - which means subsequent must be lowercase
        /*
            Hence by only checking from 1 to n we can see if any is upper case, if found such return false
         */
        else{ // O(n)
            for(int i = 1; i < n; i++){
                if(Character.isUpperCase(s.charAt(i))) //breakthrough
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "UsA";
        System.out.println(isCorrectCapital(s));
    }
}
