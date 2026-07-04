//https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map1 = new HashMap<>();
        for(String word : words)
            map1.put(word, map1.getOrDefault(word, 0)+1);
        
        HashMap<String, Integer> map2;

        List<Integer> answer = new ArrayList<>();
        int left = 0, windowSize = words.length*words[0].length();
        for(int right = 0; right < s.length(); right++){
            if(right - left + 1 == windowSize){
                String str = s.substring(left, right+1);
                map2 = new HashMap(convertMap(str, words[0].length()));
                if(isMatched(map1, map2)) answer.add(left);
                left++;
            }
        }
        return answer;
}
    public boolean isMatched(HashMap<String, Integer> map1, HashMap<String, Integer> map2){
        if(map1.size() != map2.size()) return false;
        for(String word : map2.keySet()){
            if(!map2.containsKey(word) || !map1.containsKey(word)) return false;
            if(!map1.get(word).equals(map2.get(word))) return false;
        }
        return true;
    }

    HashMap<String, Integer> convertMap(String str, int wordLen){
        HashMap<String, Integer> map = new HashMap<>();
        int i = 0;
        for(int j = wordLen-1; j < str.length(); j+=wordLen){
            String s = str.substring(i, j+1);
            map.put(s, map.getOrDefault(s, 0)+1);
            i = j+1;
        }
        return map;
    }
}