public class MostBookedHotelRoom {

    static String getMostBooked(String[] floors){
        String currentMax = floors[0];
        int max = 0;
        int[] counts = new int[260];
        for(int i = 0; i < floors.length; i++){
            String currentRoom = floors[i];
            if(currentRoom.charAt(0) == '-') //we dont care about freed rooms
                continue;
            int t1 = 1 + currentRoom.charAt(1) - '0'; //get the number
            int t2 = 1 + currentRoom.charAt(2) - 'A'; //get the alphabet
            int idx = t1 * t2 - 1;
            counts[idx]++; //store
            if(counts[idx] > max){
                max = counts[idx];
                currentMax = currentRoom;
            }
            else if(counts[idx] == max) //keep the lexicographically smallest
                currentMax = currentMax.compareTo(currentRoom) < 0 ? currentMax : currentRoom;
        }
        return currentMax.substring(1); //other than + -
    }

    public static void main(String[] args) {
        String[] floors = {"+1A", "+3E", "-1A", "+4F", "-3E","+3E","-4F","+4F"};
        System.out.println(getMostBooked(floors));
    }
}
