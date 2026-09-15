//https://leetcode.com/contest/weekly-contest-512/problems/aggregate-two-time-series/description/

class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        HashSet<Integer> availableTimeStamps = new HashSet<>();
        HashMap<Integer, Integer> map3 = new HashMap<>();
        HashMap<Integer, Integer> map4 = new HashMap<>();
        for (int i = 0; i < series1.length; i++) {
            map1.put(series1[i][0], series1[i][1]);
            availableTimeStamps.add(series1[i][0]);
            map3.put(series1[i][0], series1[i][1]);
        }

        for (int i = 0; i < series2.length; i++) {
            map2.put(series2[i][0], series2[i][1]);
            map4.put(series2[i][0], series2[i][1]);
            availableTimeStamps.add(series2[i][0]);
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (int time : availableTimeStamps) {
            Integer value1 = map1.ceilingKey(time);
            Integer value2 = map2.ceilingKey(time);
            value1 = value1 == null ? 0 : map3.get(value1);
            value2 = value2 == null ? 0 : map4.get(value2);
            List<Integer> v = new ArrayList<>();
            v.add(time);
            v.add(value1 + value2);
            answer.add(new ArrayList<>(v));
        }

        Collections.sort(answer, (a, b) -> a.get(0) - b.get(0));

        return answer;
    }
}