package _51_100.leetcode77

fun combine(n: Int, k: Int): List<List<Int>> {
    val result = ArrayList<List<Int>>()

    return when {
        n < k -> {
            result
        }
        n == k -> {
            val list = ArrayList<Int>()
            for (i in 1..n) {
                list.add(i)
            }
            result.add(list)
            result
        }
        else -> {
            dfs(result, ArrayList(), 1, n, k)
            result
        }
    }
}

fun dfs(result: MutableList<List<Int>>, currentList: MutableList<Int>, index: Int, n: Int, targetSize: Int) {
    if (currentList.size == targetSize) {
        result.add(ArrayList(currentList))
        return
    }

    val end = n - (targetSize - currentList.size) + 1
    for (i in index..(end)) {
        currentList.add(i)
        dfs(result, currentList, i + 1, n, targetSize)
        currentList.removeAt(currentList.size - 1)
    }
}

fun main() {
    println(combine(4, 2))
}