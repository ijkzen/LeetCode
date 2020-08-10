package _101_150.leetcode107

import _51_100.leetcode94.TreeNode

fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    return levelOrder(root).reversed()
}

fun levelOrder(root: TreeNode?): List<List<Int>> {
    val tmpResult = ArrayList<ArrayList<TreeNode>>()
    if (root != null) {
        val list = ArrayList<TreeNode>()
        list.add(root)
        tmpResult.add(list)
    }
    var count = 0
    while (count < tmpResult.size) {
        count = tmpResult.size
        val list = ArrayList<TreeNode>()
        val lastList = tmpResult[tmpResult.size - 1]
        for (node in lastList) {
            if (node.left != null) {
                list.add(node.left!!)
            }

            if (node.right != null) {
                list.add(node.right!!)
            }
        }
        if (list.isNotEmpty()) {
            tmpResult.add(list)
        }
    }

    val result = ArrayList<ArrayList<Int>>()
    for (tmpList in tmpResult) {
        val list = ArrayList<Int>()
        tmpList.forEach {
            list.add(it.`val`)
        }
        result.add(list)
    }

    return result
}