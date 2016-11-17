public class Solution {
    public boolean isValidParentheses(String s) {
        if (s.length() == 0 || s == null) {
            return false;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        for (Character character : s.toCharArray()) {
            if ("({[".contains(String.valueOf(character))) {
                stack.push(character);
            } else {
                if (!stack.isEmpty() && isValid(stack.peek(), character)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean isValid(Character c1, Character c2) {
        return c1 == '(' && c2 == ')' || c1 == '[' && c2 == ']' || c1 == '{' && c2 == '}';
    }
}