package leetcode1


fun twoSum(nums: IntArray, target: Int): IntArray? {
    val map = mutableMapOf<Int, Int>()
    for ((index, value) in nums.withIndex()) {
        val delta = target - value
        if (map.containsKey(delta)) {
            return intArrayOf(map[delta]!!, index)
        }
        map[value] = index
    }
    return null
}


fun main() {
    val nums = intArrayOf(3, 3)
    println(twoSum(nums, 6)?.get(0))
}