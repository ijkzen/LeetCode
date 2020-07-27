package _50.leetcode46

import java.util.Deque
import java.util.ArrayDeque
import kotlin.collections.ArrayList

fun permute(nums: IntArray): List<List<Int>> {

    val result: MutableList<MutableList<Int>> = ArrayList()

    dfs(result, nums.size, ArrayDeque(), nums.toMutableList(), 0)

    return result
}

fun dfs(
    result: MutableList<MutableList<Int>>,
    targetSize: Int,
    currentStack: Deque<Int>,
    leftArray: MutableList<Int>,
    leftStart: Int
) {
    if (currentStack.size == targetSize) {
        result.add(currentStack.toMutableList())
        return
    }

    if (leftArray.isNotEmpty()) {
        val currentInt = leftArray[0]
        currentStack.push(currentInt)
        leftArray.remove(currentInt)
        dfs(result, targetSize, currentStack, leftArray, 0)
        currentStack.pop()
        leftArray.add(currentInt)
        if (leftStart + 1 >= leftArray.size) {
            return
        } else {
            dfs(result, targetSize, currentStack, leftArray, leftStart + 1)
        }
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3)
    println(permute(nums))
}