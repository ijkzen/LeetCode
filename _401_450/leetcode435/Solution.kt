package _401_450.leetcode435

fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
    if (intervals.isEmpty()) {
        return 0
    }

    intervals.sortBy { it[1] }

    var count = 1

    var end = intervals[0][1]
    for (element in intervals) {
        if (element[0] < end) {
            continue
        }

        end = element[1]
        count++
    }

    return intervals.size - count
}