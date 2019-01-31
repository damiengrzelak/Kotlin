package usage

fun multiplyMatrixByVector(firstMatrix: Array<List<Double>>, secondMatrix: Array<Double>): ArrayList<ArrayList<Double>> {
    var row: ArrayList<Double>
    val resultList: ArrayList<ArrayList<Double>> = arrayListOf()

    for (i in 0..2) {
        row = arrayListOf()
        for (j in 0..2) {
            row.add(j, firstMatrix[i][j].times(secondMatrix[j]))
        }
        resultList.add(i, row)
    }
    return resultList
}

fun ArrayList<ArrayList<Double>>.showMatrixForm() {
    for (i in 0..2) {
        for (j in 0..2) {
            if (j % 3 != 0) {
                print("" + this[i][j] + " ")
            } else {
                print("\n" + this[i][j] + " ")
            }
        }
    }
}

fun ArrayList<ArrayList<Double>>.swapPositions(swapFrom: Int, swapTo: Int) {
    val swapFromList = this[swapFrom]
    val swapToList = this[swapTo]

    this[swapFrom] = swapToList
    this[swapTo] = swapFromList
}

fun Array<Double>.swapPositions(swapFrom: Int, swapTo: Int) {
    val temp = this[swapFrom]

    this[swapFrom] = this[swapTo]
    this[swapTo] = temp
}

fun Double.round(): Double {
    var value = this
    val PLACES = 2

    val factor = Math.pow(10.0, PLACES.toDouble()).toLong()
    value *= factor
    val tmp = Math.round(value)
    return tmp.toDouble() / factor
}

fun <T> Array<T>.showMatrixForm() {
    for (i in 0..2) {
        print("\n" + this[i] + " ")
    }
}