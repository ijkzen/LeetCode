package _2001_2050.leetcode2049

/**
 * Your runtime beats 25.93 % of kotlin submissions
 * Your memory usage beats 70.37 % of kotlin submissions (61.5 MB)
 */
data class TreeNode(
    var left: TreeNode? = null,
    var right: TreeNode? = null
) {
    var size: Long = 0L
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

    fun addChild(child: TreeNode) {
        if (left == null) {
            left = child
        } else {
            right = child
        }
    }
}

fun countHighestScoreNodes(parents: IntArray): Int {
    val treeNodeArray = Array<TreeNode>(parents.size) {
        TreeNode()
    }

    for (i in 1 until parents.size) {
        val parentNode = treeNodeArray[parents[i]]
        val childNode = treeNodeArray[i]
        parentNode.addChild(childNode)
    }

    // 递归初始化 size 属性
    treeNodeArray[0].size

    var maxValue = 0L
    var maxCount = 0
    for (i in parents.indices) {
        val rootNode = treeNodeArray[0]
        if (parents[i] == -1) {
            val leftSize  :Long = rootNode.left?.size ?: 1L
            val rightSize :Long = rootNode.right?.size ?: 1L
            val result = leftSize * rightSize
            if (result > maxValue) {
                maxValue = result
                maxCount = 1
            } else if (result == maxValue) {
                maxCount++
            }
        } else {
            val childNode = treeNodeArray[i]
            val rootSize = rootNode.size - childNode.size
            val childLeftSize = childNode.left?.size ?: 1
            val childRightSize = childNode.right?.size ?: 1
            val result = childLeftSize * childRightSize * rootSize
            if (result > maxValue) {
                maxValue = result
                maxCount = 1
            } else if (result == maxValue) {
                maxCount++
            }
        }
    }

    return maxCount
}

fun main() {
    println(countHighestScoreNodes(intArrayOf(-1,2,0,2,0)))
}


