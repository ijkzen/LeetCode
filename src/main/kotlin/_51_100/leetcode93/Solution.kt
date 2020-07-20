package _51_100.leetcode93

fun restoreIpAddresses(s: String): List<String> {
    val result = ArrayList<String>()
    restoreIp(ArrayList(), 0, s, result)
    return result
}

fun restoreIp(
    subList: MutableList<String>,
    startIndex: Int,
    target: String,
    result: MutableList<String>
) {
    if (startIndex >= target.length) {
        return
    }

    var start = startIndex
    val builder = StringBuilder()

    do {
        builder.append(target[start])
        start++
        val tmpSubList = ArrayList(subList)
        if (tmpSubList.size < 4 && isValid(builder.toString())) {
            tmpSubList.add(builder.toString())
            if (tmpSubList.size == 4 && start == target.length) {
                val tmpBuilder = StringBuilder()
                tmpSubList.forEach {
                    tmpBuilder.append("$it.")
                }
                tmpBuilder.deleteCharAt(tmpBuilder.length - 1)
                result.add(tmpBuilder.toString())
            } else {
                restoreIp(tmpSubList, start, target, result)
            }
        } else {
            break
        }
    } while (start < target.length)
}

fun isValid(sub: String): Boolean {
    if (sub.isEmpty()) {
        return false
    }

    if (sub.length == 1) {
        return true
    } else if (sub.length == 2 || sub.length == 3) {
        return sub[0] != '0' && sub.toInt() in 0..255
    }
    return false
}

fun main() {
    println(restoreIpAddresses("010010"))
}