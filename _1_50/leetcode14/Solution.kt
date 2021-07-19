package _1_50.leetcode14

/**
 * 执行耗时:160 ms,击败了98.92% 的Kotlin用户
 * 内存消耗:34.2 MB,击败了97.85% 的Kotlin用户
 */
fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }

    val minSize = minSize(strs)
    val builder = StringBuilder()
    for (i in 0 until minSize) {
        if (isEqual(i, strs)) {
            builder.append(strs[0][i])
        } else {
            break
        }
    }
    return builder.toString()
}

fun minSize(strs: Array<String>): Int {
    var minSize = strs[0].length
    strs.forEach {
        if (it.length < minSize) {
            minSize = it.length
        }
    }

    return minSize
}

fun isEqual(number: Int, strs: Array<String>): Boolean {
    val first = strs[0][number]
    for (i in strs.indices) {
        if (strs[i][number] != first) {
            return false
        }
    }

    return true
}

fun main() {
    println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
}