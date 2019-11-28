import java.util.*

/**
 * 1. she can give 1, 2, 5 chocolates to all but one colleague. == she take 1, 2, 5 chocolates to one colleague.
 * * Number of chocolates each colleague has call A
 * 2. minus min(A) from all of A
 * 3. take 5 from A where more or equal 5, count 1
 * all element in A is 0~4
 *
 *   | 0|-1|-2|-3|-4
 * 0 | 0| 1| 1| 2| 2
 * 1 | 1| 1| 2| 2| 1
 * 2 | 1| 2| 2| 1| 2
 * 3 | 2| 2| 1| 2| 2
 * 4 | 2| 1| 2| 2| 3
 *
 * ex) 2, 2, 3, 7
 * 0, 0, 1, 5
 * 0, 0, 1, 0) count 1
 *
 * [0, 0, 1, 0]
 * [0, 0, 0, 0] => 1
 * [-1, -1, -1, -1] => 4
 * [-2, -2, -2, -2] => 5
 * [-3, -3, -3, -3] => 8
 * [-4, -4, -4, -4] => 7
 *
 * ex) 10, 7, 12
 * 3, 0, 5
 * 3, 0, 0) count 1
 * [0, 0, 0] => 2
 * [-1, -1, -1] => 4
 * [-2, -2, -2] => 3
 * ...
 *
 */
// Complete the equal function below.
fun equal(arr: Array<Int>): Int {
    val minValue = arr.min() ?: return 0
    var cnt = 0
    val tempArr = arr.map { it - minValue }.map {
        if (it >= 5) {
            cnt += it / 5
            it.rem(5)
        } else {
            it
        }
    }
    val t = arrayOf(
        intArrayOf(0, 1, 1, 2, 2),
        intArrayOf(1, 1, 2, 2, 1),
        intArrayOf(1, 2, 2, 1, 2),
        intArrayOf(2, 2, 1, 2, 2),
        intArrayOf(2, 1, 2, 2, 3)
    )
    cnt += (t.map { array ->
        tempArr.sumBy { array[it] }
    }.min() ?: 0)
    return cnt
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

        val result = equal(arr)

        println(result)
    }
}
