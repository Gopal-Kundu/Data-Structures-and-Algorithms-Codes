//https://leetcode.com/problems/maximum-69-number/

class Solution {
    public int maximum69Number (int num) {
        String number = Integer.toString(num);
        char[] numArray = number.toCharArray();
        for(int i = 0; i < numArray.length; i++){
            if(numArray[i] == '6'){
                numArray[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(numArray));
    }
}