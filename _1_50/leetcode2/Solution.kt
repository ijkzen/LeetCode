package _1_50.leetcode2

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * 2021/05/19 10:56
 * 运行耗时232ms，超越97.29%
 * 时间复杂度 O() = max(m + n)
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var isCarry = false
    if (l1 == null) {
        return l2
    } else if (l2 == null) {
        return l1
    } else {
        var param1 = l1
        var param2 = l2
        var result = ListNode(0)
        val final = result
        while (param1 != null || param2 != null) {
            result.next = ListNode(0)
            result = result.next!!
            result.`val` = getResult(param1, param2, isCarry) % 10
            isCarry = getResult(param1, param2, isCarry) >= 10
            param1 = param1?.next
            param2 = param2?.next
        }
        if (isCarry) {
            result.next = ListNode(1)
        }
        return final.next
    }
}

fun getResult(n1: ListNode?, n2: ListNode?, isCarry: Boolean): Int {
    var result = 0
    if (n1 == null && n2 == null) {
        result = 0
    } else if (n1 == null && n2 != null) {
        result = n2.`val` + if (isCarry) 1 else 0
    } else if (n1 != null && n2 == null) {
        result = n1.`val` + if (isCarry) 1 else 0
    } else if (n1 != null && n2 != null) {
        result = (n1.`val` + n2.`val`) + if (isCarry) 1 else 0
    }
    return result
}

fun main() {
    val param1 = ListNode(5)
    param1.next = ListNode(4)
//    param1.next?.next = ListNode(3)

    val param2 = ListNode(5)
//    param2.next = ListNode(6)
//    param2.next?.next = ListNode(4)

    println(addTwoNumbers(param1, param2))
}