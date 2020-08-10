package _101_150.leetcode106

import _51_100.leetcode94.TreeNode

fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
    if (postorder.isEmpty() || postorder.size != inorder.size) {
        return null
    }
    val map = HashMap<Int, Int>()
    for (i in inorder.indices) {
        map[inorder[i]] = i
    }

    return buildTree(postorder, map, postorder.size - 1, 0, postorder.size - 1)
}

/**
 * startIndex: current tree root node index in postorder
 * leftIndex: left border in inorder
 * rightIndex: right border in in order
 */
fun buildTree(postorder: IntArray, inorderMap: Map<Int, Int>, startIndex: Int, leftIndex: Int, rightIndex: Int): TreeNode? {
    if (leftIndex > rightIndex) {
        return null
    }

    val root = TreeNode(postorder[startIndex])
    val middle = inorderMap[root.`val`]!!
    val rightTreeLength = rightIndex - middle
    val leftTreeLength = middle - leftIndex
    if (leftTreeLength > 0) {
        root.left = buildTree(postorder, inorderMap, startIndex - rightTreeLength - 1, leftIndex, leftIndex + leftTreeLength - 1)
    }
    if (rightTreeLength > 0) {
        root.right = buildTree(postorder, inorderMap, startIndex - 1, middle + 1, rightIndex)
    }

    return root
}

fun main() {
    val inorder = intArrayOf(9, 3, 15, 20, 7)
    val postorder = intArrayOf(9, 15, 7, 20, 3)

    println(buildTree(inorder, postorder))
}