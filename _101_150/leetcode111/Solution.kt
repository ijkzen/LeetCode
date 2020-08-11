package _101_150.leetcode111

import _51_100.leetcode94.TreeNode

fun minDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    if (root.left == null && root.right == null) {
        return 1
    }

    if ((root.left != null && root.right == null)) {
        return minDepth(root.left) + 1
    }

    if (root.left == null && root.right != null) {
        return minDepth(root.right) + 1
    }

    return Math.min(minDepth(root.left), minDepth(root.right)) + 1
}

fun main() {
    val node1 =   TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(2)
    val node4 = TreeNode(3)
    val node5 = TreeNode(3)
    val node6 = TreeNode(4)
    val node7 = TreeNode(4)

    node1.left = node2

    node2.left = node4
    node2.right = node5
    node4.left = node6
    node4.right = node7

    println(minDepth(node1))
}