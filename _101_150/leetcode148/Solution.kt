package _101_150.leetcode148

import _50.leetcode2.ListNode

fun sortList(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }

    var header = head
    val list = ArrayList<ListNode>()

    while (header != null) {
        list.add(header)
        header = header.next
    }

    list.sortBy { it.`val` }

    val root = ListNode(Int.MIN_VALUE)
    var pre = root
    for (element in list) {
        pre.next = element
        pre = element
    }
    pre.next = null

    return root.next
}