package _1_50.leetcode4

/**
 * 2021/05/27 13:52
 * 耗时304ms，超越75.52%
 * 时间复杂度 O(n) = m + n
 */
fun findMedianSortedArrays1(nums1: IntArray, nums2: IntArray): Double {

    var index1 = 0
    var index2 = 0

    val length1 = nums1.size
    val length2 = nums2.size

    if (length1 == 0 && length2 != 0) {
        return if (length2 % 2 == 1) {
            nums2[(length2 + 1) / 2 - 1].toDouble()
        } else {
            val middle = length2 / 2
            (nums2[middle] + nums2[middle - 1]) / 2.0
        }
    } else if (length1 != 0 && length2 == 0) {
        return if (length1 % 2 == 1) {
            nums1[(length1 + 1) / 2 - 1].toDouble()
        } else {
            val middle = length1 / 2
            (nums1[middle] + nums1[middle - 1]) / 2.0
        }
    } else if (length1 == 0 && length2 == 0) {
        return 0.0
    }

    val targetPair: Pair<Int, Int>
    val isSingle: Boolean
    if ((length1 + length2) % 2 == 1) {
        val middle = (length1 + length2 + 1) / 2
        targetPair = middle to middle
        isSingle = true
    } else {
        val middle = (length1 + length2) / 2
        targetPair = middle to (middle + 1)
        isSingle = false
    }

    var wholeIndex = 0

    var first = 0
    var second = 0
    while (index1 < length1 || index2 < length2) {
        val a = if (index1 >= length1) Int.MAX_VALUE else nums1[index1]
        val b = if (index2 >= length2) Int.MAX_VALUE else nums2[index2]

        wholeIndex++
        val value: Int
        if (a > b) {
            index2++
            value = b
        } else {
            index1++
            value = a
        }

        if (isSingle && wholeIndex == targetPair.first) {
            return value.toDouble()
        }

        if (wholeIndex == targetPair.first) {
            first = value
        } else if (wholeIndex == targetPair.second) {
            second = value

            return (first + second) / 2.0
        }
    }

    return 0.0
}

fun main() {
    val a = intArrayOf()
    val b = intArrayOf(3)

    println(findMedianSortedArrays1(a, b))
}