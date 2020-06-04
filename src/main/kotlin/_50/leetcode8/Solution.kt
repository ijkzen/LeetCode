package _50.leetcode8

import java.lang.Exception
import java.util.regex.Pattern

fun myAtoi(str: String): Int {
    val origin = str.trim()
    if (origin.isEmpty() || origin[0] != '+' && origin[0] != '-' && origin[0] != '0' &&
        origin[0] != '1' && origin[0] != '2' && origin[0] != '3' &&
        origin[0] != '4' && origin[0] != '5' && origin[0] != '6' &&
        origin[0] != '7' && origin[0] != '8' && origin[0] != '9'
    ) {
        return 0
    }

    val regex = "^[+-]?[0-9]+"
    val matcher = Pattern.compile(regex).matcher(origin)
    if (matcher.find()) {
        val tmp = matcher.group(0)
        return try {
            tmp.toInt()
        } catch (e: Exception) {
            return if (tmp[0] == '-') {
                Int.MIN_VALUE
            } else {
                Int.MAX_VALUE
            }
        }
    }

    return 0
}

fun main() {
    println(myAtoi("42"))
}