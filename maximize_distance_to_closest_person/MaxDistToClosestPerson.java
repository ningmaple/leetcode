public class MaxDistToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length == 0) {
            return -1;
        }
        
        int first = -1;
        int last = -1;
        int ptr1 = -1;
        int ptr2 = -1;
        int maxDist = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                continue;
            }
            
            if (first == -1) {
                first = i;
            }
            last = i;
            
            if (ptr1 == -1) {
                ptr1 = i;
                continue;
            }
            ptr2 = i;
            maxDist = Math.max(maxDist, (ptr2 - ptr1) / 2);
            ptr1 = ptr2;
        }

        return last == -1 ? 0 : Math.max(maxDist, Math.max(first - 0, seats.length - 1 - last));
    }
}