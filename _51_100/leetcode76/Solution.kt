package _51_100.leetcode76

fun minWindow(s: String, t: String): String {
    val statusMap = initMap(t)
    val initStatusMap: Map<Char, Int> = HashMap(statusMap)
    val trueString = removeUselessChar(s, statusMap)

    var currentSize = Int.MAX_VALUE
    var result = ""

    var start = 0
    var end = -1
    while (end < trueString.length - 1) {
        end++
        val rightChar = trueString[end]
        statusMap[rightChar] = statusMap.getOrDefault(rightChar, 0) - 1

        while (isResult(statusMap, initStatusMap) && start <= end) {

            if (end - start < currentSize) {
                currentSize = end - start
                result = trueString.substring(start, end + 1)
            }
            val leftChar = trueString[start]
            statusMap[leftChar] = statusMap.getOrDefault(leftChar, 0) + 1
            start++
        }
    }


    return result
}

fun removeUselessChar(s: String, targetMap: Map<Char, Int>): String {
    var start = 0
    for (i in s.indices) {
        if (targetMap.getOrDefault(s[i], 0) != 0) {
            start = i
            break
        }
    }

    var end = 0
    for (i in s.length - 1 downTo 0) {
        if (targetMap.getOrDefault(s[i], 0) != 0) {
            end = i
            break
        }
    }

    return s.substring(start, end + 1)
}

fun initMap(t: String): MutableMap<Char, Int> {
    val map = hashMapOf<Char, Int>()
    t.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }

    return map
}

fun isResult(map: Map<Char, Int>, initStatusMap: Map<Char, Int>): Boolean {
    for (key in initStatusMap.keys) {
        val value = map.getOrDefault(key, 0)
        if (value > 0) {
            return false
        }
    }
    return true
}

fun main() {
    println(minWindow("A", "A"))
}