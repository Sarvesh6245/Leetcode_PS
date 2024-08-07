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
    TreeNode p=null;
    TreeNode f=null;
    TreeNode m=null;
    TreeNode s=null;
    public void recoverTree(TreeNode root) {
       inorder(root);
       if(s!=null){
           int t=f.val;
           f.val=s.val;
           s.val=t;
       } 
       else{
           int k=f.val;
           f.val=m.val;
           m.val=k;
       }
    }
    void inorder(TreeNode r){
        if(r==null) return;
        inorder(r.left);
        if(p!=null&&r.val<p.val){
            if(f==null){
                f=p;
                m=r;
            }
            else s=r;
        }
        p=r;
        inorder(r.right);
    }
}