class LRUCache {

    private int capacity;
    private ArrayList<int[]> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ArrayList<>();
    }
    
    public int get(int key) {
        for(int i = 0; i < cache.size(); i++) {
            if(cache.get(i)[0] == key) {
                int[] removed = cache.remove(i);
                cache.add(removed);
                return removed[1];
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i = 0; i < cache.size(); i++) {
            if(cache.get(i)[0] == key) {
                int[] removed = cache.remove(i);
                removed[1] = value;
                cache.add(removed);
                return;
            }
        }

        if(cache.size() == this.capacity) cache.remove(0);

        cache.add(new int[]{key, value});
    }

}

