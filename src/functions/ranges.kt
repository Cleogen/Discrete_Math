package functions

import java.math.BigInteger

/**
 * Returns the product of all the numbers
 * from iterable that matches the given predicate
 * */
inline fun <Number> Iterable<Number>.multiplyIf(predicate: (Number) -> Boolean): BigInteger {
    var result: BigInteger = BigInteger.ONE
    for (element in this) {
        if (predicate(element))
            result *= BigInteger(element.toString())
    }
    return result
}