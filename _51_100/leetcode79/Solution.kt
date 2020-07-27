package _51_100.leetcode79

data class Point(val x: Int, val y: Int)

fun exist(board: Array<CharArray>, word: String): Boolean {
    val width = board[0].size
    val height = board.size

    val firstList = getFirstPointList(board, word[0])

    for (point in firstList) {
        if (!dfs(board, point, word, 0, HashSet(), 0, width, height)) {
            continue
        } else {
            return true
        }

    }

    return false
}

fun dfs(
    board: Array<CharArray>,
    point: Point,
    word: String,
    index: Int,
    currentSet: MutableSet<Point>,
    currentDirect: Int,
    width: Int,
    height: Int
): Boolean {
    if (board[point.y][point.x] == word[index]) {

        val originSize = currentSet.size
        currentSet.add(point)
        if (originSize == currentSet.size) {
            return false
        }

        if (index == word.length - 1) {
            return true
        }

        val list = getAccessPointList(point, width, height, currentDirect)
        for (item in list) {
            if (!dfs(board, item, word, index + 1, currentSet, getDirection(point, item), width, height)) {
                continue
            } else {
                return true
            }
        }

        currentSet.remove(point)
        return false

    } else {
        return false
    }

}

fun getAccessPointList(currentLocation: Point, width: Int, height: Int, direction: Int): List<Point> {
    val list = ArrayList<Point>()

    if (currentLocation.x - 1 >= 0) {
        if (direction != 4) {
            list.add(Point(currentLocation.x - 1, currentLocation.y))
        }
    }

    if (currentLocation.x + 1 < width) {
        if (direction != 2) {
            list.add(Point(currentLocation.x + 1, currentLocation.y))
        }
    }

    if (currentLocation.y - 1 >= 0) {
        if (direction != 1) {
            list.add(Point(currentLocation.x, currentLocation.y - 1))
        }
    }

    if (currentLocation.y + 1 < height) {
        if (direction != 3) {
            list.add(Point(currentLocation.x, currentLocation.y + 1))
        }
    }

    return list
}

fun getDirection(point: Point, nextPoint: Point): Int {
    if (nextPoint.y + 1 == point.y) {
        return 3
    }

    if (nextPoint.x - 1 == point.x) {
        return 4
    }

    if (nextPoint.y - 1 == point.y) {
        return 1
    }

    if (nextPoint.x + 1 == point.x) {
        return 2
    }

    return 0
}

fun getFirstPointList(board: Array<CharArray>, firstChar: Char): List<Point> {
    val list = ArrayList<Point>()
    for (i in board[0].indices) {
        for (j in board.indices) {
            if (board[j][i] == firstChar) {
                list.add(Point(i, j))
            }
        }
    }

    return list
}


fun main() {
    val row1 = charArrayOf('A', 'B', 'C', 'E')
    val row2 = charArrayOf('S', 'F', 'C', 'S')
    val row3 = charArrayOf('A', 'D', 'E', 'E')

    val board = arrayOf(row1, row2, row3)

    println(exist(board, "ABCCED"))
}