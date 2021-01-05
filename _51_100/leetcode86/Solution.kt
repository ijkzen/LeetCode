package _51_100.leetcode86

import _1_50.leetcode2.ListNode
import java.util.*

fun partition(head: ListNode?, x: Int): ListNode? {
    if (head == null) {
        return null
    }

    val left : Queue<ListNode> = LinkedList()
    val right : Queue<ListNode> = LinkedList()

    var current = head

    while (current != null) {
        if (current.`val` < x) {
            left.offer(current)
        } else {
            right.offer(current)
        }
        current = current.next
    }

    val dummy = ListNode(Int.MIN_VALUE)
    var index = dummy

    while (left.isNotEmpty()) {
        index.next = left.poll()
        index = index.next!!
    }
    index.next = null

    while (right.isNotEmpty()) {
        index.next = right.poll()
        index = index.next!!
    }
    index.next = null

    return dummy.next
}

fun main() {
    val n1 = ListNode(1)
    val n2 = ListNode(4)
    val n3 = ListNode(3)
    val n4 = ListNode(2)
    val n5 = ListNode(5)
    val n6 = ListNode(2)

    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5
    n5.next = n6

    println(partition(n1, 3))
}