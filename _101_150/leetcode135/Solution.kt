package _101_150.leetcode135

fun candy(ratings: IntArray): Int {
    if (ratings.isEmpty()) {
        return 0
    }


    var i = 1
    val length = ratings.size
    val candy = IntArray(length) { 1 }

    var sum = 0
    while (i < length) {
        val left = ratings[i - 1]
        val right = ratings[i]

        when {
            left < right -> {
                candy[i] = candy[i - 1] + 1
                i++
            }
            left == right -> {
                candy[i] = 1
                i++
            }
            else -> {
                var count = 0
                val topIndex = i - 1
                val topCandy = candy[i - 1]
                while (i < length && ratings[i - 1] > ratings[i]) {
                    count++
                    i++
                }

                for (j in 1..count) {
                    candy[i - j] = j
                }

                if (topCandy <= count) {
                    candy[topIndex] = count + 1
                }
            }
        }
    }

    for (element in candy) {
        sum += element
    }

    return sum
}

fun main() {
    val ratings = intArrayOf(1,2,87,87,87,2,1)

    println(candy(ratings))
}