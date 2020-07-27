package _51_100.leetcode58

fun lengthOfLastWord(s: String): Int {
    if (s.isEmpty()) {
        return 0
    }

    var result = 0
    for (i in (s.length - 1) downTo 0) {
        if (s[i] == ' ') {
            if (result == 0) {
                continue
            } else {
                break
            }
        } else {
            result++
        }
    }

    return result
}

fun main() {
    println(lengthOfLastWord("Hello World"))
}