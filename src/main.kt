import combinatorics.countOfNumbers
import combinatorics.countOfQueues
import functions.countOfDuplicateDigits
import functions.digitsOfNumber
import functions.distinctNeighbour

fun main(args: Array<String>) {
    println(
            countOfQueues(listOf("T1","T2","T3","T4","T5","A1","A2","A3","A4","A5","A6"),
                    arrayOf(
                            {x -> x.split(',',limit = 5).count{ "T" in it} == 5}
                    ))
    )
}
