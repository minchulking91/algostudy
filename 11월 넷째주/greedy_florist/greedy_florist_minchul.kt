import java.util.*

// Complete the getMinimumCost function below.
fun getMinimumCost(k: Int, c: Array<Int>): Int {
    return c.sortedDescending().mapIndexed { index, price ->
        (index / k + 1) * price
    }.sum()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val c = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val minimumCost = getMinimumCost(k, c)

    println(minimumCost)
}
