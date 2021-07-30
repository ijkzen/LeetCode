package _1_50.leetcode17

/**
 * 执行耗时:148 ms,击败了93.15% 的Kotlin用户
 * 内存消耗:34.6 MB,击败了75.34% 的Kotlin用户
 */
import java.util.HashMap

val result = ArrayList<String>()
val map = HashMap<String, String>()

fun letterCombinations(digits: String): List<String> {

    if ("" == digits) {
        return result
    }

    map["2"] = "abc"
    map["3"] = "def"
    map["4"] = "ghi"
    map["5"] = "jkl"
    map["6"] = "mno"
    map["7"] = "pqrs"
    map["8"] = "tuv"
    map["9"] = "wxyz"

    single("", 0, digits)

    return result
}

private fun single(pre: String, index: Int, origin: String) {
    if (index == origin.length) {
        result.add(pre)
        return
    }

    val currentSet = map[origin.substring(index, index + 1)]
    if (currentSet != null) {
        for (i in currentSet.indices) {
            single(pre + currentSet[i], index + 1, origin)
        }
    }
}

fun main() {
    println(letterCombinations("23"))
}