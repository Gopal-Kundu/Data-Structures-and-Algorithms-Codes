//https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/


class Solution {
    public boolean winnerOfGame(String colors) {
        int alice = 0;
        int bob = 0;
        int n = colors.length();
        int i = 1;

        while (i < n - 1) {
            if (colors.charAt(i - 1) == colors.charAt(i)
                    && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A')
                    alice++;
                else
                    bob++;
            }
            i++;
        }
        return alice > bob;
    }
}