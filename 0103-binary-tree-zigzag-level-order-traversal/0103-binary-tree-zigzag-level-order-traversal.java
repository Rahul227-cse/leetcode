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
    List<List<Integer>> l = new ArrayList<>();
    boolean flag = false;
    public void helper(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int n = q.size();

            List<Integer> ds = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){

                TreeNode curr = q.poll();
                ds.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(flag == false){
                l.add(new ArrayList<>(ds));
                flag = true;
            }else{
                Collections.reverse(ds);
                l.add(new ArrayList<>(ds));
                flag = false;
            }


        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        helper(root);

        return l;
    }
}