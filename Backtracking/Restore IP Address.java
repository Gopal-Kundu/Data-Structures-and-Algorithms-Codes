//https://leetcode.com/problems/restore-ip-addresses/description/
class Solution {
    List<String> answer;
    String ip;

    public List<String> restoreIpAddresses(String s) {
        answer = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12)
            return answer;
        ip = s;
        solve(0, "", 0);
        return answer;
    }

    void solve(int idx, String curr, int dots) {
        if (dots == 4 && idx == ip.length()) {
            answer.add(curr.substring(0, curr.length() - 1));
            return;
        }

        if (dots >= 4)
            return;

        if (idx + 1 <= ip.length() && isValid(ip.substring(idx, idx + 1)))
            solve(idx + 1, curr + ip.substring(idx, idx + 1) + ".", dots + 1);
        if (idx + 2 <= ip.length() && isValid(ip.substring(idx, idx + 2)))
            solve(idx + 2, curr + ip.substring(idx, idx + 2) + ".", dots + 1);
        if (idx + 3 <= ip.length() && isValid(ip.substring(idx, idx + 3)))
            solve(idx + 3, curr + ip.substring(idx, idx + 3) + ".", dots + 1);
    }

    boolean isValid(String str) {
        if (str.length() > 1 && str.charAt(0) == '0')
            return false;
        int num = Integer.valueOf(str);
        return num <= 255;
    }
}