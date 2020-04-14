package leetcode6

import java.util.*

fun convert(s: String, numRows: Int): String {
    val list = LinkedList<StringBuilder>()
    if (numRows >= s.length || numRows == 1) {
        return s
    }

    for (i in 0 until numRows) {
        list.add(StringBuilder())
    }
    var currentRow = 0
    val iterator = s.iterator()
    var goingDown = false
    while (iterator.hasNext()) {
        list[currentRow].append(iterator.next())
        if (currentRow == 0 || currentRow == numRows - 1) {
            goingDown = !goingDown
        }
        currentRow = if (goingDown) currentRow + 1 else currentRow - 1

        if (numRows == 1) {
            currentRow = 0
        }
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