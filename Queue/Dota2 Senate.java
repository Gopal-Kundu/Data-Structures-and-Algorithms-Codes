//https://leetcode.com/problems/dota2-senate/

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int idx = 0;
        for(char party : senate.toCharArray()){
            if(party == 'R') radiant.offer(idx);
            else dire.offer(idx);

            idx++;
        }

        while(!radiant.isEmpty() && !dire.isEmpty()){
            if(radiant.peek() > dire.peek()){
                radiant.poll();
                int currIdx = dire.poll();
                dire.offer(currIdx + senate.length());
            }else{
                dire.poll();
                int currIdx = radiant.poll();
                radiant.offer(currIdx + senate.length());
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}