class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int result = 0;
        int currentSum = 0;

        for(int num : nums) {
            currentSum += num;
            int difference = currentSum - k;
            result += map.getOrDefault(difference, 0);
            map.put(currentSum, map.getOrDefault(currentSum,0) + 1);
        }
        return result;
    }
}