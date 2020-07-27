package _51_100.leetcode94

data class TreeNode(var `val`: Int, var left: TreeNode?, var right: TreeNode?)

val list = ArrayList<Int>()

fun inorderTraversal(root: TreeNode?): List<Int> {
    if (root?.left != null) {
        inorderTraversal(root.left)
    }
    if (root != null) {
        list.add(root.`val`)
    }
    if (root?.right != null) {
        inorderTraversal(root.right)
    }

    return list
}

fun main() {
    val root = TreeNode(1, null, TreeNode(2, TreeNode(3, null, null), null))

    println(inorderTraversal(root))
}