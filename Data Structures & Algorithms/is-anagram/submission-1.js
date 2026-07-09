class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s, t) {
        if(s.length != t.length) return false;

        let sMap = {};
        let tMap = {};
        
        let len = Math.max(s.length, t.length);

        for(let i = 0; i < len; i++) {
            sMap[s[i]] = sMap[s[i]] ? sMap[s[i]] + 1 : 1
            tMap[t[i]] = tMap[t[i]] ? tMap[t[i]] + 1 : 1
        }
        for (const key in sMap) {
            if (sMap[key] != tMap[key]) {
                return false;
            }
        }
        return true;
    }
}
