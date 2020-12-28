package _101_150.leetcode144

import _51_100.leetcode94.TreeNode
import java.util.*
import kotlin.collections.ArrayList

val list1 = ArrayList<Int>()

fun preorderTraversal1(root: TreeNode?): List<Int> {
    if (root == null) {
        return arrayListOf()
    }

    val stack = Stack<TreeNode>()
    stack.push(root)

    while (stack.isNotEmpty()) {
        val header = stack.pop()
        list1.add(header.`val`)

        header.right?.let {
            stack.push(it)
        }

        header.left?.let {
            stack.push(it)
        }
    }

    return list1
}
