https://leetcode.com/problems/decode-ways/

class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int dp[] = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++){
            int singleDigit = s.charAt(i-1)-'0';
            int doubleDigit = (s.charAt(i-2)-'0')*10 + singleDigit;
            if(singleDigit >= 1 && singleDigit <= 9 )
                dp[i] += dp[i-1];
            if(doubleDigit >= 10 && doubleDigit <= 26)
                dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }
}