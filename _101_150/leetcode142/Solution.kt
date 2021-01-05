package _101_150.leetcode142

import _1_50.leetcode2.ListNode

fun detectCycle(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return null
    }

    val set = HashSet<ListNode>()

    var header = head

    while (header!!.next != null) {
        if (set.contains(header)) {
            return header
        } else {
            set.add(header)
            header = header.next
        }
    }

    return null
}

fun main() {
    val node1 = ListNode(3)
    val node2 = ListNode(2)
    val node3 = ListNode(0)
    val node4 = ListNode(-4)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2

    val header = detectCycle(node1)
    header
}