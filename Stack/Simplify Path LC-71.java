//https://leetcode.com/problems/simplify-path/description

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        String temp = "";
        while (i < path.length()) {
            if(path.charAt(i) == '/') {
                i++;
                continue;
            }
            while (i < path.length() && path.charAt(i) != '/') {
                temp += path.charAt(i);
                i++;
            }
            if (temp.equals(".")) {
                temp = "";
                continue;
            }
            if (temp.equals("..")) {
                if(!stack.isEmpty())stack.pop();
                temp = "";
                continue;
            }
            stack.push(temp);
            temp = "";
        }
        String result = "";
        for(String str : stack){
            result+="/"+str;
        }
        if(result == "") result= "/";
        return result;
    }
}