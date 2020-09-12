import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    static int getIndex(String s){
        if(s.length() == 0 || s == null)
            return -1;
        Map<Character, Integer> mp = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!mp.containsKey(c))
                mp.put(c, i);
            else
                mp.put(c, -1); //invalidate - otherwise how do you maintain the occurrence count
        }
        int min = Integer.MAX_VALUE;
        for(char c: mp.keySet()){
            if(mp.get(c) > -1 && mp.get(c) < min) //filter the double/triple occurring chars
                min = mp.get(c);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        String s = "developer";
        System.out.println(getIndex(s));
    }
}
