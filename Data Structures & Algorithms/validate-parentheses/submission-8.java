class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) return false;
                Character top = stack.peek();
                if( 
                    (top == '{' && ch != '}') ||
                    (top == '[' && ch != ']') ||
                    (top == '(' && ch != ')')
                 ) {
                    return false;
                 } 
                 stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
