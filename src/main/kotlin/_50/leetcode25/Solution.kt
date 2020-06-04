package _50.leetcode25

import _50.leetcode2.ListNode
import java.util.*

var start: ListNode? = null
var end: ListNode? = null
val resultList: MutableList<Pair> = LinkedList()

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    start = head
    var newHead: ListNode? = head
    var isNewHeadSet = false

    while (isKEnough(start, k)) {

        if (!isNewHeadSet) {
            newHead = end
            isNewHeadSet = true
        }

        reverse(start!!, end!!)
        start = start!!.next
    }

    for (i in resultList.indices) {
        if (i < resultList.size - 1) {
            val nextPair = resultList[i + 1]
            val thisPair = resultList[i]

            thisPair.end.next = nextPair.start
        }
    }

    return newHead
}

fun isKEnough(start: ListNode?, k: Int): Boolean {
    if (start == null) {
        return false
    }

    var i = 1
    var startTmp = start
    while (i < k) {
        end = startTmp?.next
        if (end != null) {
            i++
            startTmp = end!!
        } else {
            break
        }
    }

    if (end != null) {
        resultList.add(Pair(end!!, start))
    }

    return end != null
}

fun reverse(start: ListNode, end: ListNode): ListNode {
    val first = start
    var head: ListNode? = start
    val last = end.next

    var pre: ListNode? = null
    var next: ListNode? = null
    while (head != last) {
        next = head?.next
        head?.next = pre
        pre = head
        head = next
    }

    first.next = last
    return pre!!
}

data class Pair(val start: ListNode, val end: ListNode)

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

    println(reverseKGroup(n1, 3))

}
