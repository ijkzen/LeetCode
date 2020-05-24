package one_h.leetcode42

/**
 * @author ijkzen
 * @since 2020/5/23
 */
data class Pair(val index: Int, val value: Int)

fun trap(height: IntArray): Int {
    var hasStart = false
    var startHeight = 0
    val leftHeights = ArrayList<ArrayList<Pair>>()
    val currentHeights = ArrayList<Pair>()
    var index = 0
    while (index < height.size) {
        if (hasStart) {
            if (height[index] < startHeight) {
                currentHeights.add(Pair(index, height[index]))
                index++
            } else {
                val segment = ArrayList<Pair>()
                segment.addAll(currentHeights)
                leftHeights.add(segment)
                currentHeights.clear()
                hasStart = false
            }
        } else {
            if (index < height.size - 1 && height[index] > height[index + 1]) {
                hasStart = true
                startHeight = height[index]
                currentHeights.add(Pair(index, height[index]))
            }
            index++
        }
    }

    index = height.size - 1
    hasStart = false
    currentHeights.clear()
    val rightHeights = ArrayList<ArrayList<Pair>>()
    while (index >= 0) {
        if (isExist(index, leftHeights)) {
            index--
            hasStart = false
            currentHeights.clear()
            continue
        }

        if (hasStart) {
            if (height[index] < startHeight) {
                currentHeights.add(Pair(index, height[index]))
                index--
            } else {
                val segment = ArrayList<Pair>()
                segment.addAll(currentHeights)
                rightHeights.add(segment)
                currentHeights.clear()
                hasStart = false
            }
        } else {
            if (index > 0 && height[index] > height[index - 1]) {
                hasStart = true
                startHeight = height[index]
                currentHeights.add(Pair(index, height[index]))
            }
            index--
        }
    }

    var count = 0
    for (i in leftHeights.indices) {
        for (j in leftHeights[i].indices) {
            count += (leftHeights[i][0].value - leftHeights[i][j].value)
        }
    }

    for (i in rightHeights.indices) {
        for (j in rightHeights[i].indices) {
            count += (rightHeights[i][0].value - rightHeights[i][j].value)
        }
    }

    return count
}

fun isExist(index: Int, leftHeights: ArrayList<ArrayList<Pair>>): Boolean {
    for (i in leftHeights.indices) {
        for (j in 1 until leftHeights[i].size) {
            if (index == leftHeights[i][j].index) {
                return true
            }
        }
    }

    return false
}

fun main() {
    val height = intArrayOf(4,2,3)
    println(trap(height))
}