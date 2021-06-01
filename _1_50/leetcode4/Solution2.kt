package _1_50.leetcode4

/**
 * 2021/06/01, 14:42
 * 执行耗时296ms，超越90.20%
 * 时间复杂度 O = log(m + n)
 */

fun findMedianSortedArrays2(nums1: IntArray, nums2: IntArray): Double {

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

    return if ((length1 + length2) % 2 == 1) {
        val half = (length1 + length2 + 1) / 2
        getKth(nums1, 0, length1 - 1, nums2, 0, length2 - 1, half)
    } else {
        val half = (length1 + length2) / 2

        (getKth(nums1, 0, length1 - 1, nums2, 0, length2 - 1, half) +
                getKth(nums1, 0, length1 - 1, nums2, 0, length2 - 1, half + 1)
                ) / 2.0
    }
}

fun getKth(a: IntArray, start1: Int, end1: Int, b: IntArray, start2: Int, end2: Int, k: Int): Double {
    val length1 = end1 - start1 + 1
    val length2 = end2 - start2 + 1

    if (length1 > length2) {
        return getKth(b, start2, end2, a, start1, end1, k)
    }

    if (length1 == 0) {
        return b[start2 + k - 1].toDouble()
    }

    if (k == 1) {
        return Math.min(a[start1], b[start2]).toDouble()
    }

    val i = start1 + Math.min(length1, k / 2) - 1
    val j = start2 + Math.min(length2, k / 2) - 1

    return if (a[i] > b[j]) {
        getKth(a, start1, end1, b, j + 1, end2, k - (j - start2 + 1))
    } else {
        getKth(a, i + 1, end1, b, start2, end2, k - (i - start1 + 1))
    }
}

fun main() {
    val a = intArrayOf(1)
    val b = intArrayOf(2,3,4,5,6)

    println(findMedianSortedArrays2(a, b))
}

