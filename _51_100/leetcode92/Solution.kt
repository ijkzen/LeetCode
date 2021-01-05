package _51_100.leetcode92

import _1_50.leetcode2.ListNode

fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
    if (m == 0 && n == 0) {
        return head
    } else if (m >= n) {
        return head
    }

    var beforeStartNode: ListNode? = null
    var startNode: ListNode? = null
    var endNode: ListNode? = null
    var afterEndNode: ListNode? = null

    var count = 0
    var first = head
    while (first != null) {
        count++

        if (count == m - 1) {
            beforeStartNode = first
        }

        if (count == m) {
            startNode = first
        }

        if (count == n) {
            endNode = first
            break
        }
        first = first.next
    }
    afterEndNode = endNode?.next

    var preNode: ListNode? = null
    var nextNode: ListNode? = null
    var middleNode: ListNode? = startNode

    while (middleNode != afterEndNode) {
        nextNode = middleNode?.next
        middleNode?.next = preNode
        preNode = middleNode
        middleNode = nextNode
    }

    startNode?.next = afterEndNode
    beforeStartNode?.next = endNode

    return if (beforeStartNode == null) first else head
}

fun main() {
    val n1 = ListNode(1)
    val n2 = ListNode(2)
    val n3 = ListNode(3)
    val n4 = ListNode(4)
    val n5 = ListNode(5)
    val n6 = ListNode(6)
    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5
    n5.next = n6

    println(reverseBetween(n1, 2, 6))
}