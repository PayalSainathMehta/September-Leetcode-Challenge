public class FindTheDifference {

    static char findTheDifference(String s, String t){
        if(s.length() == t.length())
            return ' ';
        int code = t.charAt(s.length());
        for(int i = 0; i < s.length(); i++){
            code -= (int)s.charAt(i);
            code += (int)t.charAt(i);
        }
        return (char)code;
    }

    //with bit manipulation
    static char findTheDifferenceBitManipulation(String s, String t){
        if(s.length() == t.length())
            return ' ';
        char code = t.charAt(s.length());
        for(int i = 0; i < s.length(); i++){
            code ^= s.charAt(i);
            code ^= t.charAt(i);
        }
        return code;
    }

    public static void main(String[] args) {
        String s = "abcdefgh";
        String t = "abicdefgh";
        System.out.println(findTheDifference(s, t));
        System.out.println(findTheDifferenceBitManipulation(s, t));
    }
}
