package leetcode9

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