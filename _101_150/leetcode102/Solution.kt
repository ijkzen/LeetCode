package _101_150.leetcode102

import _51_100.leetcode94.TreeNode

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

    println(levelOrder(treeNode1))
}