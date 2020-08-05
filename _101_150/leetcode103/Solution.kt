package _101_150.leetcode103

import _51_100.leetcode94.TreeNode

fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    val nodeResult = ArrayList<ArrayList<TreeNode>>()

    var direction = true

    if (root != null) {
        val nodeList = arrayListOf(root)
        val list = arrayListOf(root.`val`)
        direction = !direction
        nodeResult.add(nodeList)
        result.add(list)
    }

    var count = 0
    while (count < nodeResult.size) {
        count = nodeResult.size
        val nodeList = ArrayList<TreeNode>()
        val list = ArrayList<Int>()
        val lastNodeList = nodeResult[count - 1]

        for (i in lastNodeList.size - 1 downTo 0) {
            val node = lastNodeList[i]

            if (direction) {
                node.left?.let {
                    nodeList.add(it)
                    list.add(it.`val`)
                }

                node.right?.let {
                    nodeList.add(it)
                    list.add(it.`val`)
                }
            } else {

                node.right?.let {
                    nodeList.add(it)
                    list.add(it.`val`)
                }

                node.left?.let {
                    nodeList.add(it)
                    list.add(it.`val`)
                }
            }
        }

        direction = !direction

        if (nodeList.isNotEmpty() && list.isNotEmpty()) {
            nodeResult.add(nodeList)
            result.add(list)
        }
    }

    return result
}

fun main() {
    val treeNode1 = TreeNode(1)
    val treeNode2 = TreeNode(2)
    val treeNode3 = TreeNode(7)
    val treeNode4 = TreeNode(5)
    val treeNode5 = TreeNode(4)
    val treeNode6 = TreeNode(4)
    val treeNode7 = TreeNode(3)
    val treeNode8 = TreeNode(8)
    val treeNode9 = TreeNode(9)

    treeNode1.left = treeNode2
    treeNode1.right = treeNode3
    treeNode2.left = treeNode4
    treeNode2.right = treeNode5
    treeNode3.left = treeNode6
    treeNode3.right = treeNode7
    treeNode4.right = treeNode8
    treeNode7.right = treeNode9

    println(zigzagLevelOrder(treeNode1))
}