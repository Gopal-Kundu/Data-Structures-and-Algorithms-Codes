//https://leetcode.com/problems/spiral-matrix-iv/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        for(int i = 0; i < mat.length; i++){
            Arrays.fill(mat[i], -1);
        }

        int top = 0, bottom = m - 1, left = 0, right = n-1;
        while(true){
            for(int i = left; i <= right; i++){
                if(head == null) return mat;
                mat[top][i] = head.val;
                head = head.next;
            }
            top++;
            if(top > bottom) break;

            for(int i = top; i <= bottom; i++){
                if(head == null) return mat;
                mat[i][right] = head.val;
                head = head.next;
            }
            right--;
            if(right < left) break;

            for(int i = right; i >= left; i--){
                if(head == null) return mat;
                mat[bottom][i] = head.val;
                head = head.next;
            }
            bottom--;
            if(top > bottom) break;

            for(int i = bottom; i >= top; i--){
                if(head == null) return mat;
                mat[i][left] = head.val;
                head = head.next;
            }
            left++;
            if(left > right) break;
        }

        return mat;
    }
}