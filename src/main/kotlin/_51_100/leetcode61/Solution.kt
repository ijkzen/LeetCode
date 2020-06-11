package _51_100.leetcode61

import _50.leetcode2.ListNode

fun rotateRight(head: ListNode?, k: Int): ListNode? {

    if (head == null) {
        return head
    }

    var tmpHead = head
    var originEnd: ListNode? = null
    var length = 0
    while (tmpHead != null) {
        length++

        if (tmpHead.next == null) {
            originEnd = tmpHead
        }

        tmpHead = tmpHead.next
    }

    val step = length - k % length

    if (step == 0) {
        return head
    } else {
        originEnd!!.next = head
        var newStart = head

        var index = 0
        var newEnd: ListNode? = null
        while (index != step) {
            if ((index + 1) == step) {
                newEnd = newStart
            }

            newStart = newStart!!.next
            index++
        }

        newEnd!!.next = null

        return newStart
    }
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

    println(rotateRight(n1, 2).toString())
}