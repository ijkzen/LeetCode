package _2001_2050.leetcode2024

data class AnswerGroup(
    val left: Int = 0,
    var right: Int = 0,
    val type: Boolean = false
) {
    val size
        get() = right - left + 1
}

fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
    if (answerKey == "") {
        return 0
    }

    val trueGroup = mutableListOf<AnswerGroup>()
    val falseGroup = mutableListOf<AnswerGroup>()

    var prefixAnswer: Char? = null

    for (answer in answerKey.withIndex()) {
        if (answer.value == prefixAnswer) {
            val last = if (prefixAnswer == 'T') {
                trueGroup.last()
            } else {
                falseGroup.last()
            }

            last.right = answer.index

        } else {
            val group = AnswerGroup(
                answer.index,
                answer.index,
                type = answer.value == 'T'
            )

            if (group.type) {
                trueGroup.add(group)
            } else {
                falseGroup.add(group)
            }
        }
        prefixAnswer = answer.value
    }

    var max = 0
    for (i in 0 until trueGroup.size) {
        val value = partAnswer(trueGroup, i, k, answerKey.length)
        if (value > max) {
            max = value
        }
    }

    for (i in 0 until falseGroup.size) {
        val value = partAnswer(falseGroup, i, k, answerKey.length)
        if (value > max) {
            max = value
        }
    }


    return max
}

private fun partAnswer(list: List<AnswerGroup>, start: Int, k: Int, length: Int): Int {
    if (start == list.size - 1) {
        return list[start].size + (Math.min((length - list[start].size), k))
    }

    var operator = k
    var startIndex = start
    val origin = list[start]
    var totalSize = origin.size


    while (operator > 0 && startIndex < list.size - 1) {
        val current = list[startIndex]
        val next = list[startIndex + 1]
        val distance = (next.left - current.right - 1)
        if (distance <= operator) {
            operator -= distance
            totalSize += (next.size + distance)
            startIndex++
        } else {
            totalSize += operator
            operator = 0
            break
        }
    }

    if (operator > 0) {
        totalSize += Math.min(length - totalSize, operator)
    }


    return totalSize
}

fun main() {
    val answerKey = "TTFTFTTTTFTFFTFFFTTFFTFFFFFFTTTFTFFTTFTTFFTFTTFFTFTFFTFTFTTFTFTTTFFTFFTTTFTTFTFTFTTTFFTTFTTTFFTFTFTT"
    println(maxConsecutiveAnswers(answerKey, 34))
}
