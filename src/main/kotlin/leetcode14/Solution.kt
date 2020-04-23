package leetcode14

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun threeSum(nums: IntArray): List<List<Int>> {
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        val number = map[nums[i]]
        if (number != null) {
            map[nums[i]] = (number + 1)
        } else {
            map[nums[i]] = 1
        }
    }

    val result = ArrayList<List<Int>>()

    for (key in map.keys) {
        for (z in map.keys) {
            if (map[-key - z] != null) {
                val equal = whichEqual(key, z, -key - z)
                val min = min(key, z, -key - z)
                val middle = middle(key, z, -key - z)
                val max = max(key, z, -key - z)
                if (equal == null) {
                    if (!isExist(min, middle, max, result)) {
                        val list = LinkedList<Int>()
                        list.add(min)
                        list.add(middle)
                        list.add(max)
                        result.add(list)
                    }
                } else {
                    val equalNumber = equalNumber(key, z, -key - z)
                    if (equalNumber <= map[equal]!! && !isExist(min, middle, max, result)) {
                        val list = LinkedList<Int>()
                        list.add(min)
                        list.add(middle)
                        list.add(max)
                        result.add(list)
                    }
                }
            }
        }
    }

    return result
}

fun whichEqual(a: Int, b: Int, c: Int): Int? {
    if (a == b) {
        return a
    }

    if (a == c) {
        return a
    }

    if (b == c) {
        return b
    }

    return null
}

fun equalNumber(a: Int, b: Int, c: Int): Int {
    var count = 1
    if (a == b) {
        count++
    }

    if (a == c) {
        count++
    }

    if (b == c) {
        count++
    }

    return count
}

fun max(a: Int, b: Int, c: Int): Int {
    return if (a > b) {
        if (a > c) {
            a
        } else {
            c
        }
    } else {
        if (b > c) {
            b
        } else {
            c
        }
    }
}

fun min(a: Int, b: Int, c: Int): Int {
    return if (a < b) {
        if (a < c) {
            a
        } else {
            c
        }
    } else {
        if (b < c) {
            b
        } else {
            c
        }
    }
}

fun middle(a: Int, b: Int, c: Int): Int {
    return when {
        b in a..c -> {
            b
        }
        a in b..c -> {
            a
        }
        else -> {
            c
        }
    }
}

fun isExist(a: Int, b: Int, c: Int, list: List<List<Int>>): Boolean {
    for (tmp in list) {
        if (tmp[0] == a && tmp[1] == b && tmp[2] == c) {
            return true
        }
    }
    return false
}

fun main() {
    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
}