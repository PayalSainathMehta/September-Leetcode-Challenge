public class RGBToHex {

    static String formatRGB(int r, int g, int b){
        return (toHex(r) + toHex(g) + toHex(b)).toUpperCase();
    }

    static String toHex(int c){
        String s = Integer.toHexString(c);
        return s.length() == 1 ? "0" + s : s;
    }

    public static void main(String[] args) {
        System.out.println(formatRGB(255,1,128));
    }
}
