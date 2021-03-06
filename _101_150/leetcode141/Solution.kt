package _101_150.leetcode141

import _1_50.leetcode2.ListNode

fun hasCycle(head: ListNode?): Boolean {
    if (head == null) {
        return false
    }

    val set = HashSet<ListNode>()

    var header = head

    while (header!!.next != null) {
        set.add(header)
        if (set.contains(header.next)) {
            return true
        } else {
            header = header.next
        }
    }

    return false
}

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    node5.next = node1

    println(hasCycle(node1))
}