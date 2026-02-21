//https://www.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1

class Solution {
    public int towerOfHanoi(int n, int from, int to, int aux) {
        // code here
        if(n == 1) return 1;
        int step1 = towerOfHanoi(n-1, 1, 2, 3);
        int step2 = 1;
        int step3 = towerOfHanoi(n-1, 2, 3, 1);
        return step1 + step2 + step3;
    }
}
