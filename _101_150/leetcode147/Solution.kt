package _101_150.leetcode147

import _50.leetcode2.ListNode

fun insertionSortList(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }

    val root = ListNode(Int.MIN_VALUE)
    var rootPointer :ListNode? = root
    var header = head
    while (header != null) {
        rootPointer = root
        var pre = rootPointer
        while (rootPointer != null && header.`val` > rootPointer.`val`) {
            pre = rootPointer
            rootPointer = rootPointer.next
        }
        val next = header.next
        header.next = pre!!.next
        pre.next = header
        header = next
    }

    return root.next
}

fun main() {
    val node1 = ListNode(4)
    val node2 = ListNode(2)
    val node3 = ListNode(1)
    val node4 = ListNode(3)
    val node5 = ListNode(5)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    insertionSortList(node1)
}