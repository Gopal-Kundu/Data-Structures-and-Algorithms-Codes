//https://leetcode.com/problems/word-ladder/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordList)
            set.add(word);
        
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int cnt = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String word = q.poll();
                if(word.equals(endWord)) return cnt;
                char[] w = word.toCharArray();
                for(int j = 0; j < word.length(); j++){
                    for(int k = 0; k < 26; k++){
                        char ch = w[j];
                        w[j] = (char) (k+'a');
                        String w1 = new String(w);
                        if(set.contains(w1)){
                            set.remove(w1);
                            q.offer(w1);
                        }
                        w[j] = ch;
                    }
                }
            }
            cnt++;
        }
        return 0;
    }
}
