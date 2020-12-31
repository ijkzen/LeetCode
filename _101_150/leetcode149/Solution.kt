package _101_150.leetcode149

fun maxPoints(points: Array<IntArray>): Int {
    if (points.size < 3) {
        return points.size
    }

    var result = 0
    for (i in 0 until points.size - 1) {
        val map = HashMap<String, Int>()
        var duplicate = 0
        var max = 0
        for (j in i + 1 until points.size) {
            val deltaX = points[j][0] - points[i][0]
            val deltaY = points[j][1] - points[i][1]

            if (deltaX == 0 && deltaY == 0) {
                duplicate++
                continue
            }

            val gcd = gcd(deltaX, deltaY)
            val minX = deltaX / gcd
            val minY = deltaY / gcd
            val key = "${minX}_$minY"
            map[key] = map.getOrDefault(key, 0) + 1
            max = Math.max(max, map.getOrDefault(key, 0))
        }

        result = Math.max(result, max + duplicate + 1)
    }

    return result
}

fun gcd(a: Int, b: Int): Int {
    var x = a
    var y = b

    while (y != 0) {
        val temp = x % y
        x = y
        y = temp
    }
    return x
}

fun main() {
    val points = Array<IntArray>(3) {
        when (it) {
            0 -> intArrayOf(1, 1)
            1 -> intArrayOf(2, 2)
            2 -> intArrayOf(3, 3)
            else -> intArrayOf()
        }
    }

    println(maxPoints(points))
}