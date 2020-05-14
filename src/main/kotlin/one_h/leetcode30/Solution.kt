package one_h.leetcode30

fun findSubstring(s: String, words: Array<String>): List<Int> {
    if (words.isEmpty() || s.isEmpty()) {
        return listOf()
    }
    val wordsMap = HashMap<String, Int>()
    words.forEach {
        if (wordsMap[it] == null) {
            wordsMap[it] = 1
        } else {
            wordsMap[it] = wordsMap[it]!! + 1
        }
    }


    val result = ArrayList<Int>()

    val unit = words[0].length
    val wordsSize = unit * words.size
    for (i in 0 until unit) {
        var header = i
        while (header <= s.length - wordsSize) {
            val internalString = s.subSequence(header, header + wordsSize)
            var internalHeader = 0
            val internalMap = HashMap<String, Int>()
            while (internalHeader <= (words.size - 1) * unit) {
                val tmp = internalString.substring(internalHeader, internalHeader + unit)
                if (wordsMap[tmp] == null) {
                    header += internalHeader + unit
                    break
                } else {
                    if (internalMap[tmp] == null) {
                        if (internalHeader == (words.size - 1) * unit) {
                            result.add(header)
                            header += unit
                            break
                        }
                        internalMap[tmp] = 1
                        internalHeader += unit
                    } else {
                        if (internalMap[tmp]!! + 1 > wordsMap[tmp]!!) {
                            header += unit
                            break
                        } else {
                            internalMap[tmp] = internalMap[tmp]!! + 1
                            if (internalHeader == (words.size - 1) * unit) {
                                result.add(header)
                                header += unit
                                break
                            }
                            internalHeader += unit
                        }
                    }
                }
            }

        }
    }


    return result
}

fun main() {
    println(findSubstring("barfoothefoobarman", arrayOf("foo","bar")))
}