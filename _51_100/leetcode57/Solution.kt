package _51_100.leetcode57

import kotlin.math.max
import kotlin.math.min

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val result = ArrayList<IntArray>()

    val tmp = intervals.toMutableList()
    if (tmp.isEmpty()) {
        tmp.add(newInterval)
    } else {
        for (i in tmp.indices) {
            if (newInterval[0] <= tmp[i][0]) {
                tmp.add(i, newInterval)
                break
            } else {
                if (i == tmp.size - 1) {
                    tmp.add(newInterval)
                }
            }
        }
    }
    tmp.forEach {
        if (result.isEmpty()) {
            result.add(it)
        } else {
            val last = result.last()
            if (last[1] < it[0]) {
                result.add(it)
            } else {
                result.removeAt(result.size - 1)
                val left = min(last[0], it[0])
                val right = max(last[1], it[1])
                val element = intArrayOf(left, right)
                result.add(element)
            }
        }
    }

    return Array(result.size) {
        result[it]
    }
}

fun main() {
    val intervals = Array(1) {
        when (it) {
            0 -> {
                intArrayOf(1, 5)
            }
            1 -> {
                intArrayOf(3, 5)
            }
            2 -> {
                intArrayOf(6, 7)
            }
            3 -> {
                intArrayOf(8, 10)
            }
            4 -> {
                intArrayOf(12, 16)
            }

            else -> {
                intArrayOf(1, 3)
            }
        }
    }

    println(insert(intervals, intArrayOf(2, 7)))
}
