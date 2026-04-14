//https://www.geeksforgeeks.org/problems/intersection-of-two-sorted-arrays-with-duplicate-elements/1

class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < a.length && j < b.length){
            if(a[i] < b[j]){
                i++;
                continue;
            }else if(a[i] > b[j]){
                j++;
                continue;
            }else{
                if(!list.isEmpty() && list.get(list.size()-1)!=a[i]) 
                    list.add(a[i]);
                else if(list.isEmpty()) list.add(a[i]);
                i++;
                j++;
            }
        }
        return list;
    }
}