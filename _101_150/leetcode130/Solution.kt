package _101_150.leetcode130

var width = 0
var height = 0

const val replacement = 'B'

fun solve(board: Array<CharArray>): Unit {
    if (board.isEmpty() || board[0].isEmpty()) {
        return
    }

    width = board[0].size
    height = board.size

    for (i in 0 until width) {
        dfs(board, i, 0)
        dfs(board, i, height - 1)
    }

    for (i in 0 until height) {
        dfs(board, 0, i)
        dfs(board, width - 1, i)
    }

    for (i in 0 until height) {
        for (j in 0 until width) {
            if (board[i][j] == 'O') {
                board[i][j] =  'X'
            } else if (board[i][j] == replacement) {
                board[i][j] = 'O'
            }
        }
    }
}

fun dfs(board: Array<CharArray>, x: Int, y: Int) {
    if (x == -1 || x == width || y == -1 || y == height || board[y][x] != 'O') {
        return
    }

    board[y][x] = replacement
    dfs(board, x - 1, y)
    dfs(board, x, y - 1)
    dfs(board, x + 1, y)
    dfs(board, x, y + 1)
}

fun main() {
    val matrix = Array<CharArray>(4){
        when(it){
            0 -> charArrayOf('X', 'X', 'X', 'X')
            1 -> charArrayOf('X', 'O', 'O', 'X')
            2 -> charArrayOf('X', 'X', 'O', 'X')
            3 -> charArrayOf('X', 'O', 'X', 'X')
            else -> charArrayOf('X', 'X', 'X', 'X')
        }
    }

    solve(matrix)

    println(matrix)
}