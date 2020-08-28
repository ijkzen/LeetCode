package _101_150.leetcode124

import _51_100.leetcode94.TreeNode

var maxSum = Int.MIN_VALUE

fun maxPathSum(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    maxPath(root)
    return maxSum
}

fun maxPath(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    val left = maxPath(root.left)
    val right = maxPath(root.right)

    val finalLeft = if (left < 0) 0 else left
    val finalRight = if (right < 0) 0 else right
    if (maxSum < root.`val` + finalLeft + finalRight) {
        maxSum = root.`val` + finalLeft + finalRight
    }

    return root.`val` + Math.max(finalLeft, finalRight)
}

fun main() {
    val node1 = TreeNode(-10)
    val node2 = TreeNode(9)
    val node3 = TreeNode(20)
    val node4 = TreeNode(15)
    val node5 = TreeNode(7)

    node1.left = node2
    node1.right = node3
    node3.left = node4
    node3.right = node5

    println(maxPathSum(node1))
}