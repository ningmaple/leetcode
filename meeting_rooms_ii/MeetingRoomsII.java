public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        int[][] points = new int[intervals.length * 2][2];
        for (int i = 0; i < intervals.length; i++) {
            points[i] = new int[]{intervals[i][0], 1};
            points[i + intervals.length] = new int[]{intervals[i][1], -1};
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return 0;
                }
                return o1[0] < o2[0] ? -1 : 1;
            }
        });
        
        int rooms = 0;
        int meetings = 0;
        for (int slow = 0; slow < points.length; slow++) {
            int fast = slow;
            while (fast + 1 < points.length && points[fast + 1][0] == points[slow][0]) {
                fast++;
            }
            
            for (int i = slow; i <= fast; i++) {
                meetings += points[i][1];
            }
            rooms = Math.max(rooms, meetings);
            slow = fast;
        }
        
        return rooms;
    }
}