package _50.leetcode20

import java.util.*

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
                }
            } catch (e: EmptyStackException) {
                result = false
            }
        }
    }

    return stack.isEmpty() && result
}

fun main() {
    println(isValid("){"))
}