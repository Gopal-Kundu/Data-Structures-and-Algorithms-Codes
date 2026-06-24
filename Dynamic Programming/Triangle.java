//https://leetcode.com/problems/triangle/description/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int prev[] = new int[triangle.size()];
        for(int i = 0; i < prev.length; i++)
            prev[i] = triangle.get(triangle.size()-1).get(i);
    
        for(int i = triangle.size()-2; i >= 0; i--){
            int curr[] = new int[triangle.size()];
            for(int j = i; j >= 0; j--){
                int down = triangle.get(i).get(j) + prev[j];
                int right = triangle.get(i).get(j) + prev[j+1];
                curr[j] = Math.min(down, right);
            }
            System.out.println(Arrays.toString(curr));
            prev = curr;
        } 

        return prev[0];
    }
}