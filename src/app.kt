import usage.*
/*
*
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
private val firstMatrix = arrayOf(listOf(1, 1, 3), listOf(5, 3, 1), listOf(2, 3, 1))
//array represent of [x, y, z] vector
private val secondMatrix = arrayOf(1, 1, 1)
private var resultVector = arrayOf(2,3,-1)

fun main(args: Array<String>) {
    val newMatrix = multiplyMatrixByVector(firstMatrix, secondMatrix)

    //newMatrix.swapPositions(0,2)
    //newMatrix.showMatrixForm()
    //resultVector.swapPositions(0,2)
    print(""+resultVector[0] + "\n"+ +resultVector[1]+ "\n"+resultVector[2])
}

