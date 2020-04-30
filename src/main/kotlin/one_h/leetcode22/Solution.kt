package one_h.leetcode22

fun generateParenthesis(n: Int): List<String> {

    if (n == 0) {
        return ArrayList()
    }


    val result = ArrayList<String>()

    dfs(result, "", n, n)

    return result
}

private fun dfs(result: MutableList<String>, current: String, left: Int, right: Int) {
    if (left == 0 && right == 0) {
        result.add(current)
        return
    }

    if (left > right) {
        return
    }

    if (left > 0) {
        dfs(result, "$current(", left - 1, right)
    }

    if (right > 0) {
        dfs(result, "$current)", left, right - 1)
    }
}

fun main() {
    println(generateParenthesis(2))
}