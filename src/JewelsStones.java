import java.util.HashMap;
import java.util.Map;

public class JewelsStones {

    static int findJewelsInStones(String jewels, String stones){
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c: stones.toCharArray()){
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        for(char c: jewels.toCharArray()){
            if(map.containsKey(c))
                count = count + map.get(c);
        }
        return count;
    }

    public static void main(String[] args) {
        String jewels = "AYOPD";
        String stones = "ayopD";
        System.out.println(findJewelsInStones(jewels, stones));
    }
}
