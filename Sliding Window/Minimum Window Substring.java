//https://leetcode.com/problems/minimum-window-substring/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> charsT = new HashMap<>();
        HashMap<Character, Integer> charsS = new HashMap<>();
        
        for(int j = 0; j < t.length(); j++){
            charsT.put(t.charAt(j), charsT.getOrDefault(t.charAt(j),0) + 1);
        }

        int window = t.length(), i = 0;

        int ansJ = -1, ansI = -1, ansLen = (int)1e9;
        for(int j = 0; j < s.length(); j++){
            charsS.put(s.charAt(j), charsS.getOrDefault(s.charAt(j),0) + 1);   
            while(verify(charsT, charsS)){
                
                if(j - i + 1 < ansLen){
                    ansJ = j; ansI = i;
                    ansLen = j-i+1;
                }
                //Shink
                charsS.put(s.charAt(i), charsS.getOrDefault(s.charAt(i),0) - 1);
                if(charsS.get(s.charAt(i)) == 0) charsS.remove(s.charAt(i));
                i++;
            }
        }
        return ansLen == (int)1e9 ? "" : s.substring(ansI, ansJ+1);
    }

    boolean verify(HashMap<Character, Integer> charsT, HashMap<Character, Integer> charsS) {
    for (char c : charsT.keySet()) {
        if (charsS.getOrDefault(c, 0) < charsT.get(c)) {
            return false;
        }
    }
    return true;
}
}