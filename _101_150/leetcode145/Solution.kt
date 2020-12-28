package _101_150.leetcode145

import _51_100.leetcode94.TreeNode

val list = ArrayList<Int>()

fun postorderTraversal(root: TreeNode?): List<Int> {
    if (root != null) {
        postorderTraversal(root.left)
        postorderTraversal(root.right)
        list.add(root.`val`)
    }

    return list
}