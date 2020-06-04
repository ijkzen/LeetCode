package one_h.leetcode49

fun groupAnagrams(strs: Array<String>): List<List<String>> {

    val result: MutableList<MutableList<String>> = ArrayList()
    val listMap = ArrayList<MutableList<Char>>()
    val resultMap = HashMap<Int, ArrayList<String>>()

    strs.forEach {
        listMap.add(it.toMutableList())
    }

    for (i in strs.indices) {
        for (item in listMap.withIndex()) {
            val tmpItem = ArrayList(item.value)

            if (tmpItem.isEmpty()) {
                if (strs[i] != "") {
                    continue
                }
            }

            if (tmpItem.size != strs[i].length) {
                continue
            }

            for (char in strs[i]) {
                tmpItem.remove(char)
            }
            if (tmpItem.isEmpty()) {
                if (resultMap[item.index] == null) {
                    val itemList = ArrayList<String>()
                    itemList.add(strs[i])
                    resultMap[item.index] = itemList
                } else {
                    resultMap[item.index]!!.add(strs[i])
                }
                break
            } else {
                continue
            }
        }
    }

    for (list in resultMap.values) {
        result.add(list)
    }
    return result
}

fun main() {
    val strs = arrayOf("tea","and","ace","ad","eat","dans")
    val current = System.currentTimeMillis()
    println(groupAnagrams(strs))
    println("${System.currentTimeMillis() - current} ms")
}