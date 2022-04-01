package _2001_2050.leetcode2024

/**
 * 
 */
fun maxConsecutiveAnswers1(answerKey: String, k: Int): Int {
    if (answerKey == "") {
        return 0
    }

    if (k >= answerKey.length / 2) {
        return answerKey.length
    }

    return Math.max(maxConsecutiveChar(answerKey, 'T', k), maxConsecutiveChar(answerKey, 'F', k))
}


fun maxConsecutiveChar(answerKey: String, char: Char, k: Int): Int {
        var left = 0
        var invalidSum = 0
        var result = 0
        for (right in 0 until answerKey.length) {
            invalidSum += if (answerKey[right] != char) 1 else 0
            while(invalidSum > k) {
                invalidSum -= if (answerKey[left++] != char ) 1 else 0
            }

            result = Math.max(result, right - left + 1)
        }

        return result
    }

fun main() {
    val answerKey = "TTFTTFTT"
    println(maxConsecutiveAnswers1(answerKey, 2))
}