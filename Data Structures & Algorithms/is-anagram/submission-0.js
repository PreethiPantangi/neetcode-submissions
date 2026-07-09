class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s, t) {
        if(s.length != t.length) return false;
        s = s.split("").sort().join("");
        t = t.split("").sort().join("");
        let len = s.length;
        for(let i = 0; i < len; i++) {
            if(s[i] !== t[i]) {
                return false;
            }
        }
        return true;
    }
}
