package one_h.leetcode27

fun removeElement(nums: IntArray, `val`: Int): Int {
    var count = 0
    nums.iterator().forEach {
        if (it != `val`) {
            nums[count++]=it
        }
    }

    return count
}