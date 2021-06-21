package _1_50.leetcode9

/**
 * 执行耗时:240 ms,击败了91.06% 的Kotlin用户
 * 内存消耗:34.4 MB,击败了49.16% 的Kotlin用户
 */
fun isPalindrome(x: Int): Boolean {
    when {
        x < 0 -> {
            return false
        }
        x == 0 -> {
            return true
        }
        else -> {

            var tmp = x
            var target  = 0
            while (tmp != 0) {
                val pop = tmp % 10
                tmp /= 10
                target = target * 10 + pop
            }

            return x == target
        }
    }
}

fun main() {
    println(isPalindrome(222))
}