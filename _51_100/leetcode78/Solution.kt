package _51_100.leetcode78

fun subsets(nums: IntArray): List<List<Int>> {
    val result = ArrayList<List<Int>>()

    result.add(ArrayList())
    return when {
        nums.isEmpty() -> {
            result
        }
        nums.size == 1 -> {
            val list = ArrayList<Int>()
            list.add(nums[0])
            result.add(list)
            result
        }
        else -> {
            for (i in 1..nums.size) {
                dfs(result, ArrayList(), nums, 0, i)
            }

            result
        }
    }
}

fun dfs(
    result: MutableList<List<Int>>,
    currentList: MutableList<Int>,
    nums: IntArray,
    index: Int,
    targetSize: Int
) {
    if (currentList.size == targetSize) {
        result.add(ArrayList(currentList))
        return
    }

    val end = nums.size - (targetSize - currentList.size)
    for (i in index..(end)) {
        currentList.add(nums[i])
        dfs(result, currentList, nums, i + 1, targetSize)
        currentList.removeAt(currentList.size - 1)
    }
}

fun main() {
    subsets(intArrayOf(1, 2, 3))
}