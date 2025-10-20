// https://leetcode.com/problems/evaluate-division/description/

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()]; 
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            if(!map.containsKey(a)) map.put(a, new HashMap<>());
            if(!map.containsKey(b)) map.put(b, new HashMap<>());

            map.get(a).put(b, val);
            map.get(b).put(a, 1.0/val);
        }
        
        for(int i = 0; i < queries.size(); i++){
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if(!map.containsKey(src) || !map.containsKey(dest)){
                ans[i] = -1.0;
                continue;
            }
            if(src.equals(dest)){
                ans[i] = 1.0;
                continue;
            }
            Set<String> visited = new HashSet<>();
            ans[i] = dfs(map, src, dest, 1.0, visited);

        }
        return ans;
    }

    double dfs(HashMap<String, HashMap<String, Double>> map, String src, String dest, double product, Set<String> visited){
        visited.add(src); //marked as visited

        if(map.get(src).containsKey(dest)){
            return product*map.get(src).get(dest);
        }
        for(String i : map.get(src).keySet()){
            if(!visited.contains(i)){
                double nextValue = map.get(src).get(i);
                double val =  dfs(map, i, dest, product*nextValue, visited);
                if(val != -1.0) return val;
            }
        }
        return -1.0;
    }

}