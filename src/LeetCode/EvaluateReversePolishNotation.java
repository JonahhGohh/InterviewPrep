package LeetCode;

public class EvaluateReversePolishNotation {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                String s = tokens[i];
                if (s.equals("+")) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int newVal = num2 + num1;
                    stack.push(newVal);
                } else if (s.equals("-")) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int newVal = num2 - num1;
                    stack.push(newVal);
                } else if (s.equals("*")) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int newVal = num2 * num1;
                    stack.push(newVal);
                } else if (s.equals("/")) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int newVal = num2 / num1;
                    stack.push(newVal);
                } else {
                    stack.push(Integer.parseInt(s));
                }
            }
            return stack.pop();
        }
    }

}
