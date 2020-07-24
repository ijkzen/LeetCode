package _51_100.leetcode98

import _51_100.leetcode94.TreeNode

var last = Long.MIN_VALUE

fun isValidBST(root: TreeNode?):Boolean {
    if (root == null) {
        return true
    }

    if (!isValidBST(root.left)) {
        return false
    }

    if (root.`val` <= last) {
        return false
    }

    last = root.`val`.toLong()

    return isValidBST(root.right)
}


fun main() {
    val tree1 = TreeNode(10, null, null)
    val tree2 = TreeNode(5, null, null)
    val tree3 = TreeNode(15, null, null)
    val tree4 = TreeNode(6, null, null)
    val tree5 = TreeNode(20, null, null)

    tree1.left = tree2
    tree1.right = tree3
    tree3.left = tree4
    tree3.right = tree5

    println(isValidBST(tree1))
}