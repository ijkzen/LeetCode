package _101_150.leetcode110

import _51_100.leetcode94.TreeNode

val map = HashMap<TreeNode, Int>()

fun isBalanced(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }

    if (root.left == null && root.right == null) {
        return true
    }

    return Math.abs(getMaxHeight(root.right) - getMaxHeight(root.left)) <= 1 && isBalanced(root.left) && isBalanced(root.right)
}

fun getMaxHeight(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    val height = map[root]
    if (height != null) {
        return height
    }


    if (root.left == null && root.right == null) {
        map[root] = 1
        return 1
    }

    map[root] = Math.max(getMaxHeight(root.left), getMaxHeight(root.right)) + 1

    return map[root]!!
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
    node1.right = node3
    node2.left = node4
    node2.right = node5
    node4.left = node6
    node4.right = node7

    println(isBalanced(node1))
}