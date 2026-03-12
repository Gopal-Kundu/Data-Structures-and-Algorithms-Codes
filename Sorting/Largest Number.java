//https://leetcode.com/problems/largest-number/description/
class Solution {
    public String largestNumber(int[] nums) {
       String[] s_num = new String[nums.length];
       for (int i = 0; i < nums.length; i++) {
           s_num[i] = String.valueOf(nums[i]);
       }

       Arrays.sort(s_num, (a, b) -> (b + a).compareTo(a + b));
       if (s_num[0].equals("0")) {
            return "0";
       }
       StringBuilder sb = new StringBuilder();
       for (String str : s_num) {
           sb.append(str);
       }
       return sb.toString();
    }
}