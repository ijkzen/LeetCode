package _51_100.leetcode82

import _50.leetcode2.ListNode

fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head == null) {
        return head
    }

    val firstNode = ListNode(Int.MIN_VALUE)
    firstNode.next = head

    var last = head
    var lastButOne = firstNode

    while (last != null) {
        var isDuplicate = false
        while (last!!.next != null && last.`val` == last.next!!.`val`) {
            isDuplicate = true
            last = last.next
        }

        if (isDuplicate) {
            lastButOne.next = last.next
            last = last.next
            isDuplicate = false
        } else {
            lastButOne = last
            last = last.next
        }
    }


    return firstNode.next
}

fun main() {
    val n1 = ListNode(1)
    val n2 = ListNode(1)
    val n3 = ListNode(1)
    val n4 = ListNode(4)
    val n5 = ListNode(5)
    val n6 = ListNode(5)
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

    println(deleteDuplicates(n1))
}