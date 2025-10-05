//https://leetcode.com/problems/decode-the-message/description/

class Solution {
    public String decodeMessage(String key, String message) {
        HashSet<Character> set = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        int ascii = (int) 'a';
        for (char ch : key.toCharArray()) {
            if (ch != ' ' && !set.contains(ch)) {
                map.put(ch, (char) ascii);
                ascii++;
                set.add(ch);
            }
        }

        for (char ch : map.keySet()) {
            System.out.println(ch + "->" + map.get(ch));
        }
        String answer = "";
        for (char ch : message.toCharArray()) {
            if (ch == ' ') {
                answer += ch;
            } else
                answer += map.get(ch);
        }
        return answer;
    }
}