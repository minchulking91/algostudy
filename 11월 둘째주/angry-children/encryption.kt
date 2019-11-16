import java.util.*
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

/**
 * 3, 4 => 12
 * 0,4,8,(12)
 * 1,5,9,(13)
 * 2,6,10,(14)
 * 3,7,11,(15)
 *
 * 0 1 2 3 4 5 6 7 8  9 10 11
 * 0 4 8 1 5 9 2 6 10 3  7 11
 *
 */
// Complete the encryption function below.
fun encryption(s: String): String {
    val length = s.length
    val (row, col) = sqrt(length.toFloat()).let {
        val low = floor(it).toInt()
        val high = ceil(it).toInt()
        if (low * high >= length) {
            low to high
        }else{
            high to high
        }
    }
    val builder = StringBuilder()
    (0 until (row * col)).forEach { index ->
        val encryptionIndex = (index.rem(row) * col) + index / row
        s.getOrNull(encryptionIndex)?.let {
            builder.append(it)
        }
        if (index.rem(row) == row - 1) {
            builder.append(" ")
        }
    }
    return builder.toString()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = encryption(s)

    println(result)
}
