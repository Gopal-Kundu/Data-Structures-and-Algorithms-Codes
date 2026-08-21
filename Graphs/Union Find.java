//https://www.geeksforgeeks.org/problems/disjoint-set-union-find/1

class Solution {
    public ArrayList<Integer> DSU(int n, int[][] queries) {
        // code here
        DisjointSet set = new DisjointSet(n);
        ArrayList<Integer> answer = new ArrayList<>();
        for(int q[] : queries){
            if(q[0] == 2){
                int ans = set.findParent(q[1]);
                answer.add(ans);
            }else if(q[0] == 1){
                set.union(q[1], q[2]);
            }
        }
        return answer;
    }
}

class DisjointSet{
    int[] parent;
    
    DisjointSet(int len){
        len++;
        parent = new int[len];
        for(int i = 0; i < len; i++){
            parent[i] = i;
        }
    }
    
    int findParent(int idx){
        if(parent[idx] == idx) return idx;
        return parent[idx] = findParent(parent[idx]);
    }
    
    void union(int idx1, int idx2){
        int p1 = findParent(idx1);
        int p2 = findParent(idx2);
        if(p1 == p2) return;
        parent[p1] = p2;
    }
}
