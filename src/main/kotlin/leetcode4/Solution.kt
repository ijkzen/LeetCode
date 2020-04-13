package leetcode4

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
        if (b[j - 1] > a[i] && i < imax) {
            imin = i + 1
        } else if (a[i - 1] > b[j] && i > imin) {
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
                    a[i - 1].coerceAtLeast(b[j - 1])
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
                    b[j].coerceAtMost(a[i])
                }
            }

            return (maxLeft + minRight) / 2.0
        }
    }

    return 0.0
}

fun main() {
    val a = intArrayOf(1, 2, 3, 4, 5)
    val b = intArrayOf(6, 7, 8)

    println(findMedianSortedArrays(a, b))
}