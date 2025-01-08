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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       if(root==null)
            return 0;
        rec(root);
        return max;
        
    }
    int rec(TreeNode root){
        if(root==null)
            return 0;
        int sumleft=rec(root.left);
        int sumright=rec(root.right);
        int sum=Math.max(sumleft,sumright);
        if(Math.max(sumleft,sumright)<=0)
        {
            max=Math.max(max,root.val);
            return root.val;
        }
        else{
            max=Math.max(max,root.val+Math.max(sum,sumleft+sumright));
        
            return sum+root.val;
        }
        
    }
}