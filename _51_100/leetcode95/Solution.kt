package _51_100.leetcode95

import _51_100.leetcode94.TreeNode

fun generateTrees(n: Int): List<TreeNode?> {
    val dp = Array<MutableList<TreeNode?>>(n + 1){
        ArrayList()
    }
    dp[0] = ArrayList()
    if (n == 0 || n == 1) {
        return dp[n]
    }
    dp[0].add(null)
    dp[1] = arrayListOf(TreeNode(1, null, null))
    for (length in 2..n) {
        for (root in 1..length) {
            val leftLength = root - 1
            val rightLength = length - root
            for (leftTree in dp[leftLength]) {
                for (rightTree in dp[rightLength]) {
                    val node = TreeNode(root, null, null)
                    node.left = leftTree
                    node.right = clone(rightTree, root)
                    dp[length].add(node)
                }
            }
        }
    }

    return dp[n]
}

fun clone(treeNode: TreeNode?, offset: Int):TreeNode? {
    if (treeNode == null) {
        return null
    }
    val node = TreeNode(treeNode.`val` + offset, null, null)
    node.left = clone(treeNode.left, offset)
    node.right = clone(treeNode.right, offset)
    return node
}

fun main() {
    println(generateTrees(3).size)
}