package one_h.leetcode47

import java.util.Deque
import java.util.ArrayDeque
import kotlin.collections.ArrayList

fun permuteUnique(nums: IntArray): List<List<Int>> {

    val result: MutableList<MutableList<Int>> = ArrayList()

    dfs(result, nums.size, ArrayDeque(), nums.toMutableList(), 0, HashMap())

    return result
}

fun dfs(
    result: MutableList<MutableList<Int>>,
    targetSize: Int,
    currentStack: Deque<Int>,
    leftArray: MutableList<Int>,
    leftStart: Int,
    mark: MutableMap<Int, Boolean>
) {
    if (currentStack.size == targetSize) {
        result.add(currentStack.toMutableList())
        return
    }

    if (leftArray.isNotEmpty() && leftStart < leftArray.size) {
        val currentInt = leftArray[leftStart]

        if (mark[currentInt] == true) {
            dfs(result, targetSize, currentStack, leftArray, leftStart + 1, mark)
            return
        }

        mark[currentInt] = true
        currentStack.addLast(currentInt)
        val originLeftArray = ArrayList(leftArray)
        leftArray.removeAt(leftStart)
        dfs(result, targetSize, currentStack, leftArray, 0, HashMap())
        currentStack.removeLast()
        if (originLeftArray.size >= 2) {
            dfs(result, targetSize, currentStack, originLeftArray, leftStart + 1, mark)
        }
    }
}

fun main() {
    val nums = intArrayOf(1, 1,2, 3)
    println(permuteUnique(nums))
}