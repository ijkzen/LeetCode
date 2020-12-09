package _101_150.leetcode126

fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {

    if (wordList.isEmpty()) {
        return arrayListOf()
    }

    var length = 0
    val wordId = HashMap<String, Int>()
    val idWord = Array<String>(wordList.size + 1){""}

    while (length < idWord.size) {
        wordId[wordList[length]] = length
        idWord[length] = wordList[length]
        length++
    }
}