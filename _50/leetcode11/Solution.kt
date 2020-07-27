package _50.leetcode11

fun maxArea(height: IntArray): Int {
    var result = 0
    var i = 0
    var j = (height.size - 1)
    while (i < j) {
        val a = height[i]
        val b = height[j]
        val tmp = a.coerceAtMost(b) * (j - i)
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