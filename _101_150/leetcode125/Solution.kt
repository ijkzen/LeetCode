package _101_150.leetcode125

fun isPalindrome(s: String): Boolean {
    if (s.isEmpty()) {
        return true
    }

    var startIndex = 0
    var endIndex = s.length - 1
    val target = s.toUpperCase()

    while (startIndex < endIndex) {
        if (!isValidChar(target[startIndex])) {
            startIndex++
            continue
        }

        if (!isValidChar(target[endIndex])) {
            endIndex--
            continue
        }

        if (target[startIndex] != target[endIndex]) {
            return false
        } else {
            startIndex++
            endIndex--
        }
    }
    return true
}

fun isValidChar(char: Char): Boolean {
    val value = char.toInt()

    return value in 0..9 || value in 48..57 || value in 65..90
}

fun main() {
    println(isPalindrome("0P"))
}