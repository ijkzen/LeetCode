package _101_150.leetcode114

import _51_100.leetcode94.TreeNode

fun flatten(root: TreeNode?): Unit {
    var current = root

    while (current != null) {
        if (current.left != null) {
            getMaxRightNode(current.left!!).right = current.right
            current.right = current.left
            current.left = null
            current = current.right
        } else {
            current = current.right
        }
    }
}

fun getMaxRightNode(root: TreeNode): TreeNode {
    if (root.left == null && root.right == null) {
        return root
    }

    return if (root.right == null) {
        getMaxRightNode(root.left!!)
    } else {
        getMaxRightNode(root.right!!)
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

    flatten(node1)

    println(node1)
}