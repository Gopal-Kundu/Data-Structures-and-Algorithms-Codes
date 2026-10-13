//https://www.geeksforgeeks.org/problems/encode-and-decode-strings/1
class Solution {

    public String encode(String arr[]) {
        // write your logic to encode the strings
        StringBuilder encodedString = new StringBuilder();
        for(String str : arr)
            encodedString.append(str.length()).append(":/").append(str);
        return encodedString.toString();
    }

    public ArrayList<String> decode(String s) {
        // write your logic to decode the string
        //5/:Hello5/:World
        ArrayList<String> result = new ArrayList<>();
        int i = 0;
        while(i < s.length()){
            int splitterIndx = s.indexOf(":/", i);
            int len = Integer.parseInt(s.substring(i, splitterIndx));
            i = splitterIndx+2; 
            result.add(s.substring(i, i+len));
            i += len; 
        }
        
        return result;
    }
}