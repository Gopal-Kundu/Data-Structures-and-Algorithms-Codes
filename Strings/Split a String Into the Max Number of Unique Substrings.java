//https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/description/

class Solution {
    HashSet<String> set; int max;
    public int maxUniqueSplit(String s) {
        set = new HashSet<>();
        max = 0;
        solve(s, 0, set);
        return max;
    }
    private void solve(String s, int idx, HashSet<String> set){
        
        if(idx == s.length()){
            max = Math.max(set.size(), max);
            return;
        }
        for(int i = idx; i < s.length(); i++){
            String subStr = s.substring(idx, i+1);
            if (!set.contains(subStr)) {
                set.add(subStr);
                solve(s, i + 1, set); 
                set.remove(subStr);
            }
        }
    }
}