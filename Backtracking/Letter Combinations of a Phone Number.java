//Letter Combinations of a Phone Number

class Solution {
    HashMap<String, String> map;
    List<String> answer;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        answer = new ArrayList<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        solve(digits, 0, "");
        return answer;
    }

    private void solve(String digits, int idx, String current){
        if(current.length() == digits.length()){
            answer.add(current); 
            return;
        }
        String currDigit = digits.charAt(idx) + "";
        String letters = map.get(currDigit);
        for(int i = 0; i < letters.length(); i++){
            solve(digits, idx+1, current + letters.charAt(i));
        }
        return;
    }
}