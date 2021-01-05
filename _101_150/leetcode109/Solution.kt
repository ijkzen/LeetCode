package _101_150.leetcode109

import _1_50.leetcode2.ListNode
import _51_100.leetcode94.TreeNode

fun sortedListToBST(head: ListNode?): TreeNode? {

    var node = head
    val list = ArrayList<Int>()

    while (node != null) {
        list.add(node.`val`)
        node = node.next
    }

    return sortedArrayToBST(list.toIntArray())
}

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if (nums.isEmpty()) {
        return null
    }

    return sortedArrayToBST(nums, 0, nums.size - 1)
}

fun sortedArrayToBST(nums: IntArray, left: Int, right: Int): TreeNode? {
    if (left > right) {
        return null
    }

    if (right - left == 2) {
        val middle = (left + right) / 2
        val leftNode = TreeNode(nums[left])
        val rightNode = TreeNode(nums[right])
        return TreeNode(nums[middle], leftNode, rightNode)
    }

    if (right - left == 1) {
        val leftNode = TreeNode(nums[left])
        return TreeNode(nums[right], leftNode, null)
    }

    if (right == left) {
        return TreeNode(nums[left])
    }

    val middle = (left + right) / 2
    val root = TreeNode(nums[middle])
    root.left = sortedArrayToBST(nums, left, middle - 1)
    root.right = sortedArrayToBST(nums, middle + 1, right)

    return root
}