package _1_50.leetcode8

/**
 * 执行耗时:208 ms,击败了58.44% 的Kotlin用户
 *  内存消耗:35.2 MB,击败了12.99% 的Kotlin用户
 */
fun myAtoi1(str: String): Int {
    if (str.isEmpty()) {
        return 0
    }

    var sign = -1
    var result = 0

    for (char in str) {
        if (sign == -1 && isPlus(char)) {
            sign = 0
        } else if (sign == -1 && isMinus(char)) {
            sign = 1
        } else if (isDigital(char)) {
            if (sign == -1) {
                sign = 0
            }

            val pair = isOutOfBounds(result, char - '0', sign)
            if (pair.first) {
                return pair.second
            } else {
                result = pair.second
            }
        } else if (char == ' '){
            if (sign != -1) {
                break
            } else {
                continue
            }
        } else {
            break
        }
    }

    return result
}

fun isPlus(char: Char): Boolean{
    return char == '+'
}

fun isMinus(char: Char): Boolean{
    return char == '-'
}

fun isDigital(char: Char): Boolean{
    return char - '0' in 0..9
}

fun isOutOfBounds(result: Int, current: Int, sign: Int): Pair<Boolean, Int>{
    return if (sign == 0) {
        if (result > Int.MAX_VALUE / 10) {
            Pair(true, Int.MAX_VALUE)
        } else if (result == Int.MAX_VALUE / 10) {
            if (current <= 7) {
                Pair(false, result * 10 + current)
            } else {
                Pair(true, Int.MAX_VALUE)
            }
        } else {
            Pair(false, result * 10 + current)
        }
    } else if (sign == 1){
        if (result < Int.MIN_VALUE / 10) {
            Pair(true, Int.MIN_VALUE)
        } else if (result == Int.MIN_VALUE / 10) {
            if (current <= 8) {
                Pair(false, result * 10 - current)
            } else {
                Pair(true, Int.MIN_VALUE)
            }
        } else {
            Pair(false, result * 10 - current)
        }
    } else {
        return Pair(true, 0)
    }
}

fun main() {
    println(myAtoi1("-91283472332"))
}