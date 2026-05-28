//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?envType=study-plan-v2&envId=top-interview-150

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) 
            map.put(inorder[i], i);

        TreeNode resultTree = BuildTree(preorder, 0, preorder.length-1,
                                        inorder, 0, inorder.length-1, map);

        return resultTree;
    }

    TreeNode BuildTree(int[] preorder, int preStart, int preEnd, 
                int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map){
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRootIdx = map.get(preorder[preStart]);
        int leftSizeOfInorder = inRootIdx - inStart;
        root.left = BuildTree(preorder, preStart+1, preStart + leftSizeOfInorder,
                            inorder, inStart, inRootIdx-1, map);
        root.right = BuildTree(preorder, preStart + leftSizeOfInorder + 1, preEnd,
                            inorder, inRootIdx+1, inEnd, map);
        return root;
    }
}