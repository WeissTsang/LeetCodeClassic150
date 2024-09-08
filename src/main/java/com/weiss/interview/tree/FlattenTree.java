package com.weiss.interview.tree;

import javax.swing.tree.TreeNode;

public class FlattenTree {
    public static void main(String[] args) {

    }

    private static void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode pre = next;

                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = curr.right;
                curr.left = null;
                curr.right = next;
            }

            curr = curr.right;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
