package _101_150.leetcode119

fun getRow(rowIndex: Int): List<Int> {
    return generate(rowIndex + 1).last()
}

fun generate(numRows: Int): List<List<Int>> {

    val result = ArrayList<ArrayList<Int>>()
    if (0 == numRows) {
        return result
    }

    val first = arrayListOf<Int>(1)
    result.add(first)
    for (i in 2..numRows) {
        val list = ArrayList<Int>()
        val lastList = result[result.size - 1]
        for (j in 0 until i) {
            list.add((if (j - 1 < 0) 0 else lastList[j - 1]) + (if (j == lastList.size) 0 else lastList[j]))
        }
        result.add(list)
    }
    return result
}

fun main() {
    println(getRow(0))
}