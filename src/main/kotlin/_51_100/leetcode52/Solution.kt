package _51_100.leetcode52

import java.lang.StringBuilder

fun totalNQueens(n: Int): Int {
    return solveNQueens(n).size
}

fun solveNQueens(n: Int): List<List<String>> {
    val result: MutableList<MutableList<String>> = ArrayList()

    val colsLeft: MutableList<Int> = ArrayList()
    for (i in 0 until n) {
        colsLeft.add(i)
    }

    for (firstIndex in 0 until n) {
        queen(createNewBoard(n), 0, firstIndex, ArrayList<Int>(colsLeft), result, Int.MIN_VALUE)
    }

    return result
}

fun queen(
    board: MutableList<MutableList<Char>>,// 棋盘
    rowIndex: Int, // 当前在第几行放置queue
    colsLeftIndex: Int,// 下方集合的当前
    colsLeft: MutableList<Int>, // 当前还没有放置queue的列的集合
    result: MutableList<MutableList<String>>,  // 结果
    lastCol: Int
) {
    println("rowIndex: $rowIndex\ncolsLeft: $colsLeft\ncolsLeftIndex: $colsLeftIndex\n")

    if (colsLeft[colsLeftIndex] == lastCol - 1 || colsLeft[colsLeftIndex] == lastCol + 1) {
        return
    }

    if (isValid(board, rowIndex, colsLeft[colsLeftIndex])) {
        board[rowIndex][colsLeft[colsLeftIndex]] = 'Q'
        if (rowIndex == board.size - 1) {
            val list = ArrayList<String>()
            for (i in board.indices) {
                val builder = StringBuilder()
                for (j in board.indices) {
                    builder.append(board[i][j])
                }
                list.add(builder.toString())
            }
            result.add(list)
            return
        }

        val tmpLeft = ArrayList<Int>(colsLeft)
        tmpLeft.removeAt(colsLeftIndex)
        for (i in 0 until tmpLeft.size) {
            resetRow(board, rowIndex + 1)
            queen(copyBoard(board), rowIndex + 1, i, tmpLeft, result, colsLeft[colsLeftIndex])
        }

    } else {
        return
    }
}

fun createNewBoard(n: Int): MutableList<MutableList<Char>> {
    val board: MutableList<MutableList<Char>> = ArrayList()
    for (i in 0 until n) {
        val list = ArrayList<Char>()
        for (j in 0 until n) {
            list.add('.')
        }
        board.add(list)
    }

    return board
}

fun resetRow(board: MutableList<MutableList<Char>>, rowIndex: Int) {
    for (i in rowIndex until board.size) {
        for (j in 0 until board.size) {
            board[i][j] = '.'
        }
    }
}

data class Point(val x: Int, val y: Int)

fun isValid(board: MutableList<MutableList<Char>>, x: Int, y: Int): Boolean {
    val list = ArrayList<Point>()
    val n = board.size
    var newX = x
    var newY = y
    //left-top
    while (true) {
        newX--
        newY++

        if (newX in 0 until n && newY in 0 until n) {
            list.add(Point(newX, newY))
        } else {
            break
        }
    }

    newX = x
    newY = y
    // right-top
    while (true) {
        newX++
        newY++

        if (newX in 0 until n && newY in 0 until n) {
            list.add(Point(newX, newY))
        } else {
            break
        }
    }

    newX = x
    newY = y
    //left-bottom
    while (true) {
        newX--
        newY--

        if (newX in 0 until n && newY in 0 until n) {
            list.add(Point(newX, newY))
        } else {
            break
        }
    }

    newX = x
    newY = y
    //right-bottom
    while (true) {
        newX++
        newY--

        if (newX in 0 until n && newY in 0 until n) {
            list.add(Point(newX, newY))
        } else {
            break
        }
    }

    for (point in list) {
        if (board[point.x][point.y] == 'Q') {
            return false
        }
    }

    return true
}

fun copyBoard(board: MutableList<MutableList<Char>>): MutableList<MutableList<Char>> {
    return ArrayList(board)
}

fun main() {
    println(totalNQueens(8))
}