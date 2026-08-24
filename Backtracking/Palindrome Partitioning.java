//https://leetcode.com/problems/palindrome-partitioning/description/
class Solution {
    List<List<String>> answer;
    public List<List<String>> partition(String s) {
        answer = new ArrayList<>();
        solve(s, new ArrayList<>(), 0);
        return answer;
    }
    private void solve(String s, ArrayList<String> current, int idx){
        if(idx >= s.length()){
            answer.add(new ArrayList<>(current));
            return;
        }
        for(int i = idx; i < s.length(); i++){
            if(isPalin(s.substring(idx, i+1))){
                current.add(s.substring(idx, i+1));
                solve(s, current, i+1);
                current.remove(current.size()-1);
            }
        }
        return;
    }
    private boolean isPalin(String s){
        int i = 0, j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++; j--;
        }
        return true;
    }
}