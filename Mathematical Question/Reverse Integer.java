//https://leetcode.com/problems/reverse-integer/

class Solution {
    public int reverse(int x) {
        int temp = 0;
        boolean isNeg = (x < 0) ? true : false;
        x = Math.abs(x);
        while(x != 0){
            if (temp > Integer.MAX_VALUE/10 || temp < Integer.MIN_VALUE/10)
                return 0;
            temp = temp*10 + x%10;
            x = x/10;
        }
        return isNeg == true ? -1*temp : temp;
    }
}