package _51_100.leetcode99

import _51_100.leetcode94.TreeNode
import java.util.*

fun recoverTree(root: TreeNode?): Unit {
    if (root == null) {
        return
    }

    var first: TreeNode? = null
    var second: TreeNode? = null
    val stack: Deque<TreeNode> = ArrayDeque<TreeNode>()
    var current: TreeNode? = root
    var last: TreeNode? = null

    while (stack.isNotEmpty() || current != null) {
        while (current != null) {
            stack.add(current)
            current = current.left
        }

        current = stack.removeLast()

        if (last != null && current.`val` < last.`val`) {
            second = current
            if (first == null) {
                first = last
            }
        }

        last = current
        current = current.right
    }

    val tmp = second!!.`val`
    second.`val` = first!!.`val`
    first.`val` = tmp
}

fun main() {
    val tree1 = TreeNode(3, null, null)
    val tree2 = TreeNode(1, null, null)
    val tree3 = TreeNode(4, null, null)
    val tree4 = TreeNode(2, null, null)
//    val tree5 = TreeNode(7, null, null)
//    val tree6 = TreeNode(5, null, null)

    tree1.left = tree2
    tree1.right = tree3
    tree3.left = tree4

    recoverTree(tree1)
}