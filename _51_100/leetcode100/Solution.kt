package _51_100.leetcode100

import _51_100.leetcode94.TreeNode

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if ((p == null && q != null) || (p != null && q == null)) {
        return false
    }

    if (p == null && q == null) {
        return true
    }

    return p!!.`val` == q!!.`val` && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
}

fun main() {
    val tree1 = TreeNode(3, null, null)
    val tree2 = TreeNode(1, null, null)
    val tree3 = TreeNode(4, null, null)
    val tree4 = TreeNode(2, null, null)
//    val tree5 = TreeNode(7, null, null)
//    val tree6 = TreeNode(5, null, null)

    tree1.left = tree2
    tree1.right = tree3
    tree3.left = tree4

    println(isSameTree(tree1, tree2))
}