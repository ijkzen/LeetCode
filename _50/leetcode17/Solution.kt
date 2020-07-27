package _50.leetcode17

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