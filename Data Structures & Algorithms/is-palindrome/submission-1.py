class Solution:
    def isPalindrome(self, s: str) -> bool:
        newStr = ""
        for _s in s:
            if (ord(_s) >= 97 and ord(_s) <= 122) or (ord(_s) >= 65 and ord(_s) <= 90 or _s.isnumeric()):
                newStr += _s.lower()
        left = 0
        right = len(newStr) - 1
        while left < right:
            if newStr[left] != newStr[right]:
                return False
            left += 1
            right -= 1
        return True