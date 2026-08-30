//https://leetcode.com/problems/pascals-triangle-ii/description/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0) return new ArrayList<>(Arrays.asList(1));
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            ans.add(new ArrayList<>());
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    ans.get(i).add(1);
                    continue;
                }
                else{
                    int a = ans.get(i-1).get(j);
                    int b = ans.get(i-1).get(j-1);
                    ans.get(i).add(a+b);
                }
            }
        }
        return ans.get(rowIndex);
    }
}