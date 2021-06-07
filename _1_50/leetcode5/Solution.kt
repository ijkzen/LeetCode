package _1_50.leetcode5

/**
 * @author ijkzen
 * @since 2020/4/13
 * 执行耗时232ms，超越92.56%
 * 时间复杂度 O(n) = n * n
 */
fun longestPalindrome(s: String): String {
    var maxLength = 0
    var start = 0
    var end = 0
    if (s.length == 1 || "" == s) {
        return s
    } else {
        for (i in s.indices) {
            val length1 = length(s, i, i)
            val length2 = length(s, i, i + 1)
            val length = if (length1 > length2) length1 else length2

            if (length > maxLength) {
                start = i - (length - 1) / 2
                end = i + length / 2
                maxLength = length
            }
        }

        return s.substring(start, end + 1)
    }

}

private fun length(str: String, start: Int, end: Int): Int {
    var l = start
    var r = end
    while (l >= 0 && r < str.length && str[l] == str[r]) {
        l--
        r++
    }
    return r - l - 1
}

fun main() {
    println(longestPalindrome("bb"))
}