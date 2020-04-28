package one_h.leetcode19

import one_h.leetcode2.ListNode

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null) {
        return null
    }

    val newHead = inverse(head)!!
    var i = 0

    if (n == 1) {
        return inverse(newHead.next)
    }

    var currentHead = newHead
    while (i < n - 2) {
        i++
        currentHead = currentHead.next!!
    }

    val next = currentHead.next
    val tmp = next!!.next
    next.next = null
    currentHead.next = tmp

    return inverse(newHead)
}

private fun inverse(node: ListNode?): ListNode? {
    if (node?.next == null) {
        return node
    }

    val newHead = inverse(node.next!!)

    val tmp = node.next
    tmp!!.next = node
    node.next = null

    return newHead
}

fun main() {
    val n1 = ListNode(1)
    val n2 = ListNode(2)
    val n3 = ListNode(3)
    val n4 = ListNode(4)
    val n5 = ListNode(5)
    val n6 = ListNode(6)
    val n7 = ListNode(7)
    val n8 = ListNode(8)
    val n9 = ListNode(9)
    val n10 = ListNode(10)


    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5
    n5.next = n6
    n6.next = n7
    n7.next = n8
    n8.next = n9
    n9.next = n10

    println(removeNthFromEnd(n1, 7))
}