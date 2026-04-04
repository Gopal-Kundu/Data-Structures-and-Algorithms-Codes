//https://leetcode.com/problems/find-median-from-data-stream/

class MedianFinder {
    PriorityQueue<Integer> pqMin;
    PriorityQueue<Integer> pqMax;
    public MedianFinder() {
        pqMin = new PriorityQueue<>();
        pqMax = new PriorityQueue<>(Collections.reverseOrder());     
    }
    
    public void addNum(int num) {
        if(pqMax.isEmpty() || pqMax.peek() >= num)
            pqMax.offer(num);
        else pqMin.offer(num);

        if(pqMax.size() > pqMin.size()+1) pqMin.offer(pqMax.poll());
        else if(pqMax.size() < pqMin.size()) pqMax.offer(pqMin.poll());
    }
    
    public double findMedian() {
        int totalElements = pqMin.size() + pqMax.size();
        if(totalElements%2 == 0) return 1.0*(pqMin.peek()+pqMax.peek())/2;
        else return 1.0*(pqMax.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */