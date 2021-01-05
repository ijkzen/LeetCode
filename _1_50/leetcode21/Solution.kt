package _1_50.leetcode21

import _1_50.leetcode2.ListNode

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var list1: ListNode? = l1
    var list2: ListNode? = l2

    val head = ListNode(Int.MIN_VALUE)
    var last = head

    while (list1 != null && list2 != null) {
        if (list1.`val` < list2.`val`) {
            last.next = list1
            list1 = list1.next
        } else {
            last.next = list2
            list2 = list2.next
        }

        last = last.next!!
    }

    last.next = list1 ?: list2

    return head.next
}

fun main() {
    val n1 = ListNode(1)
    val n2 = ListNode(2)
    val n3 = ListNode(3)
    val n4 = ListNode(4)
    n1.next = n2
    n2.next = n3
    n3.next = n4

    val n6 = ListNode(6)
    val n7 = ListNode(7)
    val n8 = ListNode(8)
    val n9 = ListNode(9)
    val n10 = ListNode(10)
    n6.next = n7
    n7.next = n8
    n8.next = n9
    n9.next = n10

    println(mergeTwoLists(n1, n6))
}