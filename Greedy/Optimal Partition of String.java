//https://leetcode.com/problems/optimal-partition-of-string/description/

class Solution {
    public int partitionString(String s) {
        int count = 0;
        HashSet<Character> set = new HashSet();
        for(char ch : s.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
            }else{
                set.clear();
                count++;
                set.add(ch);
            }
        }
        if(!set.isEmpty()) count++;
        return count;
    }
}