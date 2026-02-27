//https://leetcode.com/contest/weekly-contest-489/problems/first-element-with-unique-frequency/
class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer, Integer> elements = new HashMap<>();
        for (int num : nums) {
            elements.put(num, elements.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, Integer> elemetFreq = new HashMap<>();
        for (int num : elements.values()) {
            elemetFreq.put(num, elemetFreq.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (elemetFreq.get(elements.get(num)) == 1)
                return num;
        }
        return -1;
    }
}