//https://leetcode.com/contest/weekly-contest-491/problems/trim-trailing-vowels/description/
class Solution {
    public String trimTrailingVowels(String s) {
        StringBuilder sbs = new StringBuilder(s);
        sbs = sbs.reverse();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(char ch : sbs.toString().toCharArray()){
            if(set.contains(ch) && count!=0){
                sb.append(ch);
            }else{
                if(set.contains(ch) && count == 0){
                    continue;
                }else if(!set.contains(ch)){
                    sb.append(ch);
                    count++;
                }
            }
        }
        return sb.reverse().toString();
    }
}