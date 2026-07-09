class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    topKFrequent(nums, k) {
        let _map = {};
        for(let i = 0; i < nums.length; i++) {
            if(_map[nums[i]]) {
                _map[nums[i]] += 1
            } else {
                _map[nums[i]] = 1;
            }
        }
        const values = Object.entries(_map).map(([num, freq]) => [freq, parseInt(num)]);
        values.sort((a,b) => b[0] - a[0]);
        return values.slice(0, k).map(pair => pair[1]);
    }
}
