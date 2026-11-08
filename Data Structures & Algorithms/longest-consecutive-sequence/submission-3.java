class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a - b);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            heap.offer(entry.getKey());
        }

        int[] numbers = new int[heap.size()];
        int i = 0;
        while(!heap.isEmpty()) {
            numbers[i] = heap.poll();
            i += 1;
        }

        int result = numbers.length == 0 ? 0 : 1;
        int count = 1;
        for(int j = 1; j < numbers.length; j++) {
            if(numbers[j] - numbers[j-1] == 1)  {
                count += 1;
            } else {
                count = 1;
            }
            result = Math.max(count, result);
        }
        return result;
    }
}
