import usage.*

/*
*   DAMIAN GRZELAK
*
* 6. Solve numerically Eq.(B) by Gauss-Jordan elimination
*    _               _   _     _         _     _
*   | 1     2       3 | |   x   |       |   2   |
*   |                 | |       |       |       |
*   | 5     3       1 | |   y   |   =   |   3   |
*   |                 | |       |       |       |
*   | 2     3       1 | |   z   |       |  -1   |
 *   -              -    -     -         -     -
* */
private val firstMatrix = arrayOf(listOf(1.0, 2.0, 3.0), listOf(5.0, 3.0, 1.0), listOf(2.0, 3.0, 1.0))
//to test matrix below

//array represent of [x, y, z] vector
private val secondMatrix = arrayOf(1.0, 1.0, 1.0)
private var resultVector = arrayOf(2.0, 3.0, -1.0)

/*
-----TEST DATA----

private val firstMatrix = arrayOf(listOf(80.0, -20.0, -20.0), listOf(-20.0, 40.0, -20.0), listOf(-20.0, -20.0, 130.0))
private var resultVector = arrayOf(20.0, 20.0, 20.0)

verson 2 :
private val firstMatrix = arrayOf(listOf(1.0, 3.0, 1.0), listOf(1.0, -2.0, -1.0), listOf(2.0, 1.0, 2.0))
private var resultVector = arrayOf(10.0, -6.0, 10.0)

It should be x = 1, y = 2, z = 3
*/

fun main(args: Array<String>) {
    print("Input data are: \n A =")
    firstMatrix.showMatrixForm()
    print("\n\nB =")
    secondMatrix.showMatrixForm()
    print("\n\nX =")
    resultVector.showMatrixForm()
    print("\n\n")

    val newMatrix = multiplyMatrixByVector(firstMatrix, secondMatrix)

    for (i in 0..2) {
        for (j in 0..2) {
            if (i == j) {
                if (newMatrix[i][j] != 1.0) {
                    reduceToOne(newMatrix, newMatrix[i][j], i, resultVector[i])
                    reduceToZeroBelow(newMatrix, i)
                } else {
                    reduceToZeroBelow(newMatrix, i)
                }
            }
        }
    }
    print("The results are:\n" + "x = " + resultVector[0] + ", \t y = " + +resultVector[1] + ",\t z = " + resultVector[2])

    print("\n\n")

}

fun reduceToOne(newMatrix: ArrayList<ArrayList<Double>>, valueOfReduce: Double, rowToReduce: Int, vector: Double): ArrayList<ArrayList<Double>> {
    for (j in 0..2) {
        newMatrix[rowToReduce][j] = (newMatrix[rowToReduce][j] / valueOfReduce).round()
    }
    resultVector[rowToReduce] = (vector / valueOfReduce).round()
    return newMatrix
}

fun reduceToZeroBelow(newMatrix: ArrayList<ArrayList<Double>>, indexOfOne: Int): ArrayList<ArrayList<Double>> {
    if (indexOfOne == 0) {
        for (i in (indexOfOne + 1)..2) {
            val multiplyToHaveZero = newMatrix[i][indexOfOne]
            for (j in 0..2) {
                newMatrix[i][j] = (newMatrix[i][j] - (multiplyToHaveZero * newMatrix[indexOfOne][j])).round()
            }
            resultVector[i] = (resultVector[i] - (multiplyToHaveZero * resultVector[indexOfOne])).round()
        }
        return newMatrix
    } else if (indexOfOne > 0) {
        for (i in 0..2) {
            if (i != indexOfOne) {
                val multiplyToHaveZero = newMatrix[i][indexOfOne]
                for (j in indexOfOne..2) {
                    newMatrix[i][j] = (newMatrix[i][j] - (multiplyToHaveZero * newMatrix[indexOfOne][j])).round()
                }
                if (i != indexOfOne) {
                    resultVector[i] = (resultVector[i] - (multiplyToHaveZero * resultVector[indexOfOne])).round()
                }

            }
        }
        return newMatrix
    }
    return newMatrix
}