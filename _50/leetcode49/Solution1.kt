package _50.leetcode49

fun groupAnagrams1(strs: Array<String>): List<List<String>> {
    val map = HashMap<String, MutableList<String>>()

    strs.forEach {
        val tmpList = it.toMutableList()
        tmpList.sort()
        val key = tmpList.toString()
        if (!map.containsKey(key)) {
            map[key] = ArrayList()
        }
        map[key]!!.add(it)
    }

    return ArrayList(map.values)
}

fun main() {
    val strs = arrayOf("tea","and","ace","ad","eat","dans")
    val current = System.currentTimeMillis()
    println(groupAnagrams1(strs))
    println("${System.currentTimeMillis() - current} ms")
}