import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoTrees {
    /*
    We return a sorted list of node values from both trees
     */

    // TC - O(m + n)
    // SC - O(m + n)
    // we can use Morris inorder traversal to do it in constant space complexity
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> stack1 = new ArrayDeque();
        ArrayDeque<TreeNode> stack2 = new ArrayDeque();
        // we use space of two stacks to follow inorder traversal
        // left -> add root.val to result -> right
        while(root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()){

            //keep going left
            while(root1 != null){
                stack1.push(root1);
                root1 = root1.left; //inorder left
            }

            while(root2 != null){
                stack2.push(root2);
                root2 = root2.left; //inorder left
            }
            //now add smallest of the two to result
            if(stack2.isEmpty() || !stack1.isEmpty() && stack1.getFirst().val <= stack2.getFirst().val){
                root1 = stack1.pop();
                result.add(root1.val); //inorder add root.val
                root1 = root1.right; //inorder right
            }
            else{
                root2 = stack2.pop();
                result.add(root2.val); //inorder add root.val
                root2 = root2.right; //inorder right
            }
        }
        return result;
    }
}
