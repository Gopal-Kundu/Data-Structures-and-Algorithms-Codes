//https://leetcode.com/problems/task-scheduler/description/

class data {
    char label;
    int freq;
    int executionTime;

    data(char label, int freq, int executionTime) {
        this.label = label;
        this.freq = freq;
        this.executionTime = executionTime;
    }

    data(data d) {
        this.label = d.label;
        this.freq = d.freq;
        this.executionTime = d.executionTime;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<data> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq == b.freq) //Freq Equals
                return a.executionTime - b.executionTime; //sort by low next execution time
            return b.freq - a.freq; //sort by max freq
        });
        Queue<data> q = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        for (char task : map.keySet()) {
            pq.offer(new data(task, map.get(task), 0));
        }

        int time = 0;
        while (!pq.isEmpty() || !q.isEmpty()) {
            if (!q.isEmpty() && time >= q.peek().executionTime) {
                pq.offer(q.poll());
            }

            if (!pq.isEmpty()) {
                data task = new data(pq.poll());

                int newFreq = task.freq - 1;
                int newET = time + n + 1;

                if (newFreq > 0) {
                    q.offer(new data(task.label, newFreq, newET));
                }
            }

            time++;
        }
        return time;
    }
}