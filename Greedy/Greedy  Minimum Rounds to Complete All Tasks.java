// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/


class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++)
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);

        int rounds = 0;
        for(int value : map.values()){
            if(value == 1) return -1;
            rounds += value/3;
            if(value%3 != 0) rounds++;
        }
        
        return rounds;
    }
}