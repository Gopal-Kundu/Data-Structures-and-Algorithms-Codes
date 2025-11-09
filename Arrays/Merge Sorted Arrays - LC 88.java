// https://leetcode.com/problems/merge-sorted-array/

//Brute Force
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int ans[] = new int[m+n];
        int i = 0;
        while( i < m ){
            ans[i] = nums1[i];
            i++;
        }
        int j = 0;
        while( j < n ){
            ans[i+j] = nums2[j++];
        }
        Arrays.sort(ans);
        i = 0;
        for( int num : ans ){
            nums1[i++] = num;
        }
    }
}