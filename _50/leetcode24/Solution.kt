package _50.leetcode24

import _50.leetcode2.ListNode

fun swapPairs(head: ListNode?): ListNode? {
    val result = if (head?.next == null) head else head.next
    var pre: ListNode? = head
    var next: ListNode? = head?.next

    while (next != null && pre != null) {
        val tmp = next.next
        next.next = pre
        pre.next = if (tmp?.next == null) tmp else tmp.next

        pre = tmp
        next = pre?.next
    }

    return result
}

fun main() {
    val n1 = ListNode(1)
    val n2 = ListNode(2)
    val n3 = ListNode(3)
    val n4 = ListNode(4)
    val n5 = ListNode(5)
    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5

    println(swapPairs(n1))
}