//https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/

class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                list.add(grid[i][j]);
            }
        }

        Collections.sort(list);
        int mid = list.size()/2;
        int target = list.get(mid);
        int answer = 0;
        for(int num : list){
            if(Math.abs(num - target)%x != 0) return -1;
            answer += Math.abs(num - target)/x;
        }
        return answer;
    }
}