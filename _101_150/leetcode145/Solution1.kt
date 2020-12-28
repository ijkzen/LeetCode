package _101_150.leetcode145

import _51_100.leetcode94.TreeNode
import java.util.*
import kotlin.collections.ArrayList

val list1 = ArrayList<Int>()

fun postorderTraversal1(root: TreeNode?): List<Int> {

    val stack = Stack<TreeNode>()

    stack.push(root)
    var pre: TreeNode? = null
    while (stack.isNotEmpty()) {

        val header = stack.peek()

        if ((header.left == null && header.right == null) || (pre != null && (pre == header.left || pre == header.right))) {
            list1.add(header.`val`)
            stack.pop()
            pre = header
        } else {
            header.right?.let {
                stack.push(it)
            }

            header.left?.let {
                stack.push(it)
            }
        }
    }

    return list1
}