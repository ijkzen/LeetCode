package _101_150.leetcode146


class LRUCache(capacity: Int) {

    var totalSize: Int = capacity
    val map = HashMap<Int, Int>()
    private val timeMap = HashMap<Int, Long>()

    fun get(key: Int): Int {
        if (map[key] == null) {
            return -1
        } else {
            timeMap[key] = getCurrentTime()
            return map[key]!!
        }
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key) || map.size < totalSize) {
            map[key] = value
            timeMap[key] = getCurrentTime()
        } else {
            var tmp: MutableMap.MutableEntry<Int, Long>? = null
            for (entry in timeMap.entries) {
                if (tmp == null || entry.value <= tmp.value) {
                    tmp = entry
                }
            }

            timeMap.remove(tmp?.key)
            map.remove(tmp?.key)

            map[key] = value
            timeMap[key] = getCurrentTime()
        }
    }

}

fun getCurrentTime() = System.nanoTime()

fun main() {
    val obj = LRUCache(2)
    obj.put(2, 1)
    obj.put(1, 1)
    obj.get(2)
    obj.put(4, 1)
    obj.get(1)
    obj.get(2)
}
