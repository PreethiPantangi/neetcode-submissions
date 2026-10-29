class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (isInteger(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public boolean isInteger(String str) {
        if (str == null) return false;

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}