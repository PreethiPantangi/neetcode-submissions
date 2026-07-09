class KthLargest {

    private PriorityQueue<Integer> stream;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        stream = new PriorityQueue<>();
        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        stream.offer(val);
        if(stream.size() > k) {
            stream.poll();
        }
        return stream.peek();
    }
}
