package _101_150.leetcode104

import _51_100.leetcode94.TreeNode

fun maxDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    return maxDepth(root, 1)
}

fun maxDepth(root: TreeNode, currentDepth: Int): Int {
    return if (root.left == null && root.right == null) {
        currentDepth
    } else if (root.left == null && root.right != null) {
        maxDepth(root.right!!, currentDepth + 1)
    } else if (root.left != null && root.right == null) {
        maxDepth(root.left!!, currentDepth + 1)
    } else {
        Math.max(maxDepth(root.left!!, currentDepth + 1), maxDepth(root.right!!, currentDepth + 1))
    }
}

fun main() {
    val treeNode1 = TreeNode(1)
    val treeNode2 = TreeNode(2)
    val treeNode3 = TreeNode(7)
    val treeNode4 = TreeNode(5)
    val treeNode5 = TreeNode(4)
    val treeNode6 = TreeNode(4)
    val treeNode7 = TreeNode(3)
    val treeNode8 = TreeNode(8)
    val treeNode9 = TreeNode(9)

    treeNode1.left = treeNode2
    treeNode1.right = treeNode3
    treeNode2.left = treeNode4
    treeNode2.right = treeNode5
    treeNode3.left = treeNode6
    treeNode3.right = treeNode7
    treeNode4.right = treeNode8
    treeNode7.right = treeNode9

    println(maxDepth(treeNode1))
}