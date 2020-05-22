package one_h.leetcode40

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    candidates.sort()
    val originList = candidates.toMutableList()
    originList.removeIf { it > target }
    val resultList = ArrayList<ArrayList<Int>>()
    dfs(target, originList, 0, ArrayList<Int>(), resultList)

    return resultList
}

fun dfs(
    current: Int,
    origin: MutableList<Int>,
    start: Int,
    subList: ArrayList<Int>,
    resultList: ArrayList<ArrayList<Int>>
) {
    if (current == 0) {
        resultList.add(ArrayList(subList))
        return
    }

    for (i in start until origin.size) {
        if (i > start && origin[i] == origin[i - 1]) {
            continue
        }

        val newCurrent = current - origin[i]
        if (newCurrent >= 0) {
            subList.add(origin[i])
            dfs(newCurrent, origin, i + 1, subList, resultList)
            subList.removeAt(subList.size - 1)
        } else {
            break
        }
    }
}

fun main() {
    val tmp = intArrayOf(2, 3, 5)
    val result = combinationSum2(tmp, 8)
    println(result.toString())
}