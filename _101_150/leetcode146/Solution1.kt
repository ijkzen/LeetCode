package _101_150.leetcode146

class LRUCache1(capacity: Int) {

    val totalSize = capacity
    val map = HashMap<Int, MyLinkedList.MyLinkedNode>()
    val list = MyLinkedList()

    fun get(key: Int): Int {
        if (map[key] == null) {
            return -1
        } else {
            list.upToHead(map[key]!!)
            return map[key]!!.value
        }
    }

    fun put(key: Int, value: Int) {
        when {
            map.containsKey(key) -> {
                val node = map[key]!!
                node.value = value
                list.upToHead(node)
            }
            map.size < totalSize -> {
                val node = MyLinkedList.MyLinkedNode(key, value)
                map[key] = node
                list.upToHead(node)
            }
            else -> {
                val node = MyLinkedList.MyLinkedNode(key, value)
                val removedKey = list.removeTail()
                map.remove(removedKey)
                list.upToHead(node)
                map[key] = node
            }
        }
    }


    class MyLinkedList {

        var head = MyLinkedNode(Int.MAX_VALUE, Int.MAX_VALUE)
        var tail = MyLinkedNode(Int.MIN_VALUE, Int.MAX_VALUE)

        init {
            head.right = tail
            tail.left = head
        }

        fun upToHead(myLinkedNode: MyLinkedNode) {
            val originRight = myLinkedNode.right
            val originLeft = myLinkedNode.left

            originRight?.left = originLeft
            originLeft?.right = originRight

            myLinkedNode.left = null
            myLinkedNode.right = null

            val originHead = head.right
            head.right = myLinkedNode
            myLinkedNode.left = head
            myLinkedNode.right = originHead
            originHead?.left = myLinkedNode
        }


        fun removeTail(): Int {
            val originTail = tail.left
            tail.left = originTail?.left
            originTail?.left?.right = tail

            return originTail!!.key
        }

        class MyLinkedNode(var key: Int, var value: Int) {
            var left: MyLinkedNode? = null
            var right: MyLinkedNode? = null
        }
    }
}

fun main() {
    val obj = LRUCache1(2)
    obj.put(2, 1)
    obj.put(1, 1)
    obj.put(2, 3)
    obj.put(4, 1)
    obj.get(1)
    obj.get(2)
}