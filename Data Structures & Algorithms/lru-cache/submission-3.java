class LRUCache {

    private int capacity;
    private List<int[]> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new ArrayList<>();
    }
            
    public int get(int key) {
        for(int i = 0; i < this.cache.size(); i++) {
            if(cache.get(i)[0] == key) {
                int[] temp = cache.get(i);
                cache.remove(i);
                cache.add(temp);
                return temp[1];
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i = 0; i < this.cache.size(); i++) {
            if(cache.get(i)[0] == key) {
                int[] temp = cache.get(i);
                cache.remove(i);
                temp[1] = value;
                cache.add(temp);
                return;
            }
        }

        if(this.capacity == this.cache.size()) {
            cache.remove(0);
        }
        cache.add(new int[]{key, value});
    }

}

