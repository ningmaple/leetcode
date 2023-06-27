class ExamRoom {
    private final TreeSet<Integer> sitted;
    private final int cap;

    public ExamRoom(int n) {
        this.sitted = new TreeSet<>();
        this.cap = n;
    }
    
    public int seat() {
        int seat = maxDistToClosest();
        this.sitted.add(seat);
        return seat;
    }
    
    public void leave(int p) {
        if (!this.sitted.contains(p)) {
            return;
        }
        this.sitted.remove(p);
    }

    private int maxDistToClosest() {
        if (this.sitted.isEmpty()) {
            return 0;
        }

        int first = -1;
        int last = -1;
        int ptr1 = -1;
        int ptr2 = -1;
        int maxDist = 0;
        int ans = -1;
        for (int seat : sitted) {
            if (first == -1) {
                first = seat;
            }
            last = seat;
            
            if (ptr1 == -1) {
                ptr1 = seat;
                continue;
            }
            ptr2 = seat;
            int currDist = (ptr2 - ptr1) / 2;
            if (currDist > maxDist) {
                maxDist = currDist;
                ans = ptr1 + currDist;
            }
            ptr1 = ptr2;
        }

        if (first - 0 >= maxDist) {
            maxDist = first - 0;
            ans = 0;
        }
        if (this.cap - 1 - last > maxDist) {
            maxDist = this.cap - 1 - last;
            ans = this.cap - 1;
        }

        return ans;
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */