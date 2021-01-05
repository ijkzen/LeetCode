package _1_50.leetcode37

data class Point(val x: Int, val y: Int)

data class PreviousResult(val candidates: List<Char>, var candidateIndex: Int)

fun solveSudoku(board: Array<CharArray>): Unit {
    val points = getSpacePoints(board)
    var pointIndex = 0
    val previousResultMap = HashMap<Int, PreviousResult>()
    while (pointIndex < points.size) {
        val point = points[pointIndex]
        board[point.x][point.y] = '.'

        var previousResult = previousResultMap[pointIndex]
        if (previousResult == null) {
            val candidates = getCandidateList(board, point.x, point.y)

            if (candidates.isEmpty()) {
                pointIndex--
                for (tmp in (pointIndex + 1) until points.size) {
                    previousResultMap.remove(tmp)
                }
            } else {
                previousResult = PreviousResult(candidates, 0)
                board[point.x][point.y] = previousResult.candidates[previousResult.candidateIndex]
                previousResultMap[pointIndex] = previousResult
                pointIndex++
            }
        } else {
            if (previousResult.candidateIndex + 1 >= previousResult.candidates.size) {
                pointIndex--
                for (tmp in (pointIndex + 1) until points.size) {
                    previousResultMap.remove(tmp)
                }
            } else {
                previousResult.candidateIndex = previousResult.candidateIndex + 1
                board[point.x][point.y] = previousResult.candidates[previousResult.candidateIndex]
                pointIndex++
            }
        }
    }
}

fun getSpacePoints(board: Array<CharArray>): List<Point> {
    val result = ArrayList<Point>()
    for (i in 0 until 9) {
        for (j in 0 until 9) {
            if (board[i][j] == '.') {
                result.add(Point(i, j))
            }
        }
    }

    return result
}

fun getCandidateList(board: Array<CharArray>, i: Int, j: Int): List<Char> {
    if (board[i][j] != '.') {
        return ArrayList<Char>()
    }

    val rowContent: MutableList<Char> = board[i].toMutableList()
    val colContent: MutableList<Char> = ArrayList<Char>()
    val subContent: MutableList<Char> = ArrayList<Char>()

    rowContent.removeIf { it == '.' }

    for (index in 0 until 9) {
        colContent.add(board[index][j])
    }
    colContent.removeIf { it == '.' }

    val subIndex = (i / 3) * 3 + j / 3
    for (subX in 0 until 3) {
        for (subY in 0 until 3) {
            val x: Int = (subIndex / 3) * 3 + subX
            val y: Int = (subIndex % 3) * 3 + subY
            subContent.add(board[x][y])
        }
    }
    subContent.removeIf { it == '.' }

    val result = arrayListOf<Char>('1', '2', '3', '4', '5', '6', '7', '8', '9')
    result.removeAll(rowContent)
    result.removeAll(colContent)
    result.removeAll(subContent)

    return result
}

fun CharArray.string(): String {
    val builder = StringBuilder()
    for (char in this) {
        builder.append(char)
        builder.append(',')
    }
    return builder.toString()
}

fun main() {
    val sudoku = Array<CharArray>(9) {
        when (it) {
            0 -> {
                charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.')
            }
            1 -> {
                charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.')
            }
            2 -> {
                charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.')
            }
            3 -> {
                charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3')
            }
            4 -> {
                charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1')
            }
            5 -> {
                charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6')
            }
            6 -> {
                charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.')
            }
            7 -> {
                charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5')
            }
            8 -> {
                charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
            }
            else -> {
                charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
            }
        }
    }
    solveSudoku(sudoku)
    for (i in 0 until 9) {
        println(sudoku[i].string())
    }
}