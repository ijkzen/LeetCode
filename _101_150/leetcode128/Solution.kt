package _101_150.leetcode128

fun longestConsecutive(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }

    // first to last map
    val firstLast = HashMap<Int, Int>()
    val lastFirst = HashMap<Int, Int>()

    val set = mutableSetOf<Int>()
    for (element in nums) {
        set.add(element)
    }

    val iterator = set.iterator()
    while (iterator.hasNext()) {
        val element = iterator.next()

        when {
            firstLast.containsKey(element + 1) -> {
                // modify first to last
                val last = firstLast[element + 1]!!
                firstLast.remove(element + 1)
                firstLast[element] = last

                // modify last to first
                lastFirst[last] = element
            }
            lastFirst.containsKey(element - 1) -> {
                // modify first to last
                val first = lastFirst[element - 1]!!
                firstLast[first] = element

                // modify last to first
                lastFirst.remove(element - 1)
                lastFirst[element] = first
            }
            else -> {
                firstLast[element] = element
                lastFirst[element] = element
            }
        }
    }

    val finalFirstLast = HashMap<Int, Int>()
    val finalLastFirst = HashMap<Int, Int>()

    val finalIterator = firstLast.iterator()
    while (finalIterator.hasNext()) {
        val entry = finalIterator.next()

        when {
            finalFirstLast.containsKey(entry.value + 1) -> {
                // modify first to last
                val last = finalFirstLast[entry.value + 1]!!
                finalFirstLast.remove(entry.value + 1)
                finalFirstLast[entry.key] = last

                // modify last to first
                finalLastFirst[last] = entry.key
            }
            finalLastFirst.containsKey(entry.key - 1) -> {
                // modify first to last
                val first = finalLastFirst[entry.key - 1]!!
                finalFirstLast[first] = entry.value

                // modify last to first
                finalLastFirst.remove(entry.key - 1)
                finalLastFirst[entry.value] = first
            }
            else -> {
                finalFirstLast[entry.key] = entry.value
                finalLastFirst[entry.value] = entry.key
            }
        }
    }

    var maxLength = 0

    for (entry in finalLastFirst.entries) {
        if (entry.key - entry.value > maxLength) {
            maxLength = entry.key - entry.value
        }
    }

    return maxLength + 1
}

fun main() {
    println(longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
}