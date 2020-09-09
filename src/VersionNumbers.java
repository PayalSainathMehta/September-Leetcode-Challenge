import java.util.Arrays;

public class VersionNumbers {

    public static int compareVersion(String version1, String version2){
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

//        System.out.println(Arrays.toString(levels1));
//        System.out.println(Arrays.toString(levels2));
        int length = Math.max(levels1.length, levels2.length); //both are of length 2
        for (int i=0; i<length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion( "0.1", "1.1"));
    }
}
