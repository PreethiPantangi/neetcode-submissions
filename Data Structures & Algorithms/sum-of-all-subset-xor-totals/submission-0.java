class Solution {
    public int subsetXORSum(int[] nums) {
        if(nums.length == 0) return 0;
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        int xor = 0;
        for(int i = 0; i < result.size(); i++) {
            xor += getXor(result.get(i));
        }
        return xor;
    }

    private int getXor(List<Integer> nums) {
        int result = 0;
        for(int i = 0; i < nums.size(); i++) {
            result ^= nums.get(i);
        }
        return result;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if(index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        generateSubsets(index + 1, nums, current, result);

        current.remove(current.size() - 1);
        generateSubsets(index + 1, nums, current, result);
    }
}