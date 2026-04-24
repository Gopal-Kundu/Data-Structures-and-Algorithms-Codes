//https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/


class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] freq = new int[arr.length + 1];
        for(int val : map.values()){
            freq[val]++;
        }

        int i = 0;
        while(k > 0){
            if(freq[i] == 0){
                i++;
                continue;
            }
            
            if(freq[i]*i > k){
                freq[i] -= k/i;
                k = 0;
                break;
            }
            else if(freq[i]*i <= k){
                k -= freq[i]*i;
                freq[i] = 0;
            }
        }

        int total = 0;
        for(int v : freq){
            total+=v;
        }
        return total;
    }
}