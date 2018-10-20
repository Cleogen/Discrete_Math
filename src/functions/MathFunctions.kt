package functions

import java.math.BigInteger

/**
 * Returns Array List which contains
 * all the digits of given number
 * */
fun digitsOfNumber(x: Int): ArrayList<Int> {
    var num = x
    val nums = arrayListOf<Int>()
    while (num > 0){
        nums.add(0,num % 10)
        num /= 10
    }
    return nums
}

/**
 * Returns count of digits in the given number
 * */
fun numberOfDigits(x: Int): Int {
    var count = 0
    var i = 1
    while (x / i > 0){
        ++count
        i *= 10
    }
    return count
}

/**
 * Returns the factorial of the given number
 */
fun factorial(n: Int): BigInteger = (1..n).multiplyIf { true }

/**
 * Returns count of duplicate digits in number
 * */
fun countOfDuplicateDigits(number: Int): Int {
    val original = digitsOfNumber(number)
    return original.size - original.distinct().size
}

/**
 * Returns true if neighbouring digits are distinct
 * */
fun distinctNeighbour(x: Int): Boolean {
    val a = digitsOfNumber(x)
    for (i in 0..a.size-2)
        if (a[i] == a[i+1])
            return false
    return true
}