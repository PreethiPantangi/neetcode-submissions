class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs) {
        let _map = {};
        for(let i = 0; i < strs.length; i++) {
            let sortedStr = strs[i].split("").sort().join("");
            if(_map[sortedStr]) {
                _map[sortedStr].push(strs[i]);
            } else {
                _map[sortedStr] = [strs[i]];
            }
        }
        return Object.values(_map);
    }
}
