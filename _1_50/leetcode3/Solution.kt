package _1_50.leetcode3

/**
 * @author ijkzen
 * @since 2020/4/11
 *
 * 执行耗时216ms，超越95.86%
 * 原本执行耗时268ms，更改了较大值比较算法；从 kotlin 的 coerceAtLeast 变为 Math.max，
 * coerceAtLeast 是扩展函数可能有额外的开销；
 */
fun lengthOfLongestSubstring(s: String): Int {
    var finalLength = 0
    var i = 0
    var j = 0
    val map: MutableMap<Char, Int> = HashMap()
    val length = s.length
    while (i < length && j < length) {
        if (map.containsKey(s[j])) {
            i = Math.max(i, map[s[j]]!!)
        }

        finalLength = Math.max(finalLength, j - i + 1)
        map[s[j]] = ++j
    }

    return finalLength
}

fun main() {
    println(lengthOfLongestSubstring("aasd"))
}