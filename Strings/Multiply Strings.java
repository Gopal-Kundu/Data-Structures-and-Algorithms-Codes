class Solution {
    public String multiply(String num1, String num2) {
        int[] ans = new int[200]; int n1 = num1.length(), n2 = num2.length();
        int len = 0; int idx = 0; int carry = 0;
        for(int i = n1 - 1; i >= 0; i--){
            int num1Ch = num1.charAt(i) - '0';
            int curr = 0;
            for(int j = n2 - 1; j >= 0; j--){
                int currIdx = curr + idx;
                // System.out.print(currIdx + " ");
                int num2Ch = num2.charAt(j) - '0';
                int sum = ans[currIdx] + num1Ch * num2Ch + carry;
                // System.out.print("sum: " + sum + " carry:" + carry );
                ans[currIdx] = sum%10;
                carry = 0;
                if(sum >= 10) carry = sum/10;  
                len = Math.max(len, currIdx);
                curr++;
                if(j == 0 && carry > 0){
                    ans[currIdx+1] += carry;
                    carry = 0;
                    len = Math.max(len, currIdx+1);
                }
            }
            // System.out.println();
            // for(int k = 0; k <= len; k++)
            //       System.out.print(ans[k] + " ");
            // System.out.println();
            idx++;
        }
        // System.out.println(Arrays.toString(ans));
        StringBuilder str = new StringBuilder(); int sum = 0;
        for(int i = 0; i <= len; i++){
            sum += ans[i];
            str.append(ans[i]);
        }
        if(sum == 0) return "0";
        return str.reverse().toString();
    }
}