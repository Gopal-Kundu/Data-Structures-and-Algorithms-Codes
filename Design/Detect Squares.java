//https://leetcode.com/problems/detect-squares/description/

class DetectSquares {
    HashMap<String, Integer> freq;
    List<int[]> list;
    public DetectSquares() {
        freq = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public void add(int[] point) {
        String key = point[0] + "@" + point[1];
        if(!freq.containsKey(key)){
            freq.put(key, 1);
            list.add(new int[]{point[0], point[1]});
        }else{
            freq.put(key, freq.getOrDefault(key, 0)+1);
        }
    }
    
    public int count(int[] point) {
        int a = point[0], b = point[1];
        int total = 0;
        for(int[] pos : list){
            int c = pos[0], d = pos[1];
            if(a == c && b == d) continue;
            String diagonal = c + "@" + d;
            String left = c + "@" + b;
            String bottom = a + "@" + d;
            if(freq.containsKey(diagonal) && freq.containsKey(left)
            && freq.containsKey(bottom)){
                if(Math.abs(a - c) == Math.abs(b - d))
                    total += freq.get(diagonal) * freq.get(left) * freq.get(bottom);
            }
        }
        return total;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */