public class SumRootToLeafBinary {

    public int sumRootToLeaf(TreeNode root){
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        if(root == null)
            return 0;
        sum = sum * 2 + root.val; //because binary to digit
        return (root.left == null && root.right == null) ? sum : dfs(root.left, sum) + dfs(root.right, sum);
    }
}
