package _101_150.leetcode150

import java.util.*

fun evalRPN(tokens: Array<String>): Int {
    if (tokens.isEmpty()) {
        return 0
    }

    val stack = Stack<Int>()
    for (element in tokens) {
        when (element) {
            "+" ->{
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a + b)
            }
            "-" ->{
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a - b)
            }
            "*" ->{
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a * b)
            }
            "/" ->{
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a / b)
            }
            else ->{
                stack.push(element.toInt())
            }
        }
    }

    return stack.pop()
}

fun main() {
    println(evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
}