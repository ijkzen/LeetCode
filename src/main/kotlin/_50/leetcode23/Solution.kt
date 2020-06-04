package _50.leetcode23

import _50.leetcode2.ListNode

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    return merge(lists, 0, lists.size - 1)
}

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

fun merge(lists: Array<ListNode?>, left: Int, right: Int): ListNode? {

    return when {
        left == right -> {
            lists[left]
        }
        left > right -> {
            null
        }
        else -> {
            val mid = (left + right) / 2
            mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right))
        }
    }
}