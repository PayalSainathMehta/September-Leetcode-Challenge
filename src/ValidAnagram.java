public class ValidAnagram {

    static boolean isValidAnagram(String s, String t){
        int[] count = new int[26];
        if(s.length() != t.length())
            return false;
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int ele: count)
            if(ele != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "cptt", t = "tact";
        System.out.println(isValidAnagram(s, t));
    }
}
