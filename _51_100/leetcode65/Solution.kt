package _51_100.leetcode65

fun isNumber(s: String): Boolean {

    var currentStatus = 0

    val table = Array<IntArray>(10) {
        when (it) {
            0 -> {
                intArrayOf(1, 2, 4, -1, 0, -1)
            }
            1 -> {
                intArrayOf(-1, 2, 4, -1, -1, -1)
            }
            2 -> {
                intArrayOf(-1, 2, 3, 6, 9, -1)
            }
            3 -> {
                intArrayOf(-1, 5, -1, 6, 9, -1)
            }
            4 -> {
                intArrayOf(-1, 5, -1, -1, -1, -1)
            }
            5 -> {
                intArrayOf(-1, 5, -1, 6, 9, -1)
            }
            6 -> {
                intArrayOf(7, 8, -1, -1, -1, -1)
            }
            7 -> {
                intArrayOf(-1, 8, -1, -1, -1, -1)
            }
            8 -> {
                intArrayOf(-1, 8, -1, -1, 9, -1)
            }
            9 -> {
                intArrayOf(-1, -1, -1, -1, 9, -1)
            }
            else -> {
                throw ArrayIndexOutOfBoundsException()
            }
        }
    }

    for (i in s.indices) {
        val tmpStatus = table[currentStatus][getCharIndex(s[i])]
        if (tmpStatus != -1) {
            currentStatus = tmpStatus
        } else {
            return false
        }
    }

    if (currentStatus in intArrayOf(2, 3, 5, 8, 9)) {
        return true
    }

    return false
}

fun getCharIndex(char: Char): Int {
    return if (char == '-' || char == '+') {
        0
    } else if (char in '0'..'9') {
        1
    } else if (char == '.') {
        2
    } else if (char == 'e') {
        3
    } else if (char == ' ') {
        4
    } else {
        5
    }
}

fun main() {
    println(isNumber("."))
}