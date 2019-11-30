import java.util.*

fun max(vararg x: Int): Int {
    return x.max() ?: 0
}

// Complete the flippingMatrix function below.
fun flippingMatrix(matrix: Array<Array<Int>>): Int {
    val n = matrix.size / 2
    val k = matrix.size
    var sum = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            sum += max(
                matrix[i][j],
                matrix[k - i - 1][j],
                matrix[i][k - j - 1],
                matrix[k - i - 1][k - j - 1]
            )
        }
    }
    return sum
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val n = scan.nextLine().trim().toInt()

        val matrix = Array<Array<Int>>(2 * n, { Array<Int>(2 * n, { 0 }) })

        for (i in 0 until 2 * n) {
            matrix[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
        }

        val result = flippingMatrix(matrix)

        println(result)
    }
}
