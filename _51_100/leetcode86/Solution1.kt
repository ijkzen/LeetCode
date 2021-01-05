package _51_100.leetcode86

import _1_50.leetcode2.ListNode

fun partition1(head: ListNode?, x: Int): ListNode? {
    if (head == null) {
        return null
    }

    var current = head
    val leftDummy = ListNode(Int.MIN_VALUE)
    val rightDummy = ListNode(Int.MIN_VALUE)
    var leftIndex: ListNode? = null
    var rightIndex: ListNode? = null

    while (current != null) {
        if (current.`val` < x) {
            if (leftIndex == null) {
                leftIndex = current
                leftDummy.next = leftIndex
            } else {
                leftIndex.next = current
                leftIndex = leftIndex.next
            }
        } else {
            if (rightIndex == null) {
                rightIndex = current
                rightDummy.next = rightIndex
            } else {
                rightIndex.next = current
                rightIndex = rightIndex.next
            }
        }

        current = current.next
    }

    leftIndex?.next = null
    rightIndex?.next = null

    if (leftDummy.next == null || rightDummy.next == null) {
        return head
    }

    leftIndex!!.next = rightDummy.next

    return leftDummy.next
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

    println(partition1(n1, 3))
}