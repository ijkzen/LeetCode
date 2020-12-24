package _101_150.leetcode139

fun wordBreak1(s: String, wordDict: List<String>): Boolean {
    if (wordDict.isEmpty()) {
        return false
    }

    val wordSet = HashSet(wordDict)
    val dp = BooleanArray(s.length + 1) { false }
    dp[0] = true
    for (i in 1..s.length) {
        for (j in 0..i) {
            if (dp[j] && wordSet.contains(s.substring(j, i))) {
                dp[i] = true
            }
        }
    }

    return dp[s.length]
}

fun main() {
    val target = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaababaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    val dict = arrayListOf("aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba")

    println(wordBreak1(target, dict))
}