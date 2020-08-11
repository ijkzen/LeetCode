package _101_150.leetcode113

import _51_100.leetcode94.TreeNode


fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    hasPathSum(root, sum, ArrayList(), result)
    return result
}

fun hasPathSum(root: TreeNode?, sum: Int, currentList: MutableList<Int>, result: ArrayList<ArrayList<Int>>) {
    if (root == null) {
        return
    }

    currentList.add(root.`val`)
    if (sum == root.`val` && root.left == null && root.right == null) {
        result.add(ArrayList(currentList))
    } else {
        if (root.left != null) {
            hasPathSum(root.left, sum - root.`val`, currentList, result)
            currentList.removeAt(currentList.size - 1)
        }

        if (root.right != null) {
            hasPathSum(root.right, sum - root.`val`, currentList, result)
            currentList.removeAt(currentList.size - 1)
        }
    }
}

fun main() {
    val node1 = TreeNode(5)
    val node2 = TreeNode(4)
    val node3 = TreeNode(8)
    val node4 = TreeNode(11)
    val node5 = TreeNode(13)
    val node6 = TreeNode(4)
    val node7 = TreeNode(7)
    val node8 = TreeNode(2)
    val node9 = TreeNode(5)
    val node10 = TreeNode(1)

    node1.left = node2
    node1.right = node3
    node2.left = node4
    node3.left = node5
    node3.right = node6
    node4.left = node7
    node4.right = node8
    node6.left = node9
    node6.right = node10

    println(pathSum(node1, 22))
}