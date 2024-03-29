package _1_50.leetcode4

/**
 * 2021/05/26 13:45
 * 耗时296ms，超越89.44%
 * 但是我已经看不懂这个算法了，很烦；
 */
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val a: IntArray
    val b: IntArray

    if (nums1.size > nums2.size) {
        a = nums2
        b = nums1
    } else {
        a = nums1
        b = nums2
    }

    val m = a.size
    val n = b.size

    var imin = 0
    var imax = m
    val half: Int = (m + n + 1) / 2

    var i: Int
    var j: Int

    while (imin <= imax) {
        i = (imin + imax) / 2
        j = half - i
        if (i < imax && b[j - 1] > a[i]) {
            imin = i + 1
        } else if (i > imin && a[i - 1] > b[j]) {
            imax = i - 1
        } else {
            val maxLeft: Int = when {
                i == 0 -> {
                    b[j - 1]
                }
                j == 0 -> {
                    a[i - 1]
                }
                else -> {
                    Math.max(a[i - 1], b[j - 1])
                }
            }

            if ((m + n) % 2 == 1) {
                return maxLeft.toDouble()
            }

            val minRight: Int = when {
                i == m -> {
                    b[j]
                }
                j == n -> {
                    a[i]
                }
                else -> {
                    Math.min(b[j], a[i])
                }
            }

            return (maxLeft + minRight) / 2.0
        }
    }

    return 0.0
}

fun main() {
    val a = intArrayOf(1, 2, 4)
    val b = intArrayOf(3, 5, 6, 7)

    println(findMedianSortedArrays(a, b))
}