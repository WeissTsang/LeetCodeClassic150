package com.weiss.interview.tree;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;


public class TreeConstruction {
    private static Map<Integer, Integer> map = new HashMap<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
//        int[] preorder = new int[] {3, 9, 20, 15, 7};
//        int[] inorder = new int[] {9, 3, 15, 20, 7};
//        int[] preorder = new int[] {5, 4, 11, 7, 2, 8, 13, 3, 1};
//        int[] inorder = new int[] {7, 11, 2, 4, 5, 13, 8, 3, 1};
//        int[] preorder = new int[] {4, 9, 5, 1, 0};
//        int[] inorder = new int[] {5, 9, 1, 4, 0};
//        int[] preorder = new int[] {-10, 9, 20, 15, 7};
//        int[] inorder = new int[] {9, -10, 15, 20, 7};
        int[] preorder = new int[] {3, 5, 6, 2, 7, 4, 1, 0, 8};
        int[] inorder = new int[] {6, 5, 7, 2, 4, 3, 0, 1, 8};


        TreeNode root = buildTree(preorder, inorder);
        preOrder(root);

        sb.setLength(sb.length() - 2);
        System.out.println(sb.toString());

//        boolean ans = hasPathSum(root, 22);
//        System.out.println("ans = " + ans);

//        System.out.println("sumNumbers(root) = " + sumNumbers(root));

//        System.out.println("maxPathSum(root) = " + maxPathSum(root));
        TreeNode p = new TreeNode(0);
        TreeNode q = new TreeNode(8);
        TreeNode treeNode = lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor: " + treeNode.val);
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {this.val = val;}

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder,0, n - 1, 0, n - 1);
    }

    private static TreeNode dfs(int[] preorder, int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right || in_left > in_right) {
            return null;
        }

        int in_root = map.get(preorder[pre_left]);
        int sz = in_root - in_left;

        TreeNode root = new TreeNode(preorder[pre_left]);
        root.left = dfs(preorder, pre_left + 1, pre_left + sz, in_left, in_root - 1);
        root.right = dfs(preorder, pre_left + sz + 1, pre_right, in_root + 1, in_right);

        return root;
    }

    private static void preOrder(TreeNode root) {
        if (root == null) return ;

        sb.append(root.val).append(", ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        sum -= root.val;
        if (root.left == null && root.right == null) return sum == 0;

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    private static int sumNumbers(TreeNode root) {
        return dfsSum(root, 0);
    }

    private static int dfsSum(TreeNode root, int sum) {
        if (root == null) return 0;

        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfsSum(root.left, sum) + dfsSum(root.right, sum);
        }
    }

    private static int maxPathTotal = Integer.MIN_VALUE;
    private static int maxPathSum(TreeNode root) {
        dfsMaxPathSum(root);

        return maxPathTotal;
    }

    private static int dfsMaxPathSum(TreeNode node) {
        if (node == null) return 0;

        int left = dfsMaxPathSum(node.left);  // 左子树最大路径和
        int right = dfsMaxPathSum(node.right);   // 右子树最大路径和

        maxPathTotal = Math.max(maxPathTotal, node.val + left + right);  // 两条路径拼接后的路径和

        return Math.max(0, Math.max(left, right) + node.val);  // 当前子树最大路径和
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
//        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;

        return left != null ? left : right;
    }
}
