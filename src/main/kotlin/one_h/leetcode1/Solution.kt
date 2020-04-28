package one_h.leetcode1

import java.lang.StringBuilder


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

fun IntArray.string(): String? {
    val iterator = iterator()
    val builder = StringBuilder("[")
    while (iterator.hasNext()) {
        builder.append(iterator.next())
        builder.append(",")
    }
    builder.deleteCharAt(builder.length - 1)
    builder.append("]")
    return builder.toString()
}


fun main() {
    val nums = intArrayOf(3, 3)
    println(twoSum(nums, 6)?.string())
}