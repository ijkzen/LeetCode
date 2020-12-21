package _101_150.leetcode134

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {

    var spareSum = 0
    var spareMin = Int.MAX_VALUE

    val length = gas.size
    var index = 0

    for (i in 0 until length) {
        spareSum += gas[i] - cost[i]

        if (spareSum < spareMin) {
            spareMin = spareSum
            index = i
        }
    }

    return if (spareSum < 0) -1 else (index + 1) % length
}

fun main() {
    val gas = intArrayOf(1, 2, 3, 4, 5)
    val cost = intArrayOf(3, 4, 5, 1, 2)

    println(canCompleteCircuit(gas, cost))
}