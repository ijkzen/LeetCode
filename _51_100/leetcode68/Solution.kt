package _51_100.leetcode68

fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
    val result = ArrayList<String>()
    val finalResult: WordsResult
    var middleResult = WordsResult(0, 0)
    var currentIndex = 0
    while (true) {
        currentIndex += middleResult.size
        middleResult = getWordsSize(words, currentIndex, maxWidth)

        if (currentIndex + middleResult.size == words.size) {
            finalResult = middleResult
            break
        }

        if (middleResult.size == 1) {
            val builder = StringBuilder()
            builder.append(words[currentIndex])
            for (i in 0 until (maxWidth - middleResult.allWidth)) {
                builder.append(" ")
            }
            result.add(builder.toString())
        } else if (middleResult.size > 1) {
            val builder = StringBuilder()
            for (i in 0 until middleResult.size) {
                builder.append(words[currentIndex + i])
                if (i < middleResult.size - 1) {
                    val spaceWidth = getSpaceWidth(middleResult, maxWidth, i)
                    for (j in 0 until spaceWidth) {
                        builder.append(" ")
                    }
                }
            }

            result.add(builder.toString())
        }
    }
    val builder = StringBuilder()
    for (i in 0 until finalResult.size) {
        builder.append(words[currentIndex + i])
        if (i < finalResult.size - 1) {
            builder.append(" ")
        }
    }
    val leftWidth = maxWidth - builder.length
    for (i in 0 until leftWidth) {
        builder.append(" ")
    }
    result.add(builder.toString())

    return result
}

data class WordsResult(val size: Int, val allWidth: Int)

fun getWordsSize(words: Array<String>, index: Int, maxWidth: Int): WordsResult {

    var count = 0
    var currentWidth = 0
    for (i in index until words.size) {
        if (words[i].length + currentWidth + count > maxWidth) {
            break
        } else {
            currentWidth += words[i].length
            count++
        }
    }

    return WordsResult(count, currentWidth)
}

fun getSpaceWidth(wordsResult: WordsResult, maxWidth: Int, index: Int): Int {
    val spaceNumber = if (wordsResult.size == 1) 1 else wordsResult.size - 1
    val spaceAllWidth = maxWidth - wordsResult.allWidth
    val mod = spaceAllWidth % spaceNumber
    return if (mod == 0) {
        spaceAllWidth / spaceNumber
    } else {
        when {
            index < mod -> {
                (spaceAllWidth / spaceNumber) + 1
            }
            index < spaceNumber -> {
                spaceAllWidth / spaceNumber
            }
            else -> {
                throw ArrayIndexOutOfBoundsException("No.$index space not exist")
            }
        }
    }
}

fun main() {
    val words = arrayOf("ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country")
    println(fullJustify(words, 16))
}