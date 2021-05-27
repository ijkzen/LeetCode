package _1_50.leetcode1

import java.lang.StringBuilder

/**
 * 2021/05/19 10:56
 * 运行耗时220ms，超越75%
 * 排行第一的算法用时184ms，具体算法相似，复制其算法运行，耗时为224ms；
 * 可能是服务端处理器的更换、负载问题或者测试用例更新导致的
 * 时间复杂度 O(n) = n
 */

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