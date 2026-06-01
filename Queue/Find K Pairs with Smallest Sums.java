//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
             return (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]);
        });

        for(int i = 0; i < nums1.length && i < k; i++){
            pq.offer(new int[]{i, 0});
        }

        while(k > 0 && !pq.isEmpty()){
            int[] curr = pq.poll();
            result.add(Arrays.asList(nums1[curr[0]], nums2[curr[1]]));
            if(curr[1] + 1 < nums2.length){
                pq.offer(new int[]{curr[0], curr[1]+1});
            }
            k--;
        }
        return result;
    }
}