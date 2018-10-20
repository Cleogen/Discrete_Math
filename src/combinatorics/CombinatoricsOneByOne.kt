package combinatorics

import functions.digitsOfNumber
import functions.factorial
import functions.numberOfDigits
import java.math.BigInteger

/**
 * Returns count of occurrences of number 'x' at the end of 'n'
 */
fun countOfnEnd(n: BigInteger, x: Int): Int {
    var number = n
    var count = 0
    while (number % BigInteger.TEN == x.toBigInteger()) {
        ++count
        number /= BigInteger.TEN
    }
    return count
}

/**
 * Returns count of how many times given
 * digits have occurred in the given range
 * */
fun countOfWrittenDigits(range: Iterable<Int>, n: Array<Int> = arrayOf(0,1,2,3,4,5,6,7,8,9)): Int {
    var count = 0
    for (i in range)
        for (j in digitsOfNumber(i))
            if (j in n)
                ++count
    return count
}

/**
 * Returns nth digit in the given range of numbers
 * */
fun nthDigit(n: Int, range: Iterable<Int> = (1..Int.MAX_VALUE) ): Int? {
    var i = 0
    var digit:Int? = null

    main@ for (j in range) {
        i += numberOfDigits(j)
        if (i >= n){
            i -= numberOfDigits(j)
            for (k in digitsOfNumber(j).reversed()){
                if (++i == n){
                    digit = k
                    break@main
                }
            }
        }
    }

    return digit
}

/**
 * Returns the count of possible ways
 * to distribute 'n' objects between X , Y and Z
 * such that Y and Z get equal number of objects
 */
fun nToXYZ(n: Long): Int {
    return (1..n).count { (n-it) % 2L == 0L }
    /*
    var count = 0
        for (i in 1..n)
            if ((n-i) % 2 == 0 )
                ++count
        return count
    */
}

/**
 * Returns the count of n digit numbers
 * that matches to the given conditions
 * */
fun countOfNumbers(n: Int, conditions: Array<(Int) -> Boolean>): Int {
    var max = 1
    repeat(n) {max *= 10}
    val min = max--/10
    var count = 0
    for (num in (min..max))
            if (conditions.all { it(num) })
                ++count
    return count
}

/**
 * Returns the count of possible queues
 * using the given set of objects
 * that matches given conditions
 * */
fun countOfQueues(elements:List<String>, conditions: Array<(String) -> Boolean>): Int {
    var count = 0
    fun recursivePermutations(elems: List<String>, current:String){
        for (i in elems){
            val a = "$current$i,"
            if (elems.size == 1) {
                if (conditions.all { it(a) }) {
                    ++count
                }
            }
            else {
                recursivePermutations(elems.filter { it != i }, a)
            }
        }
    }
    recursivePermutations(elements,"")
    return count
}