package _2001_2050.leetcode2049

/**
 * Your runtime beats 18.52 % of kotlin submissions
 * Your memory usage beats 37.04 % of kotlin submissions (69.5 MB)
 */
data class TreeNode(
    var left: TreeNode? = null,
    var right: TreeNode? = null,
) {
    var size: Long = 0
        get() {
            if (field != 0L){
                return field
            } else {
                val leftSize = left?.size ?: 0L
                val rightSize = right?.size ?: 0L
                field = leftSize + rightSize + 1
                return field
            }
        }
}


fun countHighestScoreNodes(parents: IntArray): Int {
    // 下标 --> 子树 的映射
    val treeNodeMap = hashMapOf<Int, TreeNode>()
    for (i in parents.indices) {
        treeNodeMap[i] = TreeNode()
    }

    for (i in 1 until parents.size) {
        val parentNode = treeNodeMap[parents[i]]
        val childNode = treeNodeMap[i]
        putChild2Tree(parentNode!!, childNode!!)
    }

    treeNodeMap[0]!!.size

    val resultList = mutableListOf<Long>()
    for (i in parents.indices) {
        val rootNode = treeNodeMap[0]!!
        if (parents[i] == -1) {
            val leftSize  :Long = rootNode.left?.size ?: 1L
            val rightSize :Long = rootNode.right?.size ?: 1L
            val result = leftSize * rightSize
            resultList.add(result)
        } else {
            val childNode = treeNodeMap[i]!!
            val rootSize = rootNode.size - childNode.size
            val childLeftSize = childNode.left?.size ?: 1
            val childRightSize = childNode.right?.size ?: 1
            resultList.add(childLeftSize * childRightSize * rootSize)
        }
    }

    val max = resultList.maxOrNull() ?: 0
    return resultList.filter { it == max }.size
}

fun putChild2Tree(parent: TreeNode, child: TreeNode) {
    if (parent.left == null) {
        parent.left = child
    } else {
        parent.right = child
    }
}

fun main() {
    println(countHighestScoreNodes(intArrayOf(-1,2,0,2,0)))
}


