public class RobotBoundedInCircle {

    public static boolean isRobotBounded(String instructions) {
        /*
         north = 0,
         east = right = 1;
         south = 2;
         west = left = 3;
         */
        int x = 0, y = 0; //origin
        int idx = 0; //facing north
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(char c: instructions.toCharArray()){
            if(c == 'L')
                idx = (idx + 3) % 4;
            else if(c == 'R')
                idx = (idx + 1) % 4;
            else{
                x = x + dirs[idx][0];
                y = y + dirs[idx][1];
            }
        }
        return (x == 0 && y == 0) || idx != 0;
    }

    public static void main(String[] args) {
        String s = "GGLLGG";
        System.out.println(isRobotBounded(s));
    }
}
