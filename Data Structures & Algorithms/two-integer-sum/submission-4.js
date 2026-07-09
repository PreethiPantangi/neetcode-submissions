class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums, target) {
        let _map = new Map();
        for(let i = 0; i < nums.length; i++) {
            console.log(_map, target - nums[i], _map.get(target - nums[i]))
            if(_map.has(target - nums[i])) {
                return [i, _map.get(target - nums[i])]
            } else {
                _map.set(nums[i], i);
            }
        }
    }
}
