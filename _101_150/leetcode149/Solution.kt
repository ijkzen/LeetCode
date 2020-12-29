package _101_150.leetcode149

fun maxPoints(points: Array<IntArray>): Int {
    if (points.size < 3) {
        return points.size
    }

    var result = 0
    val map = HashMap<String, Int>()
    for (i in 0 until points.size - 1) {
        var duplicate = 0

        for (j in i + 1 until points.size) {
            var deltaX = points[j][0] - points[i][0]
            var deltaY = points[j][1] - points[i][1]

            if (deltaX == 0 && deltaY == 0) {
                duplicate++
                continue
            }


        }
    }

    return 0
}

fun gcd(a: Int, b: Int): Int{
    var x = a
    var y = b

    while (b != 0) {
        val temp = x % y
        x = y
        y = temp
    }
    return x
}