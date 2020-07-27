package _50.leetcode32

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.absoluteValue

fun longestValidParentheses(s: String): Int {
    val leftStack = Stack<Int>()
    val rightStack = Stack<Int>()
    for (i in s.indices) {
        if (s[i] == '(') {
            leftStack.push(i)
        } else if (s[i] == ')') {
            if (leftStack.isEmpty()) {
                rightStack.push(i)
            } else {
                leftStack.pop()
            }
        }
    }

    val errorPoint = ArrayList<Int>()
    leftStack.forEach {
        errorPoint.add( it)
    }
    rightStack.forEach {
        errorPoint.add( it)
    }

    when (errorPoint.size) {
        0 -> {
            return s.length
        }
        1 -> {
            val tmp = s.length - 1 - errorPoint[0]
            return if (tmp > errorPoint[0]) {
                tmp
            } else {
                errorPoint[0]
            }
        }
        else -> {
            var max = 0

            if (errorPoint.size == s.length) {
                return 0
            }
            errorPoint.add( -1)
            errorPoint.add( s.length)
            errorPoint.sort()
            for (i in 0..(errorPoint.size - 2)) {
                val tmp = (errorPoint[i + 1] - errorPoint[i]).absoluteValue - 1

                if (tmp > max) {
                    max = tmp
                }
            }
            return max
        }
    }
}

fun main() {
    println(longestValidParentheses("(((((((()"))
}