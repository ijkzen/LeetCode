package _101_150.leetcode112

import _51_100.leetcode94.TreeNode

fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
    if (root == null) {
        return false
    }

    return if (sum == root.`val` && root.left == null && root.right == null) {
        true
    } else {
        hasPathSum(root.left, sum - root.`val`) || hasPathSum(root.right, sum - root.`val`)
    }
}

fun main() {
    val node1 = TreeNode(5)
    val node2 = TreeNode(4)
    val node3 = TreeNode(8)
    val node4 = TreeNode(11)
    val node5 = TreeNode(13)
    val node6 = TreeNode(4)
    val node7 = TreeNode(7)
    val node8 = TreeNode(2)
    val node9 = TreeNode(1)

    node1.left = node2
    node1.right = node3
    node2.left = node4
    node3.left = node5
    node3.right = node6
    node4.left = node7
    node4.right = node8
    node6.right = node9

    println(hasPathSum(node1, 22))
}