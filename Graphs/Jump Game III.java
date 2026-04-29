//https://leetcode.com/problems/jump-game-iii/description/

class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        Set<Integer> visited = new HashSet<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int idx = q.poll();
                if(arr[idx] == 0) return true;
                if(!visited.contains(idx + arr[idx]) && idx + arr[idx] < arr.length){
                    q.offer(idx + arr[idx]);
                    visited.add(idx + arr[idx]);
                }
                if(!visited.contains(idx - arr[idx]) && idx - arr[idx] >= 0){
                    q.offer(idx - arr[idx]);
                    visited.add(idx - arr[idx]);
                }
            }
        }
        return false;
    }
}