import java.util.*

/**
 * if length is 2
 * no answer or reversed string
 *
 * if length is bigger then 2
 * check string except first character is biggest
 *  - if biggest, find first character(next original string's first character) and make string smallest
 *  - if not, find string except first character
 */

/**
 * check string is descending
 */
const val NO_ANSWER = "no answer"

fun isBiggestString(w: String): Boolean {
    return (0 until (w.length - 1)).find {
        w[it] < w[it + 1]
    } == null
}
// Complete the biggerIsGreater function below.
fun biggerIsGreater(w: String): String {
    if (isBiggestString(w)) {
        return NO_ANSWER
    }
    if (w.length == 2) {
        if (w[0] == w[1]) {
            return NO_ANSWER
        }
        return w.reversed()
    }
    val firstChar = w[0]
    val w1 = w.substring(1)
    return if (isBiggestString(w1)) {
        val nextFirstChar = StringBuilder(w1).filter { it > firstChar }.minBy { it - firstChar }!! //impossible not null
        val filtered = StringBuilder(w).filter { it != nextFirstChar }
        val c = w.count { it == nextFirstChar }
        val nextString = if (c > 1) {
            val repeated = StringBuilder().append(nextFirstChar).repeat(c - 1)
            StringBuilder(filtered).append(repeated)
        } else {
            StringBuilder(filtered)
        }.toString().toCharArray().sortedArray()
        StringBuilder().append(nextFirstChar).append(nextString).toString()
    } else {
        StringBuilder().append(firstChar).append(biggerIsGreater(w1)).toString()
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val T = scan.nextLine().trim().toInt()

    for (TItr in 1..T) {
        val w = scan.nextLine()

        val result = biggerIsGreater(w)

        println(result)
    }
}
