package _101_150.leetcode105

import _51_100.leetcode94.TreeNode

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty() || preorder.size != inorder.size) {
        return null
    }
    val map = HashMap<Int, Int>()
    for (i in inorder.indices) {
        map[inorder[i]] = i
    }

    return buildTree(preorder, map, 0, 0, preorder.size - 1)
}

fun buildTree(preorder: IntArray, inorderMap: Map<Int, Int>, startIndex: Int, leftIndex: Int, rightIndex: Int): TreeNode? {
    if (leftIndex > rightIndex) {
        return null
    }

    val root = TreeNode(preorder[startIndex])
    val middle = inorderMap[preorder[startIndex]]!!
    val leftTreeLength = middle - leftIndex
    if (leftTreeLength > 0) {
        root.left = buildTree(preorder, inorderMap, startIndex + 1, leftIndex, leftIndex + leftTreeLength - 1)
    }
    root.right = buildTree(preorder, inorderMap, startIndex + leftTreeLength + 1, middle + 1, rightIndex)

    return root
}

fun main() {
    val preorder = intArrayOf(3, 20, 15, 7)
    val inorder = intArrayOf(3, 15, 20, 7)

    println(buildTree(preorder, inorder))
}