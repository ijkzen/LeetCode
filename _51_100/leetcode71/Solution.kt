package _51_100.leetcode71

import java.util.Stack

fun simplifyPath(path: String): String {

    val array = path.split("/")
    val stack = Stack<String>()
    stack.add("/")
    for (i in array.indices) {
        when (array[i]) {
            "." -> {
            }
            ".." -> {
                if (stack.size > 1) {
                    stack.pop()
                }
            }
            "" -> {
            }
            else -> {
                stack.add(array[i])
            }
        }
    }

    val builder = StringBuilder("/")
    for (i in 1 until stack.size) {
        builder.append(stack[i])
        if (i < stack.size - 1) {
            builder.append("/")
        }
    }

    return builder.toString()
}

fun main() {
    println(simplifyPath("/a//b////c/d//././/.."))
}