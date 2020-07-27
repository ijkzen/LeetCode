package _51_100.leetcode56

import kotlin.math.max
import kotlin.math.min

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val result = ArrayList<IntArray>()

    intervals.sortBy { it[0] }
    intervals.forEach {
        if (result.isEmpty()) {
            result.add(it)
        } else {
            val last = result.last()
            if (last[1] < it[0]) {
                result.add(it)
            } else {
                result.removeAt(result.size-1)
                val left = min(last[0], it[0])
                val right = max(last[1], it[1])
                val tmp = intArrayOf(left, right)
                result.add(tmp)
            }
        }
    }

    return Array(result.size){
        result[it]
    }
}

fun main() {
    val intervals = Array(5) {
        when (it) {
            0 -> {
                intArrayOf(1, 3)
            }
            1 -> {
                intArrayOf(2, 6)
            }
            2 -> {
                intArrayOf(8, 10)
            }
            3 -> {
                intArrayOf(15, 18)
            }
            4 -> {
                intArrayOf(17, 19)
            }

            else -> {
                intArrayOf(1, 3)
            }
        }
    }

    println(merge(intervals))
}