import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.math.absoluteValue
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the maxMin function below.
fun maxMin(k: Int, arr: Array<Int>): Int {
    val sorted = arr.sorted()
    val unfairness = mutableListOf<Int>()
    (0 .. (sorted.size-k)).forEach {
        unfairness.add((sorted[it]-sorted[it+k-1]).absoluteValue)
    }
    return unfairness.min()!!
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val k = scan.nextLine().trim().toInt()

    val arr = Array<Int>(n, { 0 })
    for (i in 0 until n) {
        val arrItem = scan.nextLine().trim().toInt()
        arr[i] = arrItem
    }

    val result = maxMin(k, arr)

    println(result)
}
