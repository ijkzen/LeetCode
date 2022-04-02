package _2001_2050.leetcode2049

data class TreeNode(
    var left: TreeNode? = null,
    var right: TreeNode? = null,
) {
    val size: Long
        get() {
            val leftSize = left?.size ?: 0L
            val rightSize = right?.size ?: 0L
            return leftSize + rightSize + 1
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

    val resultList = mutableListOf<Long>()
    for (i in parents.indices) {
        val rootNode = treeNodeMap[0]!!
        if (parents[i] == -1) {
            val leftSize  :Long = rootNode.left?.size ?: 1L
            val rightSize :Long = rootNode.right?.size ?: 1L
            val result = leftSize * rightSize
            resultList.add(result)
        } else {
            val parentNode = treeNodeMap[parents[i]]!!
            val childNode = treeNodeMap[i]!!
            removeChild(parentNode, childNode)
            val childLeftSize = childNode.left?.size ?: 1
            val childRightSize = childNode.right?.size ?: 1
            resultList.add(childLeftSize * childRightSize * rootNode.size)
            putChild2Tree(parentNode, childNode)
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

fun removeChild(parent: TreeNode, child: TreeNode) {
    if (parent.left == child) {
        parent.left = null
    } else {
        parent.right = null
    }
}

fun main() {
    println(countHighestScoreNodes(intArrayOf(-1,2,0,2,0)))
}


