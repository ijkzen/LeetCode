package _51_100.leetcode89

fun grayCode(n: Int): List<Int> {
    val list = ArrayList<Int>()
    val num = 1.shl(n)

    for (i in 0 until num) {
        list.add((i.shr(1).xor(i)))
    }

    return list
}

fun main() {
    println(grayCode(2))
}