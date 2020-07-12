package _51_100.leetcode88

import _50.leetcode1.string

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    if (n == 0) {
        return
    }else if (m == 0) {
        System.arraycopy(nums2, 0, nums1, m, n)
        return
    }

    var p1 = m - 1
    var p2 = n - 1
    var p = nums1.size - 1

    while (p1 >= 0 && p2 >= 0) {

        if (nums1[p1] > nums2[p2]) {
            nums1[p] = nums1[p1]
            p--
            p1--
        } else {
            nums1[p] = nums2[p2]
            p--
            p2--
        }
    }

    System.arraycopy(nums2, 0, nums1, 0, p2 + 1)
}

fun main() {
    val num1 = intArrayOf(1, 2, 3, 0, 0, 0)
    merge(num1, 3, intArrayOf(2, 5, 6), 3)

    println(num1.string())
}