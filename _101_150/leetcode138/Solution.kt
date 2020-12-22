package _101_150.leetcode138

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

val map = HashMap<Int, Node>()

fun copyRandomList(node: Node?): Node? {
    if (node == null) {
        return null
    }

    return copyRandomList(node, 0)
}

fun copyRandomList(node: Node, currentIndex: Int): Node? {
    val header = Node(node.`val`)
    map[currentIndex] = header

    if (node.next != null) {
        header.next = copyRandomList(node.next!!, currentIndex + 1)
    }

    if (node.random != null) {
        header.random = map[node.random!!.`val`]
    }

    return header
}

fun main() {
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)

    node1.next = node2
    node2.next = node3

    node1.random = Node(2)

    val result = copyRandomList(node1)
    result
}