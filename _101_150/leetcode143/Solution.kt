package _101_150.leetcode143

import _1_50.leetcode2.ListNode
import java.util.*
import kotlin.math.ceil

fun reorderList(head: ListNode?): Unit {
    val order: Deque<ListNode> = LinkedList()
    val reverse: Queue<ListNode> = LinkedList()

    var header = head
    var count = 0
    while (header != null) {
        count++
        order.add(header)
        header = header.next
    }

    var tmp = count
    val until = ceil(tmp / 2.0)
    while (tmp > until) {
        tmp--
        reverse.add(order.pollLast())
    }

    header = null
    while (count > 0) {
        if (header == null) {
            header = order.poll()
            count--
        } else {
            header.next = order.poll()
            header = header.next
            count--
        }

        header?.next = reverse.poll()
        header = header?.next
        count--
    }

    header?.next = null
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
    //node4.next = node5

    reorderList(node1)
}