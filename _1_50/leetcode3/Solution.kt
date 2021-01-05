package _1_50.leetcode3

/**
 * @author ijkzen
 * @since 2020/4/11
 */
fun lengthOfLongestSubstring(s: String): Int {
    var finalLength = 0
    var i = 0
    var j = 0
    val map: MutableMap<Char, Int> = HashMap()
    val length = s.length
    while (i < length && j < length) {
        if (map.containsKey(s[j])) {
            i = (map.getValue(s[j])).coerceAtLeast(i)
        }

        finalLength = finalLength.coerceAtLeast(j - i + 1)
        map[s[j]] = ++j
    }

    return finalLength
}

fun main() {
    println(lengthOfLongestSubstring("aasd"))
}