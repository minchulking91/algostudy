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
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*
import kotlin.math.*

fun lotate(s:IntArray):IntArray{
    return intArrayOf(s[2], s[5], s[8], s[1], s[4], s[7], s[0], s[3], s[6])
}
//calc normal, rotate90, rotate180, rotate 270
fun calcDiffWithRotate(s:IntArray, magicSquare:IntArray):Int{
    var minValue = Int.MAX_VALUE
    var square = magicSquare
    (0 until 4).forEach{ index->
        minValue = min(minValue, calcDiff(s, square))
        square = lotate(square)
    }
    return minValue
}

fun calcDiff(s:IntArray, magicSquare:IntArray):Int{
    var sum = 0
    (0 until 9).forEach{ index->
        sum += (s[index]-magicSquare[index]).absoluteValue
    }
    return sum
}
// Complete the formingMagicSquare function below.
fun formingMagicSquare(s: Array<Array<Int>>): Int {
    /**
    type1
    4 9 2
    3 5 7
    8 1 6
    ...type16 (Normal, Left-Right, Bottom-Up, Both) * (Normal, Rotate90, Rotate180, Rotate270)
     */
    val magicSquares = arrayOf(
        intArrayOf(4,9,2,3,5,7,8,1,6),
        intArrayOf(2,9,4,7,5,3,6,1,8),
        intArrayOf(8,1,6,3,5,7,4,9,2),
        intArrayOf(6,1,8,7,5,3,2,9,4)
    )
    //calculate diff
    val inputStream = s.flatMap { it.asIterable() }.toIntArray()
    return magicSquares.map{
        calcDiffWithRotate(inputStream, it)
    }.min()!!
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = Array<Array<Int>>(3, { Array<Int>(3, { 0 }) })

    for (i in 0 until 3) {
        s[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = formingMagicSquare(s)

    println(result)
}
