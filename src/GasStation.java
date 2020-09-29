public class GasStation {

    static int findStart(int[] gas, int[] cost){
        int total = 0;
        //if total is below 0, that is value of gas is less than cost then there is no solution

        //find if solution exists
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
        }
        if(total < 0)
            return -1; //no solution

        //find out where to start
        int tank = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){
            tank += gas[i] - cost[i];
            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(findStart(gas, cost));
    }
}
