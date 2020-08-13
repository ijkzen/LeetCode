package _101_150.leetcode116

data class Node(var `val`: Int, var left: Node? = null, var right: Node? = null, var next: Node? = null)

fun connect(root: Node?): Node? {
    connectNext(root)
    return root
}

fun connectNext(root: Node?) {
    if (root == null) {
        return
    }

    root.left?.let {
        root.left!!.next = root.right
    }

    root.right?.let {
        root.right!!.next = root.next?.left
    }

    connectNext(root.left)
    connectNext(root.right)
}