package _51_100.leetcode67

var carry = '0'

fun addBinary(a: String, b: String): String {
    val length = a.length.coerceAtLeast(b.length)
    val builder = StringBuilder()

    for (i in 0 until length) {
        val charA = getChar(a, i)
        val charB = getChar(b, i)
        builder.append(binaryPlus(charA, charB, carry))
    }

    if (carry == '1') {
        builder.append(carry)
    }

    return builder.reverse().toString()
}

fun getChar(s: String, index: Int): Char {
    return if (s.length - 1 >= index) {
        s[s.length - 1 - index]
    } else {
        '0'
    }
}

fun binaryPlus(a: Char, b: Char, c: Char): Char {
    var count = 0
    if (a == '1') {
        count++
    }

    if (b == '1') {
        count++
    }

    if (c == '1') {
        count++
    }

    carry = if (count >= 2) {
        '1'
    } else {
        '0'
    }

    return "${count % 2}"[0]
}

fun main() {
    println(addBinary("1", "111"))
}

