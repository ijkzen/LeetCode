package _51_100.leetcode90

fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    nums.sort()
    val result = ArrayList<ArrayList<Int>>()
    result.add(ArrayList())
    dfs(ArrayList(), result, 0, nums)

    return result
}

fun dfs(currentList: MutableList<Int>, result: ArrayList<ArrayList<Int>>, startIndex: Int, nums: IntArray) {
    if (startIndex == nums.size) {
        return
    }

    for (i in startIndex until nums.size) {
        if (i > startIndex && nums[i] == nums[i - 1]) {
            continue
        }

        currentList.add(nums[i])
        result.add(ArrayList(currentList))
        dfs(currentList, result, i + 1, nums)
        currentList.removeAt(currentList.size - 1)
    }
}


fun main() {
    val nums = intArrayOf(1, 2, 3)
    println(subsetsWithDup(nums))
}