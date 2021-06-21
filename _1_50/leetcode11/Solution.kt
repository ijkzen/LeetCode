package _1_50.leetcode11

/**
 * 执行耗时:496 ms,击败了45.67% 的Kotlin用户
 * 内存消耗:48.3 MB,击败了65.35% 的Kotlin用户
 */
fun maxArea(height: IntArray): Int {
    var result = 0
    var i = 0
    var j = (height.size - 1)
    while (i < j) {
        val a = height[i]
        val b = height[j]
        val tmp = Math.min(a, b) * (j - i)
        if (tmp > result) {
            result = tmp
        }

        if (a > b) {
            j--
        } else {
            i++
        }
    }

    return result
}

fun main() {
    println(maxArea(arrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7).toIntArray()))
}