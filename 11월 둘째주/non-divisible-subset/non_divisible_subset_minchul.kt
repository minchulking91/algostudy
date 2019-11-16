import kotlin.math.max
import kotlin.math.min

/*
 * Complete the 'nonDivisibleSubset' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER k
 *  2. INTEGER_ARRAY s
 */

fun nonDivisibleSubset(k: Int, s: Array<Int>): Int {
    // Write your code here
    val counts = IntArray(size = k) { 0 }
    s.forEach {
        counts[it.rem(k)]++
    }
    var count = 0
    count += min(counts[0], 1)
    if (k.rem(2) == 0) { //even
        if (counts[k / 2] > 0) {
            count += 1
        }
        (1 until k/2).forEach {
            count += max(counts[it], counts[k-it])
        }
    } else { //odd
        (1 until (k/2)+1).forEach {
            count += max(counts[it], counts[k-it])
        }
    }
    return count
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val s = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = nonDivisibleSubset(k, s)

    println(result)
}
