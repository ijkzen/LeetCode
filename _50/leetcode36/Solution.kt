package _50.leetcode36

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val rows = Array<HashMap<Char, Int>>(9) {
        HashMap<Char, Int>()
    }

    val cols = Array<HashMap<Char, Int>>(9) {
        HashMap<Char, Int>()
    }

    val subs = Array<HashMap<Char, Int>>(9) {
        HashMap<Char, Int>()
    }

    for (i in 0 until 9) {
        for (j in 0 until 9) {
            val subIndex: Int = j / 3 + (i / 3) * 3

            val value = board[i][j]

            if (value != '.') {
                if (rows[i][value] == null) {
                    rows[i][value] = 1
                } else {
                    return false
                }

                if (cols[j][value] == null) {
                    cols[j][value] = 1
                } else {
                    return false
                }

                if (subs[subIndex][value] == null) {
                    subs[subIndex][value] = 1
                } else {
                    return false
                }
            }
        }
    }

    return true
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
    println(isValidSudoku(sudoku))
}