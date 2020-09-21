public class CarPooling {
    public static boolean carPooling(int[][] trips, int capacity) {

        int[] timestamp = new int[1001];
        for(int[] trip: trips){

            timestamp[trip[1]] += trip[0]; //keep adding
            timestamp[trip[2]] -= trip[0]; //keep subtracting

            int used_capacity = 0;
            for(int change_in_passenger: timestamp){
                used_capacity += change_in_passenger; //at every step check
                if(used_capacity > capacity)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{2,1,5},{3,3,7}};
        System.out.println(carPooling(trips, 4));
    }
}
