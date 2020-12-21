package _101_150.leetcode133

class Node(var `val`: Int){
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}

val map = HashMap<Int, Node>()

fun cloneGraph(node: Node?): Node? {
    if (node == null) {
        return null
    }

    val root = Node(node.`val`)
    map[root.`val`] = root
    if (node.neighbors.isNotEmpty()) {
        for (neighbor in node.neighbors) {
            if (map[neighbor!!.`val`] == null) {
                val edge = cloneGraph(neighbor)
                map[neighbor.`val`] = edge!!
                root.neighbors.add(edge)
            } else {
                root.neighbors.add(map[neighbor.`val`])
            }
        }
    }

    return root
}

fun main() {
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)

    node1.neighbors.addAll(arrayListOf(node2, node4))
    node2.neighbors.addAll(arrayListOf(node1, node3))
    node3.neighbors.addAll(arrayListOf(node2, node4))
    node4.neighbors.addAll(arrayListOf(node1, node3))

    val root = cloneGraph(node1)
}
