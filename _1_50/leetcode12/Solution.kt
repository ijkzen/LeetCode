package _1_50.leetcode12

import java.lang.StringBuilder

/**
 * 执行耗时:220 ms,击败了84.13% 的Kotlin用户
 * 内存消耗:35 MB,击败了58.73% 的Kotlin用户
 */
fun intToRoman(num: Int): String {
    val tmp = "$num"
    val builder = StringBuilder()
    return when (tmp.length) {
        1 -> {
            number1(tmp)
        }
        2 -> {
            builder.append(number2(tmp.substring(0, 1)))
            builder.append(number1(tmp.substring(1, 2)))
            builder.toString()
        }
        3 -> {
            builder.append(number3(tmp.substring(0, 1)))
            builder.append(number2(tmp.substring(1, 2)))
            builder.append(number1(tmp.substring(2, 3)))
            builder.toString()
        }
        4 -> {
            builder.append(number4(tmp.substring(0, 1)))
            builder.append(number3(tmp.substring(1, 2)))
            builder.append(number2(tmp.substring(2, 3)))
            builder.append(number1(tmp.substring(3, 4)))
            builder.toString()
        }
        else -> {
            ""
        }
    }
}

fun number4(str: String): String {

    return when (str) {
        "0" -> ""
        "1" -> "M"
        "2" -> "MM"
        "3" -> "MMM"
        else -> ""
    }

}

fun number3(str: String): String {
    return when (str) {
        "0" -> ""
        "1" -> "C"
        "2" -> "CC"
        "3" -> "CCC"
        "4" -> "CD"
        "5" -> "D"
        "6" -> "DC"
        "7" -> "DCC"
        "8" -> "DCCC"
        "9" -> "CM"
        else -> ""
    }
}

fun number2(str: String): String {
    return when (str) {
        "0" -> ""
        "1" -> "X"
        "2" -> "XX"
        "3" -> "XXX"
        "4" -> "XL"
        "5" -> "L"
        "6" -> "LX"
        "7" -> "LXX"
        "8" -> "LXXX"
        "9" -> "XC"
        else -> ""
    }
}

fun number1(str: String): String {
    return when (str) {
        "0" -> ""
        "1" -> "I"
        "2" -> "II"
        "3" -> "III"
        "4" -> "IV"
        "5" -> "V"
        "6" -> "VI"
        "7" -> "VII"
        "8" -> "VIII"
        "9" -> "IX"
        else -> ""
    }
}

fun main() {
    println(intToRoman(23))
}