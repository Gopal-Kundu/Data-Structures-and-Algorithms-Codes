//https://leetcode.com/problems/create-binary-tree-from-descriptions/

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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> allChilds = new HashSet<>();
        for(int[] des : descriptions){
            int root = des[0], child = des[1], isLeft = des[2];
            if(!map.containsKey(root)){
                map.put(root, new TreeNode(root));
                if(!map.containsKey(child)) map.put(child, new TreeNode(child));
                if(isLeft == 1) map.get(root).left = map.get(child);
                else map.get(root).right = map.get(child);
            }else{
                if(!map.containsKey(child)) map.put(child, new TreeNode(child));
                if(isLeft == 1) map.get(root).left = map.get(child);
                else map.get(root).right = map.get(child);
            }
            allChilds.add(child);
        }


        //Find node which not on set which is ultimate root node.
        for(int[] des : descriptions){
            int root = des[0];
            if(!allChilds.contains(root)) return map.get(root);
        }

        return null;
    }
}