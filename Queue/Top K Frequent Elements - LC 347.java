//https://leetcode.com/problems/top-k-frequent-elements/

class ElementWithFreq implements Comparable<ElementWithFreq> {
    int element, frequency;

    ElementWithFreq(int e, int f) {
        this.element = e;
        this.frequency = f;
    }


    public int compareTo(ElementWithFreq obj) {
        return obj.frequency - this.frequency; //Decending order
    }

}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        PriorityQueue<ElementWithFreq> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer,Integer> v: map.entrySet()){
            ElementWithFreq element = new ElementWithFreq(v.getKey(), v.getValue());
            pq.offer(element);
        }
        int idx = 0;
        while(k > 0){
            ans[idx++] = pq.poll().element;
            k--;
        }
        return ans;

    }
}