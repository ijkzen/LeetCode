package _1_50.leetcode6

/**
 * 执行耗时268ms，超越57.63%
 * 时间复杂度 O(n) = n
 */
fun convert(s: String, numRows: Int): String {
    if (numRows >= s.length || numRows == 1) {
        return s
    }

    val list = java.util.ArrayList<StringBuilder>(numRows)
    for (i in 0 until numRows) {
        list.add(StringBuilder())
    }
    var currentRow = 0
    var goingDown = -1
    for (char in s) {
        list[currentRow].append(char)
        if (currentRow == 0 || currentRow == numRows - 1) {
            goingDown = -goingDown
        }
        currentRow = currentRow + goingDown
    }

    val finalBuilder = StringBuilder()
    list.forEach {
        finalBuilder.append(it)
    }

    return finalBuilder.toString()
}

fun main() {
    println(convert("AB", 1))
}