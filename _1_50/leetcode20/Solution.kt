package _1_50.leetcode20

import java.util.*

/**
 * 执行耗时:140 ms,击败了93.22% 的Kotlin用户
 * 内存消耗:33.1 MB,击败了48.30% 的Kotlin用户
 */
fun isValid(s: String): Boolean {

    if (s.length % 2 == 1) {
        return false
    }

    val stack = Stack<Char>()
    val map = hashMapOf('[' to ']', '(' to ')', '{' to '}')
    var result = true

    s.forEach {
        if (it == '[' || it == '{' || it == '(') {
            stack.add(it)
        } else {
            try {
                if (map[stack.peek()] == it) {
                    stack.pop()
                } else {
                    return false
                }
            } catch (e: EmptyStackException) {
                result = false
            }
        }
    }

    return stack.isEmpty() && result
}

fun main() {
    println(isValid("([}}])"))
}