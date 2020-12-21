package _101_150.leetcode136

fun singleNumber(nums: IntArray): Int {

    val set = HashSet<Int>()

    for (num in nums) {
        if (set.contains(num)) {
            set.remove(num)
        } else {
            set.add(num)
        }
    }

    return set.first()
}

fun main() {
    println(singleNumber(intArrayOf(2,2,1)))
}