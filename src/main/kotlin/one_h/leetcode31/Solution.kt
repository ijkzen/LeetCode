package one_h.leetcode31

import one_h.leetcode1.string

fun nextPermutation(nums: IntArray): Unit {
    var pre = nums.size - 2
    while (nums.size > 1) {
        if (pre == -1) {
            nums.sort()
            break
        }

        if (nums[pre] >= nums[pre + 1]) {
            pre -= 1
        } else {
            var next = pre + 1
            while (next < nums.size && nums[pre] < nums[next]) {
                next += 1
            }
            val tmp = nums[pre]
            nums[pre] = nums[next - 1]
            nums[next - 1] = tmp
            nums.sort(pre + 1)
            break
        }
    }
}

fun main() {
    val nums = IntArray(3)
    nums[0] = 1
    nums[1] = 5
    nums[2] = 1
//    nums[3] = 4
    nextPermutation(nums)
    println(nums.string())
}