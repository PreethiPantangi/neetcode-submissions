class LRUCache {

    private List<int[]> cache;
    private int capacity;
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ArrayList<>();
    }
            
    public int get(int key) {
        // if the key exists
        // remove the key from array
        // add it to the array 
        // return the key 
        // if does not exists return -1
        for(int i = 0; i < cache.size(); i++) {
            if(cache.get(i)[0] == key) {
                int[] temp = cache.remove(i);
                cache.add(temp);
                return temp[1];
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // if the key exists
        // remove the key from array
        // update the value of the key
        // add it to the array 
        // if does not exists 
        // Check if there is enough size
        // if yes add the new key value 
        // else remove the least recently used - 0th element 
        // add the new key, value pair 
        for(int i = 0; i < cache.size(); i++) {
            if(cache.get(i)[0] == key) {
                int[] temp = cache.remove(i);
                temp[1] = value;
                cache.add(temp);
                return;
            }
        }

        if(cache.size() == this.capacity) {
            cache.remove(0);
        }

        cache.add(new int[]{key, value});
    }

}

