class RandomizedSet {
    private Map<Integer, Integer> valToIdx;
    private int[] array;
    private final float FACTOR = 0.75f;
    private int cap;
    private int size;
    
    public RandomizedSet() {
        this.valToIdx = new HashMap<>();
        this.cap = 16;
        this.array = new int[this.cap];
        this.size = 0;
    }
    
    public boolean insert(int val) {
        if (this.valToIdx.containsKey(val)) {
            return false;
        }
        
        this.array[size] = val;
        this.valToIdx.put(val, size++);
        if (this.size >= this.cap * FACTOR) {
            resize();
        }
        return true;
    }
    
    public boolean remove(int val) {
        if (!valToIdx.containsKey(val)) {
            return false;
        }

        this.array[this.valToIdx.get(val)] = array[this.size - 1];
        this.valToIdx.put(array[this.size - 1], this.valToIdx.get(val));
        this.valToIdx.remove(val);
        this.size--;
        return true;
    }
    
    public int getRandom() {
        return this.array[new Random().nextInt(this.size)];
    }
    
    private void resize() {
        this.cap *= 2;
        int[] newArray = new int[this.cap];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }
}