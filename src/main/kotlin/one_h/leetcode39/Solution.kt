package one_h.leetcode39

/**
 * @author ijkzen
 * @since 2020/5/21
 */
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    candidates.sort()
    val originList = candidates.toMutableList()
    originList.removeIf { it > target }
    val resultList = ArrayList<ArrayList<Int>>()
    cal(target, originList, 0, ArrayList<Int>(), resultList)

    return resultList
}

fun cal(current: Int, origin: MutableList<Int>, start: Int, subList: ArrayList<Int>, resultList: ArrayList<ArrayList<Int>>) {
    if (current == 0) {
        resultList.add(ArrayList(subList))
        return
    }

    for (i in start until origin.size) {
        println("current: $current, origin[i]: ${origin[i]}")
        val newCurrent = current - origin[i]
        if (newCurrent >= 0) {
            subList.add(origin[i])
            cal(newCurrent, origin, i, subList, resultList)
            subList.removeAt(subList.size - 1)
        } else {
            break
        }
    }
}

fun main() {
    val tmp = intArrayOf(2,3,5)
    val result = combinationSum(tmp , 8)
    println(result.toString())
}