package _50.leetcode50

fun myPow1(x: Double, n: Int): Double {
    return if (n < 0) {
        1 / fastPower(x, n)
    } else {
        fastPower(x, n)
    }
}

fun fastPower(x: Double, n: Int): Double {
    return when {
        x == 1.0 || n == 0 -> {
            1.0
        }
        n == 1 -> {
            x
        }

        else -> {
            val half = fastPower(x, n / 2)
            if (n % 2 == 0) {
                half * half
            } else {
                half * half * x
            }
        }
    }
}

fun main() {
    println(myPow1(3.0, 10))
}