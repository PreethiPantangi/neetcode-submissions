class Solution:

    def encode(self, strs: List[str]) -> str:
        encodedStr = ""
        for _str in strs:
            encodedStr += str(len(_str)) + "#" + _str
        return encodedStr

    def decode(self, s: str) -> List[str]:
        decodedStrs = []
        i = 0
        while i < len(s):
            j = i
            while(s[j] != "#"): 
                j += 1
            lenOfStr = int(s[i:j])
            i = j + 1
            decodedStrs.append(s[i:i+lenOfStr])
            i += lenOfStr
        return decodedStrs

