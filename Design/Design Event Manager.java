//https://leetcode.com/problems/design-event-manager/description/

class EventManager {
    PriorityQueue<int[]> pq;
    HashMap<Integer, Integer> map;

    public EventManager(int[][] events) {
        pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1])
                return a[0] - b[0];
            return b[1] - a[1];
        });
        map = new HashMap();
        for (int event[] : events) {
            map.put(event[0], event[1]);
            pq.offer(event);
        }
    }

    public void updatePriority(int eventId, int newPriority) {
        map.put(eventId, newPriority);
        pq.offer(new int[]{eventId, newPriority});
    }

    public int pollHighest() {
        while(!pq.isEmpty()){
            if(map.containsKey(pq.peek()[0]) && map.get(pq.peek()[0]) == pq.peek()[1]){
                map.remove(pq.peek()[0]);
                return pq.poll()[0];
            }
            pq.poll();
        }
        return -1;
    }
}
