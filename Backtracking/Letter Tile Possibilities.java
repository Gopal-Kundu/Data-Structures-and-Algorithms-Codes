//https://leetcode.com/problems/letter-tile-possibilities/description/

class Solution {
    HashSet<String> answer;
    String str;
    public int numTilePossibilities(String tiles) {
        answer = new HashSet<>();
        str = tiles;
        boolean[] visited = new boolean[tiles.length()];
        solve(0, "", visited);
        return answer.size()-1;
    }
    void solve(int idx, String curr, boolean visited[]){
        answer.add(curr);
        for(int i = 0; i < str.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                solve(i, curr + str.charAt(i), visited);
                visited[i] = false;
            }
        }
        return;
    }
}