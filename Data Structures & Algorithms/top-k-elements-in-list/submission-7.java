class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> map.get(a) - map.get
        (b));

        for(int num: map.keySet()) {
            queue.add(num);
            if(queue.size() > k) queue.poll();
        }

        int[] result = new int[k];
        int index = 0;
        while(k != 0) {
            result[index] = queue.poll();
            index += 1;
            k -= 1;
        }
        return result;
    }
}
