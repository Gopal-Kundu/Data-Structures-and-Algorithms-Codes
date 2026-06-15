//https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/


class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        int len = 0;
        boolean hasCenter = false;
        for (String word : map.keySet()) {
            String reversedWord = new StringBuilder(word).reverse().toString();
            if (!visited.contains(word)) {
                if (word.charAt(0) == word.charAt(1)) {
                    len += (map.get(word) / 2) * 4;
                    if (!hasCenter && map.get(word)%2 == 1) {
                        len += map.get(word) % 2 * 2;
                        hasCenter = true;
                    }
                    visited.add(word);
                } else if (map.containsKey(reversedWord)) {
                    len += Math.min(map.get(word), map.get(reversedWord)) * 4;
                    visited.add(word);
                    visited.add(reversedWord);
                }
            }
        }

        return len;

    }
}