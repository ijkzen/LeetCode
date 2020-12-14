package _101_150.leetcode129

import _51_100.leetcode94.TreeNode

var sum = 0

fun sumNumbers(root: TreeNode?): Int {
    subSum(root, "")

    return sum
}

fun subSum(root: TreeNode?, current: String){
    if (root != null) {
        val next = "$current${root.`val`}"
        if (root.left != null && root.right != null) {
            subSum(root.left, next)
            subSum(root.right, next)
        } else if (root.left != null && root.right == null) {
            subSum(root.left, next)
        } else if (root.left == null && root.right != null) {
            subSum(root.right, next)
        } else {
            sum += next.toInt()
        }
    }
}

fun main() {
    val node1 = TreeNode(4)
    val node2 = TreeNode(9)
    val node3 = TreeNode(0)
    val node4 = TreeNode(5)
    val node5 = TreeNode(1)

    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5

    println(sumNumbers(node1))
}