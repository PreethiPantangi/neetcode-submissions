class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        if len(s) == 1:
            return False
        for par in s:
            if par == '[' or par == '{' or par == '(':
                stack.append(par)
            else:
                if len(stack) > 0:
                    lastEle = stack.pop()
                    if (lastEle == "[" and par != "]") or (lastEle == "(" and par != ")") or (lastEle == "{" and par != "}"):
                        return False
                else:
                    return False
        return True if len(stack) == 0 else False