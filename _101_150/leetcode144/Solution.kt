package _101_150.leetcode144

import _51_100.leetcode94.TreeNode

val list = ArrayList<Int>()

fun preorderTraversal(root: TreeNode?): List<Int> {
    dfs(root)
    return list
}

fun dfs(root: TreeNode?) {
    if (root == null) {
        return
    } else {
        list.add(root.`val`)
        dfs(root.left)
        dfs(root.right)
    }
}