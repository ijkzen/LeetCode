package one_h.leetcode50

import kotlin.math.abs

fun myPow(x: Double, n: Int): Double {

    return if (n < 0) {
        1 / powerRecursion(x, x, 1, abs(n))
    } else {
        powerRecursion(x, x, 1, n)
    }
}

fun powerRecursion(origin: Double, current: Double, currentPower: Int, targetPower: Int): Double {
    return when {
        targetPower / currentPower >= 2 -> {
            powerRecursion(origin, current * current, currentPower * 2, targetPower)
        }
        targetPower == 0 || origin == 1.0-> {
            1.0
        }
        else -> {
            current * powerRecursion(origin, origin, 1, targetPower - currentPower)
        }
    }
}

fun main() {
    println(myPow(3.0, 3))
}


