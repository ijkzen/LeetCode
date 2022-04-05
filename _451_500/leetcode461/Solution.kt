package _451_500.leetcode461

fun hammingDistance(x: Int, y: Int): Int {
    val a = Integer.toBinaryString(x)
    val b = Integer.toBinaryString(y)

    val binaryX: String
    val binaryY: String
    if (a.length >= b.length) {
        binaryX = b
        binaryY = a
    } else {
        binaryX = a
        binaryY = b
    }

    var i = binaryX.length - 1
    var j = binaryY.length - 1
    var count = 0
    while (i >= 0 || j >= 0) {
        if (i < 0) {
            if (binaryY[j] == '1') {
                count++
            }
        } else {
            if (binaryX[i] != binaryY[j]) {
                count++
            }
        }
        i--
        j--
    }

    return count
}

fun main() {
    println(hammingDistance(1, 4))
}