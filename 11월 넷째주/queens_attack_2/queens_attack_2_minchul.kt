import java.util.*
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

enum class Direction {
    TOP, TOP_LEFT, TOP_RIGHT, LEFT, RIGHT, BOTTOM, BOTTOM_LEFT, BOTTOM_RIGHT
}

fun getDistanceConstant(x1: Int, y1: Int, x2: Int, y2: Int): Int {
    return (x1 - x2).absoluteValue + (y1 - y2).absoluteValue
}

fun getSquaresFromObstacle(r_q: Int, c_q: Int, r_o: Int, c_o: Int): Int {
    return max((r_q - r_o).absoluteValue, (c_q - c_o).absoluteValue) - 1
}

fun getSquaresFromWall(direction: Direction, r_q: Int, c_q: Int, size: Int): Int {
    return when (direction) {
        Direction.TOP -> size - r_q
        Direction.TOP_LEFT -> min(size - r_q, c_q - 1)
        Direction.TOP_RIGHT -> min(size - r_q, size - c_q)
        Direction.LEFT -> c_q - 1
        Direction.RIGHT -> size - c_q
        Direction.BOTTOM -> r_q - 1
        Direction.BOTTOM_LEFT -> min(r_q - 1, c_q - 1)
        Direction.BOTTOM_RIGHT -> min(r_q - 1, size - c_q)
    }
}

// Complete the queensAttack function below.
/**
 * queens range
 * r_q + c_q == x+y
 * r_q - c_q == x-y
 * r_q == x
 * c_q == y
 */
fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array<Array<Int>>): Int {
    return obstacles.filter { (r, c) ->
        r + c == r_q + c_q || r - c == r_q - c_q || r_q == r || c_q == c
    }.groupBy { (r, c) ->
        when {
            r + c == r_q + c_q -> {
                if (r < r_q) Direction.BOTTOM_RIGHT
                else Direction.TOP_LEFT
            }
            r - c == r_q - c_q -> {
                if (r < r_q) Direction.BOTTOM_LEFT
                else Direction.TOP_RIGHT
            }
            r_q == r -> {
                if (c < c_q) Direction.LEFT
                else Direction.RIGHT
            }
            else -> {
                if (r < r_q) Direction.BOTTOM
                else Direction.TOP
            }
        }
    }.let { map ->
        val mutableMap = map.toMutableMap()
        Direction.values().forEach {
            if (!mutableMap.containsKey(it)) {
                mutableMap.put(it, emptyList())
            }
        }
        mutableMap.toMap()
    }.map { (direction, pairList) ->
        //find nearest obstacle from the queen each direction
        val nearestObstacle = pairList.minBy { (x, y) ->
            getDistanceConstant(r_q, c_q, x, y)
        }
        nearestObstacle?.let { (r_o, c_o) ->
            getSquaresFromObstacle(r_q, c_q, r_o, c_o)
        } ?: getSquaresFromWall(direction, r_q, c_q, n)
    }.sum()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val r_qC_q = scan.nextLine().split(" ")

    val r_q = r_qC_q[0].trim().toInt()

    val c_q = r_qC_q[1].trim().toInt()

    val obstacles = Array<Array<Int>>(k, { Array<Int>(2, { 0 }) })

    for (i in 0 until k) {
        obstacles[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = queensAttack(n, k, r_q, c_q, obstacles)

    println(result)
}
