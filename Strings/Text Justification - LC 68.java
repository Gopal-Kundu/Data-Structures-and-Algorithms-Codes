//https://leetcode.com/problems/text-justification/description/

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        List<String> wordsContainer = new ArrayList<>();
        int totalWordsInWordsContainer = 0;

        for (String word : words) {

            if (totalWordsInWordsContainer + wordsContainer.size() + word.length() <= maxWidth) {
                wordsContainer.add(word);
                totalWordsInWordsContainer += word.length();
            } else {
                int totalExtraSpace = maxWidth - totalWordsInWordsContainer;

                if (wordsContainer.size() == 1) {
                    wordsContainer.set(0,
                        wordsContainer.get(0) + addSpace(totalExtraSpace));
                } else {
                    int gaps = wordsContainer.size() - 1;
                    int spaceHasToDistribute = totalExtraSpace / gaps;
                    int extraSpaceForLeft = totalExtraSpace % gaps;

                    for (int i = 0; i < gaps; i++) {
                        int spaces = spaceHasToDistribute + (extraSpaceForLeft > 0 ? 1 : 0);
                        wordsContainer.set(i,
                            wordsContainer.get(i) + addSpace(spaces));
                        if (extraSpaceForLeft > 0) extraSpaceForLeft--;
                    }
                }

                StringBuilder line = new StringBuilder();
                for (String wordWithSpace : wordsContainer) {
                    line.append(wordWithSpace);
                }
                ans.add(line.toString());

                wordsContainer.clear();
                wordsContainer.add(word);
                totalWordsInWordsContainer = word.length();
            }
        }

        // Last line
        StringBuilder lastLine = new StringBuilder();
        for (int i = 0; i < wordsContainer.size(); i++) {
            lastLine.append(wordsContainer.get(i));
            if (i != wordsContainer.size() - 1)
                lastLine.append(" ");
        }
        lastLine.append(addSpace(maxWidth - lastLine.length()));
        ans.add(lastLine.toString());

        return ans;
    }

    public String addSpace(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++)
            sb.append(" ");
        return sb.toString();
    }
}
