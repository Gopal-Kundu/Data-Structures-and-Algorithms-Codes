//https://leetcode.com/problems/meeting-rooms-iii/

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1])
                return Long.compare(a[2], b[2]);
            return Long.compare(a[1], b[1]);
        }); //[start, end, room.No.]
        PriorityQueue<Integer> q = new PriorityQueue<>(); //[room. No]
        for (int i = 0; i < n; i++)
            q.offer(i);
        int[] times = new int[n]; //No of times room used
        for (int meeting[] : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            while (!pq.isEmpty() && pq.peek()[1] <= start) {
                q.offer((int) pq.poll()[2]);
            }
            if (!q.isEmpty()) { //Room is free
                int room = q.poll(); //get lowest number room
                pq.offer(new long[] { start, end, room });
                times[room]++;
            } else { //all rooms busy
                //Free a room with lowest end which finish first
                long prevRoom[] = pq.poll();
                int freeRoom = (int) prevRoom[2];
                if (prevRoom[1] > start) {
                    long duration = end - start;
                    start = prevRoom[1];
                    end = start + duration;
                }
                pq.offer(new long[] { start, end, freeRoom });
                times[freeRoom]++;
            }
        }

        int maxTimes = 0, ans = 0;
        System.out.println("No. of times room filled: ");
        for (int i = 0; i < n; i++) {
            System.out.print(times[i] + " ");
            if (times[i] > maxTimes) {
                ans = i;
                maxTimes = times[i];
            }
        }
        return ans;

    }
}