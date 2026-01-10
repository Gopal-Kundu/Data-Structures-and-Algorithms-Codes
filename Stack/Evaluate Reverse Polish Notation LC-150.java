//https://leetcode.com/problems/evaluate-reverse-polish-notation/description

class Solution {
    public int evalRPN(String[] tokens) {
        int num1 = 0, num2 = 0;
        Stack<String> stack = new Stack<>();
        for(String token : tokens){
            if(token.equals("+")){
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(num1+num2));
            }
            else if(token.equals("-")){
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(num1-num2));
            }
            else if(token.equals("*")){
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(num1*num2));
            }
            else if(token.equals("/")){
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(num1/num2));
            }
            else stack.push(token);
        }
        return Integer.parseInt(stack.pop());
    }
}