package _101_150.leetcode101

import _51_100.leetcode94.TreeNode

fun isSymmetric(root: TreeNode?): Boolean {
    return isSymmetric(root?.left, root?.right)
}

fun isSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
    if ((left == null && right != null) || (left != null && right == null)) {
        return false
    }

    if (left == null && right == null) {
        return true
    }

    return left!!.`val` == right!!.`val` && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)
}

fun main() {
    val treeNode1 = TreeNode(1)
    val treeNode2 = TreeNode(2)
    val treeNode3 = TreeNode(2)
    val treeNode4 = TreeNode(3)
    val treeNode5 = TreeNode(4)
    val treeNode6 = TreeNode(4)
    val treeNode7 = TreeNode(3)

    treeNode1.left = treeNode2
    treeNode1.right = treeNode3
    treeNode2.left = treeNode4
    treeNode2.right = treeNode5
    treeNode3.left = treeNode6
    treeNode3.right = treeNode7

    println(isSymmetric(treeNode1))
}