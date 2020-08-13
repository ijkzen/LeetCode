package _101_150.leetcode117

import _101_150.leetcode116.Node

fun connect(root: Node?): Node? {
    connectNext(root)
    return root
}

fun connectNext(root: Node?){
    if (root == null) {
        return
    }

    val rootNext: Node? = getValidRootNext(root)
    if (root.left != null) {
        if (root.right != null) {
            root.left!!.next = root.right
        } else {
            if (rootNext != null) {
                root.left!!.next = if (rootNext.left == null) rootNext.right else rootNext.left
            }
        }
    }

    if (root.right != null && rootNext != null) {
        root.right!!.next = if (rootNext.left == null) rootNext.right else rootNext.left
    }

//  right tree first
    connectNext(root.right)
    connectNext(root.left)
}

fun getValidRootNext(root: Node?): Node?{
    if (root?.next == null) {
        return null
    }

    var next = root.next
    while (next != null) {
        if (next.left == null && next.right == null) {
            next = next.next
        } else {
            return next
        }
    }

    return null
}

fun main() {
    val node1 = Node(2)
    val node2 = Node(1)
    val node3 = Node(3)
    val node4 = Node(0)
    val node5 = Node(7)
    val node6 = Node(9)
    val node7 = Node(1)
    val node8 = Node(2)
    val node9 = Node(1)
    val node10 = Node(0)
    val node11 = Node(8)
    val node12 = Node(8)
    val node13 = Node(7)

    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5
    node3.left = node6
    node3.right = node7
    node4.left = node8
    node5.left = node9
    node5.right = node10
    node7.left = node11
    node7.right = node12
    node10.left = node13

    connect(node1)
}